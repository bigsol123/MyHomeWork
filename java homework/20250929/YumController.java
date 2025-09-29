package ch10;

import java.util.List;
import java.util.Scanner;

public class YumController {

		Scanner sc = new Scanner(System.in);
		
		private YumService service;
		public YumController(YumService service) {
			this.service = service;
		}

		public void run() {
			while (true) {
				System.out.println("1:상품등록  2.전체상품조회  3.개별상품조회  4.삭제  5.수정  0.종료");

				int y = sc.nextInt();
				sc.nextLine();

				switch (y) {
					case 1: addYum(); break;
					case 2: outAllYum(); break;
					case 3: outYumById(); break;
					case 4: deleteYum(); break;
					case 5: updateYum();break;
					case 0: System.out.println("프로그램을 종료 하겠습니다."); return;
					default: System.out.println("숫자만 입력하세요.");
				}
			}
		}

		
		private void addYum() {
			System.out.println("상호명을 입력: ");
			String name = sc.nextLine();
			
			System.out.println("방문일을 입력: ex. yyyy-mm-dd ");
			String visitDate  = sc.nextLine();
			
			System.out.println("대표메뉴를 입력: ");
			String menu = sc.nextLine();
			
			System.out.println("평점을 입력: ");
			int rating = sc.nextInt();
			
			service.saveYum(name, visitDate, menu, rating);
			System.out.println("입력 완료");
			
		}
			
		private void outAllYum() {
			List<YumDTO> list = service.getAllYum();
			if (list.isEmpty()) {
				System.out.println("등록된 맛집이 없습니다.");
			} else {
				for (YumDTO dto : list) {
					System.out.println(dto);
					if(dto.getRating() == 5) {
						System.out.println("==여긴 인생 맛집! 친구에게 추천!==");
					}
				}
			}
		}

		private void outYumById() {
			System.out.println("조회할 맛집 번호 입력: ");
			int id = sc.nextInt();

			YumDTO dto = service.getById(id);
			if (dto == null) {
				System.out.println("번호가 없습니다.");
			} else {
				System.out.println(dto);
				if(dto.getRating() == 5) {
					System.out.println("==여긴 인생 맛집! 친구에게 추천!==");
				}
			}
		}

		private void deleteYum() {
			System.out.println("삭제할 번호를 입력하세요: ");
			int id = sc.nextInt();
			if (service.deleteYum(id)) {
				System.out.println("삭제되었습니다.");
			} else {
				System.out.println("입력한 번호가 없습니다.");
			}
			
		}

		private void updateYum() {
			System.out.println("수정할 번호 입력: ");
			int id = sc.nextInt();
			sc.nextLine();

			YumDTO dto = service.getById(id);
			if (dto == null) {
				System.out.println("번호가 없습니다");
				return;
			}
			System.out.println("변경할 상품명(" + dto.getName() + "): ");
			String newName = sc.nextLine();

			System.out.println("변경할 방문일(" + dto.getVisitDate() + "): ");
			String newVisitDate = sc.nextLine();
			
			System.out.println("변경할 메뉴(" + dto.getMenu() + "): ");
			String newMenu = sc.nextLine();
			
			System.out.println("변경할 평점(" + dto.getRating() + "): ");
			int newRating = sc.nextInt();
			sc.nextLine();

			if (service.updateYum(id, newName, newVisitDate, newMenu, newRating)) {
				System.out.println("수정 완료");
			} else {
				System.out.println("수정 실패");
			}
			
		}

	}
