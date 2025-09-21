package ch4;

public class Product {
	
		private String name;
		private int price;
		

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		@Override
		public String toString() {
			return "상품명: " + name + ", 가격: "  + price + "원";
		}
		
		
}
