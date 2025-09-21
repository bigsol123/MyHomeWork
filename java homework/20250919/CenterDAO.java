package ch8;

import java.util.ArrayList;
import java.util.List;

public class CenterDAO {

	/* 🎀
	* 접근제한자를 default로 설정한 이유가 뭘까요?!
	* default와 private의 차이를 알고 계신가요?
	*/
	List<CenterDTO> CenterList = new ArrayList<>();

	public void save(CenterDTO dto) {
		CenterList.add(dto);
	}

	public List<CenterDTO> findAll() {
		return CenterList;
	}
}
