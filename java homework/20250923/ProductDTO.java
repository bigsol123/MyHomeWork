package ch2;

/*
 * 상품 관리 프로그램
 * 1. 상품 등록 : 상품명, 수량, 가격, 상품번호
 * 2. 전체 상품 조회 : 상품번호, 상품명, 수량, 가격, 합계 출력
 * 3. 개별 상품 조회 :  원하는 상품번호 입력시 해당 상품만 조회
 * 4. 상품 삭제 : 삭제할 상품 번호 입력시 해당 상품 삭제
 * 5. 상품 정보 수정 : 수정할 상품 번호 입력시 해당 상품 정보 수정 
 * 6. 분석 : 전체 상품의 수, 전체 상품 가격의 합
 * 0. 프로그램 종료 
 * 
 */
public class ProductDTO {
	private int id; // 상품번호
	private String name; // 상품명
	private int qty; // 수량
	private int price; // 가격
	private int total; // 합계 = qty * price;

	public ProductDTO() {
	}

	public ProductDTO(int id, String name, int qty, int price, int total) {

		this.id = id;
		this.name = name;
		this.qty = qty;
		this.price = price;
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "상품번호: " + id + ", 상품명: " + name + ", 수량: " + qty + ", 가격: " + price + ", 합계: " + total;
	}

}