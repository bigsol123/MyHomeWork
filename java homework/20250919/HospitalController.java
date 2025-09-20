package ch6;

import java.util.List;
import java.util.Scanner;

public class HospitalController {

	Scanner sc = new Scanner(System.in);
		private HospitalService service;
	

		public HospitalController(HospitalService service) {
			this.service = service;
		}

		public void run() {
			while(true) {
		System.out.println("번호를 입력해주세요.");
		System.out.println("1. 병원 등록   2. 환자 조회   3. 프로그램 종료");
			
			int q = sc.nextInt();
			sc.nextLine();
			
			switch (q) {
			case 1:
				System.out.println("아이디: ");
				String id = sc.nextLine();
			
				System.out.println("보호자명: ");
				String name = sc.nextLine();
				
				System.out.println("반려 동물명: ");
				String petname = sc.nextLine();
				
				System.out.println("반려 동물 나이: ");
				int age = sc.nextInt();
				
				System.out.println("연락처: ");
				int phone = sc.nextInt();	
				
				service.addHospital(id, name, petname, age, phone);
				System.out.println("정보 등록 완료");
				break;

			case 2: 
				List<HospitalDTO> hospital = service.getAllHospital();
				if (hospital.isEmpty()) {
					System.out.println("등록된 정보가 없습니다.");
				} else {
					for(HospitalDTO dto : hospital) {
						System.out.println(dto);
					}
				}
				break;
			case 3: System.out.println("프로그램 종료합니다.");
			return;
			
			default:
				System.out.println("다시 입력해주세요.");
			} 
			}
			
		}
}
