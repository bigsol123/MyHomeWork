package ch4;

// 🎀 클래스명에 오타가 있어요. ProcutMain -> ProductMain
public class ProcutMain {

	public static void main(String[] args) {
		
		Product m1 = new Product();
		
		m1.setName("기타");
		m1.setPrice(150000);

		// System.out.println(m1); <- 이렇게 써도 동일한 결과가 나와요 😸
		System.out.println(m1.toString());
			
	}

}
