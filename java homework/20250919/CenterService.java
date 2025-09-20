package ch8;

import java.util.List;

public class CenterService {

	private CenterDAO dao;

	public CenterService(CenterDAO dao) {
		this.dao = dao;
	}

	public void addCenter(String name, int number, int skcal, int ckcal) {
		CenterDTO dto = new CenterDTO(name, number, skcal, ckcal);
		dao.save(dto);
	}

	public List<CenterDTO> getAllCenter() {
		return dao.findAll();
	}
}