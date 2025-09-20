package ch6;

public class HospitalDTO {

	
	private String id;
	private String name;
	private String petname;
	private int age;
	private int phone;

	public HospitalDTO(String id, String name, String petname, int age, int phone) {

		this.id = id;
		this.name = name;
		this.petname = petname;
		this.age = age;
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPetname() {
		return petname;
	}

	public void setPetname(String petname) {
		this.petname = petname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "아이디: " + id + "\n보호자명: " + name + "\n동물명: " + petname + "\n동물나이: " + age + "\n연락처:" + phone;
	}
	
}
