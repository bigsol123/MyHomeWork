package ch1;

import java.util.List;
import java.util.Scanner;

public class ScoreController {

	private ScoreService service;
	Scanner sc = new Scanner(System.in);

	public ScoreController(ScoreService service) {
		this.service = service;
	}

	public void run() {

		while (true) {
			System.out.println("번호 입력: 1 - 점수입력, 2- 조회, 3- 학생수, 4- 분석 0- 종료");

			int q = sc.nextInt();
			sc.nextLine();

			switch (q) {
			case 1:
				System.out.println("이름: ");
				String name = sc.nextLine();

				System.out.println("국어: ");
				int kor = sc.nextInt();

				System.out.println("영어: ");
				int eng = sc.nextInt();

				System.out.println("수학: ");
				int math = sc.nextInt();
				sc.nextLine();

				service.addScore(name, kor, eng, math);
				System.out.println("입력 완료");
				break;
			case 2:
				List<ScoreDTO> scores = service.getAllScores();

				/*
				 * for(int i = 0; i < scores.size(); i++) { ScoreDTO dto = scores.get(i);
				 * System.out.println(dto); }
				 */

				if (scores.isEmpty()) {
					System.out.println("저장된 학생 점수가 없습니다.");
				}
				for (ScoreDTO dto : scores) { // 모든 학생 점수 리스트가 저장된 scores에서 순차적으로 꺼내 dto에 담아 출

					System.out.println(dto);
				}
				break;

			case 3:
				int out = service.getAllScores().size();
				System.out.println("전체 등록된 학생의 수는 " + out + "명 입니다.");

				// List<ScoreDTO> score = service.getAllScores();
				// System.out.println("전체 등록된 학생의 수는 " + score.size()+ "명 입니다.");

				break;

			case 4:
				List<ScoreDTO> score = service.getAllScores();
				if (score.isEmpty()) {
					System.out.println("저장된 학생 정보가 없습니다.");
				} else {
					// 최고 총점
					int max = service.getMaxTotal();
					System.out.println("최고 총점은: " + max);

					// 최저 총점
					int min = service.getMinTotal();
					System.out.println("최저 총점은: " + min);
					// 평균 총점
					double avg = service.getAvgTotal();
					System.out.printf("총점 평균은: %.2f", avg); //<= 실수라 f라네요;

				}
				break;

			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;

			default:
				System.out.println("숫자만 입력해주세요. (0 ~ 4)");
			}
		}
	}
}