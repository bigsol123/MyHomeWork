package ch7;


public class FoodMailn {

	public static void main(String[] args) {
			FoodDAO dao = new FoodDAO();
			FoodService service = new FoodService(dao);
			FoodController controller = new FoodController(service);
			controller.run();

		}

	}