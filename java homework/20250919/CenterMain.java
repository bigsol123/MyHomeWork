package ch8;


public class CenterMain {

	public static void main(String[] args) {
		CenterDAO dao = new CenterDAO();
		CenterService service = new CenterService(dao);
		CenterController controller = new CenterController(service);
		controller.run();

	}

}