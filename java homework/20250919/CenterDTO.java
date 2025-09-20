package ch8;

public class CenterDTO {

	private String name;
	private int number;
	private int skcal;
	private int ckcal;

	public CenterDTO(String name, int number, int skcal, int ckcal) {

		this.name = name;
		this.number = number;
		this.skcal = skcal;
		this.ckcal = ckcal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getSkcal() {
		return skcal;
	}

	public void setSkcal(int skcal) {
		this.skcal = skcal;
	}

	public int getCkcal() {
		return ckcal;
	}

	public void setCkcal(int ckcal) {
		this.ckcal = ckcal;
	}

	@Override
	public String toString() {
		return "회원명: " + name + "\n회원번호: " + number + "\n 기준칼로리: " + skcal + "\n소비칼로리: " + ckcal;
	}

}