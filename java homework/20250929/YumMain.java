package ch10;

public class YumMain {

	public static void main(String[] args) {
		String filename = "DB/yum.csv";
		YumDAO dao = new YumDAO(filename);
		YumService service = new YumService(dao);
		YumController controller = new YumController(service);
		controller.run();
	}

}