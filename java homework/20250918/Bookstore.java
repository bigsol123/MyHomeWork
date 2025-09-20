package ch4;

public class Bookstore {

	public static void main(String[] args) {
		System.out.println("서점");
			
		Book book1 = new Book("연애의 행방", "히가시노 게이고",15000);
		book1.showInfo();
			
		Textbook subject1 = new Textbook("수학의 정석", "손큰솔", 20000, "수학");
		subject1.showTextbook();
		//Book subject1 = new Textbook("수학의 정석", "손큰솔", 20000, "수학");
		//subject1.showInfo();
			
		Novel Genre1 = new Novel("코난", "손김솔", 12000, "추리");
		Genre1.showNovel();
			
	}

}
