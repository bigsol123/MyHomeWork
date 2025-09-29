package ch10;

import java.util.List;

import ch8.OrderDTO;


public class YumService {
	
	private YumDAO dao;
	
	int nextId;
	
	public YumService(YumDAO dao) {
		this.dao = dao;
		this.nextId = getId() + 1;
	}

	private int getId() {
		int max = 0;
		for(YumDTO dto : dao.findAll()) {
			if(dto.getId() > max) {
				max = dto.getId();
			}
		}
		return max;
	}
	
	public void saveYum(String name, String visitDate, String menu, int rating) {
		YumDTO dto = new YumDTO(nextId, name, visitDate, menu, rating);
		dao.save(dto);
	}

	public List<YumDTO> getAllYum() {
		return dao.findAll();
	}

	public YumDTO getById(int id) {
		return dao.findById(id);
	}

	public boolean deleteYum(int id) {
		return dao.deleteById(id);
	}


	public boolean updateYum(int id, String newName, String newVisitDate, String newMenu, int newRating) {
		YumDTO existYum = dao.findById(id);
	if(existYum != null) {
	
		existYum.setName(newName);
		existYum.setVisitDate(newVisitDate);
		existYum.setMenu(newMenu);
		existYum.setRating(newRating);

	return dao.update(existYum);
	}
	  System.out.println("해당 ID의 주문을 찾을 수 없습니다.");
	
	return false;
	}
}