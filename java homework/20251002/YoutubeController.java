package ch2;

import java.util.List;
import java.util.Scanner;

public class YoutubeController {

	Scanner sc = new Scanner(System.in);
	private YoutubeService service = new YoutubeService();
	
	public void run() {
		while(true) {
			System.out.println("1. 등록 | 2. 전체조회 | 3. 개별조회 | 4.수정 | 5. 삭제 | 6.종료");
		
			int q = sc.nextInt();
			sc.nextLine();
			
			switch (q) {
			case 1: addYoutube();
				break;
			case 2: getAllYoutube();
				break;
			case 3: getByYoutube();
				break;
			case 4: updateYoutube();
				break;
			case 5: deleteYoutube();
				break;
			case 6: 
					System.out.println("프로그램 종료");
					sc.close();
					return;
			default:
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
	//등록
	private void addYoutube() {
		
	}
	//전체 조회
	private void getAllYoutube() {
		List<YoutubeDTO> list = service.getAllYoutube();
		outYoutubeList(list);
	}

	private void outYoutubeList(List<YoutubeDTO> list) {

		if(list == null || list.isEmpty()) {
			System.out.println("해당 유튜브가 존재하지 않음.");
		} else {
			for(YoutubeDTO dto : list) {
				System.out.println(dto);
			}
		}
	}
	private void getByYoutube() {
		
	}

	private void updateYoutube() {
		
	}

	private void deleteYoutube() {
		
	}

}
