package ch4;

public class Novel extends Book {
		private String genre;

		public Novel(String title, String author, int price, String genre) {
			super(title, author, price);
			this.genre = genre;
		}

		public String getGenre() {
			return genre;
		}

		public void setGenre(String genre) {
			this.genre = genre;
		}
		
		@Override
		public String toString() {
			return super.toString() + ", 장르: " + getGenre();		
		}
	
		public void showNovel() {
				showInfo();
				System.out.println("장르:" + getGenre());
			}
		
		
}