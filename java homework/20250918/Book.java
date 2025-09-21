package ch4;

public class Book {

		private String title;
		private String author;
		private int price;
		public Book(String title, String author, int price) {
		
			this.title = title;
			this.author = author;
			this.price = price;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
		
			if (price < 0) {
				System.out.println("가격을 확인해주세요.");
			} else {
				this.price = price;
			}
		}
		
		@Override
		public String toString() {
			return "제목: " + getTitle() + "저자: " + getAuthor() +	"가격: " + getPrice();
		}
		
		public void showInfo() {
			System.out.println("====책정보===");
			System.out.println("제목: " + getTitle());
			System.out.println("저자: " + getAuthor());
			System.out.println("가격: " + getPrice());
			
		}
	
}
