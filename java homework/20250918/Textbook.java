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

	/* 🎀
	* 현재 Textbook과 Novel에서 각각 showTextbook(), showNovel() 메서드를 별도로 만들어 Book의 showInfo()를 호출하고,
	* 각자의 고유 필드(subject, genre)를 추가로 출력하고 있는 형태네요!
	* 이런 방식도 물론 가능하지만, 상위 클래스의 showInfo() 메서드를 만들고,
	* 각 서브클래스에서 이 메서드를 오버라이딩하여 공통 인터페이스를 제공하면 다형성을 좀 더 효과적으로 활용할 수 있습니다 😸
	*
	* 아래는 오버라이딩 예시 코드이니 참고 부탁드려요.
	* (메서드명은 임의로 지은 거니, 더 좋은 이름이 떠오른다면 그걸로 하셔두 됩니당)
	* @Override
	* public void showInfo() {
	* 	super.showInfo();
	* 	System.out.println("과목:  " + getSubject());
	* }
	*
	* 이렇게 하면 Bookstore에서는 아래와 같은 코드 작성이 가능해집니다.
	* Book subject1 = new Textbook("수학의 정석", "손큰솔", 20000, "수학"); // 타입을 상위 클래스인 Book으로 사용 가능해짐
	* subject1.showInfo();
	*/
	public void showTextbook() {
		showInfo();
		System.out.println("과목:" + getSubject());
	}

}
