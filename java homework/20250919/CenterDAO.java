package ch8;

import java.util.ArrayList;
import java.util.List;

public class CenterDAO {

	List<CenterDTO> CenterList = new ArrayList<>();

	public void save(CenterDTO dto) {
		CenterList.add(dto);
	}

	public List<CenterDTO> findAll() {
		return CenterList;
	}
}
