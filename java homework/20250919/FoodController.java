/* 🎀
* もしかして、다른 디렉토리의 ch7 패키지에서 작업하다가 여기에 코드 전체 복사하셨나요? 😼
* 여기 적힌 패키지명과 실제 패키지 구조가 달라서 실행할 수 없습니다 !
* 한번 확인해 주세요~
*/
package ch7;

import java.util.List;
import java.util.Scanner;

public class FoodController {

	Scanner sc = new Scanner(System.in);
	private FoodService service;
	
	
	public FoodController(FoodService service) {

		this.service = service;
	}
	public void run() {
		while(true) {
			System.out.println("===식자재 관리 시스템====");
			System.out.println("식자재를 등록해주세요.");
			System.out.println("1. 식자재 등록  2. 등록 조회  3. 프로그램 종료");
			
	int c = sc.nextInt();
	sc.nextLine();
	
	switch (c) {
	case 1 :
		System.out.println("식자재 번호: ");
		int number = sc.nextInt();
		sc.nextLine();
		
		System.out.println("식자재명: ");
		String name = sc.nextLine();
		
		System.out.println("수량: ");
		int many = sc.nextInt();
		sc.nextLine();
		
		System.out.println("등록날짜: ");
		int date = sc.nextInt();
		sc.nextLine();
		
		service.addFood(number, name, many, date);
		System.out.println("정보 등록 완료");
		break;
		
	case 2 :
		List<FoodDTO> food = service.getAllFood();
		if (food.isEmpty()) {
			System.out.println("등록된 정보가 없습니다.");
		} else {
			for(FoodDTO dto : food) {
				System.out.println(dto);
			}
		}
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
