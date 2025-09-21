package ch7;

import java.util.List;

public class FoodService {

	private FoodDAO dao;

	public FoodService(FoodDAO dao) {
		this.dao = dao;
	}
	
	public void addFood(int number, String name, int many, int date) {
		FoodDTO dto = new FoodDTO(number, name, many, date);		
		dao.save(dto);
	}
	public List<FoodDTO> getAllFood() {
		return dao.findAll();
	}
}

