package ch4;

public class Textbook extends Book {

	private String subject;

	public Textbook(String title, String author, int price, String subject) {
		super(title, author, price);
		this.subject = subject;
		System.out.println("제목: " + title + "과목: " + subject);
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return super.toString() + ", 과목: " + getSubject();
	}
	
	public void showTextbook() {
		showInfo();
		System.out.println("과목:" + getSubject());
	}

}
