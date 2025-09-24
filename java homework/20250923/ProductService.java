package ch2;

import java.util.List;

public class ProductService {

	private ProductDAO dao;

	public ProductService(ProductDAO dao) {
		this.dao = dao;
	}

	public void addProduct(int id, String name, int qty, int price, int total) {
		System.out.println();
		ProductDTO dto = new ProductDTO(id, name, qty, price, total);

		dao.save(dto);

	}

	public List<ProductDTO> getAllProducts() {
		return dao.findAll();
	}
	public ProductDTO getProductAll(int id) {
		return dao.findAll(id);
	}
	
	public boolean deleteProduct(int id) {
		return dao.deleteProduct(id);
	}
	public boolean modifyProduct(int id, String name, int qty, int price) {
		ProductDTO nowProduct = dao.findAll(id);
		if (nowProduct != null) {
			int total = qty * price;
			ProductDTO modifiedDto = new ProductDTO(id, name, qty, price, total);
			return dao.modifyProduct(modifiedDto);
		}
		return false;
	}
}
