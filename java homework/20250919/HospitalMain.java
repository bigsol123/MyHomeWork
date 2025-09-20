package ch6;


public class HospitalMain {

	public static void main(String[] args) {
		HospitalDAO dao = new HospitalDAO();
		HospitalService service = new HospitalService(dao);
		HospitalController controller = new HospitalController(service);
		controller.run();

	}

}
