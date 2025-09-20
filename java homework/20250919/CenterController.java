package ch8;

import java.util.List;
import java.util.Scanner;


public class CenterController {

	/* 🎀
	* 여기도요! 접근제한자를 default로 설정한 이유가 뭘까요?!
	* 뭔가 솔쨩만의 기준이 있는 것 같아서 궁금합니다~😸
	*/
	Scanner sc = new Scanner(System.in);
	private CenterService service;
	
	
	public CenterController(CenterService service) {

		this.service = service;
	}
	public void run() {
		while(true) {
			System.out.println("===체육센터 건강 관리 시스템====");
			System.out.println("회원을 등록해주세요.");
			System.out.println("1. 회원 등록  2. 회원 조회  3. 프로그램 종료");

	/* 🎀
	* 사소한 부분이지만, 변수명은 해당 값이 어떤 의미를 가지는지 드러나도록 짓는 연습을 해 보면 좋아요!
	* int v = sc.nextInt();에서 v는 명령어 값을 입력받고 있으니,
	* command처럼 의도를 쉽게 유추할 수 있는 이름으로 바꿔주면 가독성이 더 좋아질 거예요 ㅎㅎ
	* 제가 지은 변수명이 정답은 아니니 나중에 여유 생기면 솔쨩만의 기준을 세워서 한번 생각해 보세요~~
	*/
	int v = sc.nextInt();
	sc.nextLine();
	
	switch (v) {
	case 1 :
		/* 🎀
		* 이 부분(break;문 전까지)은 메서드로 분리하면 가독성이 더 좋아질 것 같아요!
		* case 2 부분도 마찬가지로 메서드 분리 한 번 해보시죠👍
		*/
		System.out.println("회원명: ");
		String name = sc.nextLine();
		
		System.out.println("회원번호: ");
		int number = sc.nextInt();
		sc.nextLine();
		
		System.out.println("기준 칼로리: ");
		int skcal = sc.nextInt();
		sc.nextLine();
		
		System.out.println("소비 칼로리: ");
		int ckcal = sc.nextInt();
		sc.nextLine();
		
		service.addCenter(name, number, skcal, ckcal);
		System.out.println("정보 등록 완료");
		break;
		
	case 2 :
		List<CenterDTO> center = service.getAllCenter();
		// 🎀 우와 엣지 케이스까지 생각해 주셨네요. 레전드 굿だと思います👍
		if (center.isEmpty()) {
			System.out.println("등록된 정보가 없습니다.");
		} else {
			// 🎀 우와 향상된 for문도 활용해 주셨네요. 👍
			for(CenterDTO dto : center) {
				System.out.println(dto);
			}
		}

		/* 🎀
		* 참고로 이렇게 작성해 볼 수도 있어요.
		* 실행 결과는 똑같고, 코드 스타일의 차이만 있으니 참고만 해주셔요.
		* if (center.isEmpty()) {
			System.out.println("등록된 정보가 없습니다.");
			return;
		* }
		* for(CenterDTO dto : center) {
		* 	System.out.println(dto);
		* }
		*/

		break;
	case 3 :
		System.out.println("시스템을 종료합니다.");
		return;
		
	default:
		System.out.println("다시입력해주세요.");
	}
}
}
}
