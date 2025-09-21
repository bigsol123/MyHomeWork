package ch7;

public class FoodDTO {

	private int number;
	private String name;
	// 🎀 변수명은 보통 명사형으로 작성하는 게 좋아요! ex) count, quantity, amount ...
	private int many;
	// 🎀 자바에 날짜형을 취급하는 자료형이 있다는 거 아시나요?! Date, LocalDate 등등
	// 나중에는 이 자료형도 활용해 보는 것도 좋을 것 같습니다~
	// 그리고 확실하진 않지만, 날짜 자료형을 안 쓰면 보통 날짜는 String으로 처리했던 것 같아요! 참고만 해 주세요.
	private int date;

	public FoodDTO(int number, String name, int many, int date) {

		this.number = number;
		this.name = name;
		this.many = many;
		this.date = date;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMany() {
		return many;
	}

	public void setMany(int many) {
		this.many = many;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "식자재번호: " + number + "\n식자재명: " + name + "\n수량: " + many + "\n등록날짜: " + date;
	}

}
