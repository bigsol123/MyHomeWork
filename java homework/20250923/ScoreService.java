package ch1;

import java.util.List;

//총점, 평균, 학점 계산
// DAO에 저장, 조회 요청하는 비즈니스 로직 영역
public class ScoreService {

	private ScoreDAO dao;

	// 의존성 주입 : 외부에서 DAO 객체를 받아와 내부 변수로 저장. 다른 DAO로 교체 용이
	public ScoreService(ScoreDAO dao) {
		this.dao = dao;
	}

	public void addScore(String name, int kor, int eng, int math) {
		System.out.println();
		ScoreDTO dto = new ScoreDTO(name, kor, eng, math);

		int total = kor + eng + math;
		double avg = total / 3.0;
		String grade = getGrade(avg);

		dto.setTotal(total);
		dto.setAvg(avg);
		dto.setGrade(grade);

		dao.save(dto); // ScoreList에 학생 한 명의 데이터 추가
	}

	private String getGrade(double avg) {

		if (avg >= 90)
			return "A";
		else if (avg >= 80)
			return "B";
		else if (avg >= 70)
			return "C";
		else if (avg >= 60)
			return "D";
		else
			return "F";

	}

	// DAO(저장소)에 저장된 모든 학생 점수 정보 리스트 호출
	public List<ScoreDTO> getAllScores() {
		return dao.findAll();
	}

	public int getMaxTotal() {
		// 저장된 학생 정보를 리스트로 받아 옴
		List<ScoreDTO> scores = getAllScores();

		if (scores.isEmpty())
			return 0; // 데이터가 없는 경우

		// 최대값 : 최소값 시작. 이전 값과 비교해 현재 값이 크면 변수에 재할당
		// int min = Integer.MAX_VALUE; //int형이 가질 수 있는 가장 큰 값. 2의 31승
		int max = Integer.MIN_VALUE; // int형이 가질 수 있는 가장 작은 값. -2의 31승
		for (ScoreDTO dto : scores) {
			if (dto.getTotal() > max)
				max = dto.getTotal();
		}
		return max;
	}
	
	public int getMinTotal() {
		
		List<ScoreDTO> scores = getAllScores();
		
		if (scores.isEmpty()) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		for(ScoreDTO dto : scores) {
			if (dto.getTotal() < min ) {
				min = dto.getTotal();
			}
		}
		return min;
	}
	
	public double getAvgTotal() {

		List<ScoreDTO> scores = getAllScores();

		if (scores.isEmpty())
			return 0.0;
		int sum = getSumTotal();
		return sum / scores.size();
	}

	private int getSumTotal() {
		List<ScoreDTO> scores = getAllScores();
		int sum = 0;
		for (ScoreDTO dto : scores) {
			sum += dto.getTotal();
		}
		return sum;
	}

}

/*
 * 상수 한 번 값이 정해지면 절대 변경하지 않는 값 final 키워드 한 번 값을 대입하면 재할당이 안됨 전부 대문자로 작성.
 * _(언더스코어)로 띄어쓰기 대체 MIN_VALUE, PI, DEFAULT_NUM, ...
 * 
 * 공용 상수(어디에서 사용 가능) public static final로 선언 객체 생성없이 클래스 이름으로 접근 가능
 * Integer.MIN_VALUE
 * 
 */