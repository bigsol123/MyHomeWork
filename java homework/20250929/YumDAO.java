package ch10;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class YumDAO {

	private List<YumDTO> yumList;
	private String filename;

	public YumDAO(String filename) {
		this.filename = filename;
		this.yumList = loadCsv(filename);
	}

	private List<YumDTO> loadCsv(String filename) {
		List<YumDTO> list = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

			String line;
			boolean isSkip = true;

			while ((line = br.readLine()) != null) {

				if (isSkip) {
					isSkip = false;
					continue;
				}

				String[] parts = line.split(",");

				int id = Integer.parseInt(parts[0].trim());
				String name = parts[1].trim();
				String visitDate = parts[2].trim();
				String menu = parts[3].trim();
				int rating = Integer.parseInt(parts[4].trim());

				list.add(new YumDTO(id, name, visitDate, menu, rating));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage() + "그 외 모든 오류");
		}

		return list;
	}

	public void save(YumDTO dto) {
		yumList.add(dto);
		writeCsv();
	}

	private void writeCsv() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(filename));
			pw.println("id,name,visitDate,menu,rating");
			for (YumDTO dto : yumList) {
				pw.printf("%d, %s, %s, %s, $d\n", dto.getId(), dto.getName(), dto.getVisitDate(), dto.getMenu(),
						dto.getRating());
			}
		} catch (IOException e) {
			System.out.println("저장 실패: " + e.getMessage());
		} finally {
			pw.close();
		}
	}

	public List<YumDTO> findAll() {
		return yumList;
	}

	public YumDTO findById(int id) {
		return yumList.stream().filter(yum -> yum.getId() == id).findFirst().orElse(null);
	}

	public boolean deleteById(int id) {
		boolean removeYum = yumList.removeIf(yum -> yum.getId() == id);
		if (removeYum)
			writeCsv();
		return removeYum;
	}

	public boolean update(YumDTO updatedDto) {
		for (int i = 0; i < yumList.size(); i++) {
			if (yumList.get(i).getId() == updatedDto.getId()) {
				yumList.set(i, updatedDto);
				writeCsv();
				return true;
			}
		}
		return false;
	}

}