package ch8;

public class OrderDTO {

    private int id;
    private String name;
    private int price;
    private int aqty;
    private int cur;

    public OrderDTO() {
    }

    public OrderDTO(int id, String name, int price, int aqty, int cur) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.aqty = aqty;
        this.cur = cur;
    }
    
    
    public OrderDTO(String name, int price, int aqty) {
        this(0, name, price, aqty, aqty);
    }

    public int getId() { 
    	return id; 
    }
    
    public void setId(int id) {
    	this.id = id; 
    }
    
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
    
    public int getAqty() { 
    	return aqty; 
    }
    
    public void setAqty(int aqty) { 
    	this.aqty = aqty; 
    }
    
    public int getCur() { 
    	return cur; 
    }
    
    public void setCur(int cur) { 
    	this.cur = cur; 
    }
    

    @Override
    public String toString() {
    
        return String.format("번호:%d | 상품명:%s | 가격:%d원 | 주문가능수:%d개 | 현재재고:%d개", id, name, price, aqty, cur);
    }
}