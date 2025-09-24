package ch2;

public class ProductMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductDAO dao = new ProductDAO();
		ProductService service = new ProductService(dao);
		ProductController controller = new ProductController(service);
		
		controller.run();
	}

} 
