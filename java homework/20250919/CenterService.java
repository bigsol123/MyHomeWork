package ch8;

import java.util.List;

public class CenterService {

	private CenterDAO dao;

	public CenterService(CenterDAO dao) {
		this.dao = dao;
	}

	/* 🎀
	* 여기 메서드명도 조금 더 생각해 보면, 우리가 저장하려는 대상이 센터일까요, 회원일까요?😸
	* 만약 회원이라면, 어떻게 짓는 게 좀 더 명확할까요?!
	* 메서드명, 변수명, 클래스명 모두 이런 방식으로 생각해 주시면, 더 명확한 네이밍을 지을 수 있게 될 것 같아요.
	* 저도 이 부분은 아직 미숙해서 노력하고 있는 중입니다ㅎㅎ
	*/
	public void addCenter(String name, int number, int skcal, int ckcal) {
		CenterDTO dto = new CenterDTO(name, number, skcal, ckcal);
		dao.save(dto);
	}

	public List<CenterDTO> getAllCenter() {
		return dao.findAll();
	}
}
