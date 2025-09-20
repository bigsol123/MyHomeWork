package ch6;

import java.util.List;

public class HospitalService {

	private HospitalDAO dao;

	public HospitalService(HospitalDAO dao) {
		this.dao = dao;
	}
	
	public void addHospital(String id, String name, String petname, int age, int phone) {
		HospitalDTO dto = new HospitalDTO(id, name, petname, age, phone);		
		dao.save(dto);
	}
	public List<HospitalDTO> getAllHospital() {
		return dao.findAll();
	}
}
