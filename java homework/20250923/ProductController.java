package ch2;

import java.util.List;
import java.util.Scanner;

public class ProductController {

	private ProductService service;

	Scanner sc = new Scanner(System.in);

	public ProductController(ProductService service) {
		this.service = service;
	}

	public void run() {

		while (true)

		{
			System.out.println("==============상품을 등록하고 조회================");
			System.out.println("번호 입력  1- 상품등록  2-  전체 상품 조회 3-  개별상품조회 4-  상품삭제 5-  상품 정보 수정 6-  분석 0-  프로그램 종료");

			int z = sc.nextInt();
			sc.nextLine();

			switch (z) {
			case 1:
				System.out.println("상품번호를 입력해주세요.");
				int id = sc.nextInt();
				sc.nextLine();

				System.out.println("상품명을 입력해주세요.");
				String name = sc.nextLine();

				System.out.println("수량을 입력해주세요.");
				int qty = sc.nextInt();
				sc.nextLine();

				System.out.println("가격을 입력해주세요.");
				int price = sc.nextInt();
				sc.nextLine();

				System.out.println("합계는 다음과 같습니다.");
				int total = qty * price;

				System.out.println("Total: " + total + "원");
				service.addProduct(id, name, qty, price, total);
				System.out.println("입력 완료!");
				break;

			case 2:
				List<ProductDTO> products = service.getAllProducts();
				if (products.isEmpty()) {
					System.out.println("입력된 정보가 없습니다.");
				}
				for (ProductDTO dto : products) {
					System.out.println(dto);

				}
				break;

			case 3:
				System.out.println("조회할 상품 번호를 입력해주세요.");
				int search = sc.nextInt();
				sc.nextLine();

				ProductDTO fP = service.getProductAll(search);
				if (fP != null) {
					System.out.println("==조회된 상품의 정보==");
					System.out.println(fP);
				} else {
					System.out.println("다시 조회해주세요.");
				}
				break;

			case 4:
				System.out.println("삭제하려는 상품 번호를 입력하세요.");
				int del = sc.nextInt();
				sc.nextLine();

				if (service.deleteProduct(del)) {
					System.out.println(del + "번 상품이 삭제되었습니다.");
				} else {
					System.out.println("상품이 존재하지 않습니다. 다시 적어주세요.");
				}
				break;

			case 5:
				System.out.println("수정할 상품 번호를 입력해주세요.");
				int modify = sc.nextInt();
				sc.nextLine();

				ProductDTO productNew = service.getProductAll(modify);
				if (productNew != null) {
					System.out.println("현재 상품명 :" + productNew.getName() + " - 새롭운 상품명을 입력하세요.-");
					String newName = sc.nextLine();

					System.out.println("현재 수량 :" + productNew.getQty() + " - 새롭운 수량을 입력하세요.-");
					int newQty = sc.nextInt();
					sc.nextLine();

					System.out.println("현재 가격 :" + productNew.getPrice() + " - 새롭운 가격을 입력하세요.-");
					int newPrice = sc.nextInt();
					sc.nextLine();

					if (service.modifyProduct(modify, newName, newQty, newPrice)) {
						System.out.println(modify + "번 상품 정보가 수정되었습니다.");
					} else {
						System.out.println("상품 정보 수정에 실패했습니다.");
					}
				} else {
					System.out.println(modify + "번 상품은 존재하지 않아 수정할 수 없습니다.");
				}
				break;

			case 6:
				List<ProductDTO> analysis = service.getAllProducts();
				int totalCount = analysis.size();
				int totalOfPrices = 0;

				for (ProductDTO dto : analysis) {
					totalOfPrices += dto.getTotal();
				}
				System.out.println("전체 상품의 개수: " + totalCount + "개");
				System.out.println("전체 상품의 총 가격: " + totalOfPrices + "원");
				break;

			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;

			default:
				System.out.println("번호를 다시 적어주세요.");
			}
		}
	}
}