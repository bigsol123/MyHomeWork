package ch1;

public class ScoreMain {
	// 실행
	public static void main(String[] args) {

		ScoreDAO dao = new ScoreDAO();
		ScoreService service = new ScoreService(dao);
		ScoreController controller = new ScoreController(service);

		controller.run();

	}

}
