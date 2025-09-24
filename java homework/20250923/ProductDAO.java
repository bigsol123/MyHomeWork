package ch2;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

	private List<ProductDTO> productList = new ArrayList<ProductDTO>();

	public void save(ProductDTO dto) {
		productList.add(dto);
	}

	public List<ProductDTO> findAll() {
		return productList;
	}

	public ProductDTO findAll(int id) {
		for (ProductDTO dto : productList) {
			if (dto.getId() == id) {
				return dto;
			}
		}
		return null;
	}
	
	public boolean deleteProduct(int id) {
		return productList.removeIf(dto -> dto.getId() == id);
	}
	
	public boolean modifyProduct(ProductDTO modifiedDto) {
		for (int i = 0; i < productList.size(); i++) {
			if (productList.get(i).getId() == modifiedDto.getId()) {
				productList.set(i, modifiedDto);
				return true;
			}
		}
	return false;
	}
}