package ch6;

import java.util.ArrayList;
import java.util.List;

public class HospitalDAO {

	
	List<HospitalDTO> hospitalList = new ArrayList<>();

	public void save(HospitalDTO dto) {
		hospitalList.add(dto);
	}
	public List<HospitalDTO> findAll() {
		return hospitalList;
	}
}
