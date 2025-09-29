package ch8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderDAO {

	private List<OrderDTO> orderList;
	private String filename;
	private AtomicInteger nextId = new AtomicInteger(0);

	public OrderDAO(String filename) {
		this.filename = filename;
		this.orderList = loadCsv(filename);

		this.orderList.stream().mapToInt(OrderDTO::getId).max().ifPresentOrElse(maxId -> nextId.set(maxId + 1),
				() -> nextId.set(1));
	}

	private List<OrderDTO> loadCsv(String filename) {
		List<OrderDTO> list = new ArrayList<>();

		File file = new File(filename);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.err.println("새 CSV 파일 생성 중 오류: " + e.getMessage());
			}
			return list;
		}

		try (BufferedReader br = new BufferedReader(new FileReader(file))) { // try-with-resources
			String line;
			boolean isSkipHeader = true;

			while ((line = br.readLine()) != null) {
				if (isSkipHeader) {
					isSkipHeader = false;
					continue;
				}

				if (line.trim().isEmpty()) {
					continue;
				}

				String[] parts = line.split(",");

				if (parts.length == 5) {
					try {
						int id = Integer.parseInt(parts[0].trim());
						String name = parts[1].trim();
						int price = Integer.parseInt(parts[2].trim());
						int aqty = Integer.parseInt(parts[3].trim());
						int cur = Integer.parseInt(parts[4].trim());
						list.add(new OrderDTO(id, name, price, aqty, cur));
					} catch (NumberFormatException e) {
					}
				} else {
				}
			}
		} catch (IOException e) {

		}
		return list;
	}

	private void writeCsv() {
		try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
			pw.println("id,name,price,aqty,cur");
			for (OrderDTO dto : orderList) {

				pw.printf("%d,%s,%d,%d,%d%n", dto.getId(), dto.getName(), dto.getPrice(), dto.getAqty(), dto.getCur());
			}
		} catch (IOException e) {
			System.out.println("CSV 파일 저장 실패: " + e.getMessage());
		}
	}

	public List<OrderDTO> findAll() {
		return new ArrayList<>(orderList);
	}

	public OrderDTO save(OrderDTO dto) {

		dto.setId(nextId.getAndIncrement());
		orderList.add(dto);
		writeCsv();
		return dto;
	}

	public OrderDTO findById(int id) {
		return orderList.stream().filter(dto -> dto.getId() == id).findFirst().orElse(null);
	}

	public boolean update(OrderDTO updatedDto) {
		for (int i = 0; i < orderList.size(); i++) {
			if (orderList.get(i).getId() == updatedDto.getId()) {
				orderList.set(i, updatedDto);
				writeCsv();
				return true;
			}
		}
		return false;
	}

	public boolean delete(int id) {
		boolean removed = orderList.removeIf(dto -> dto.getId() == id);
		if (removed) {
			writeCsv();
		}
		return removed;
	}
}