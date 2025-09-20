package ch8;

import java.util.List;
import java.util.Scanner;


public class CenterController {

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
			
	int v = sc.nextInt();
	sc.nextLine();
	
	switch (v) {
	case 1 :
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
		if (center.isEmpty()) {
			System.out.println("등록된 정보가 없습니다.");
		} else {
			for(CenterDTO dto : center) {
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