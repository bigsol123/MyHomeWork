package ch7;

public class FoodDTO {

	private int number;
	private String name;
	private int many;
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