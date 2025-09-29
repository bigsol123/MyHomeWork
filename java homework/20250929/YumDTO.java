package ch10;

public class YumDTO {

	private int id;
	private String name;
	private String visitDate;
	private String menu;
	private int rating;

	public YumDTO(int id, String name, String visitDate, String menu, int rating) {
		this.id = id;
		this.name = name;
		this.visitDate = visitDate;
		this.menu = menu;
		this.rating = rating;

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

	public String getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "번호: " + id + "상호명: " + name + ", 방문일: " + visitDate + ", 대표메뉴: " + menu + ", 평점: " + rating;
	}

}
