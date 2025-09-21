package ch7;

import java.util.ArrayList;
import java.util.List;

public class FoodDAO {

		
		List<FoodDTO> FoodList = new ArrayList<>();

		public void save(FoodDTO dto) {
			FoodList.add(dto);
		}
		public List<FoodDTO> findAll() {
			return FoodList;
		}
	}
