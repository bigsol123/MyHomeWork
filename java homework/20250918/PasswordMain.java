package ch4;


public class PasswordMain {

	public static void main(String[] args) {
		
		PasswordData box = new PasswordData();
		
		System.out.println(" 비밀번호 호출");
		
		box.setPassword("abc123");
		System.out.println("내 비밀번호는 " + box.getPassword());
	
		
	}
}
