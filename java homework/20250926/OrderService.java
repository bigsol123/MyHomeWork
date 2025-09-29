package ch8;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderService {

    private OrderDAO dao;

    public OrderService(OrderDAO dao) {
        this.dao = dao;
    }

    public OrderDTO addOrder(String name, int price, int aqty) {

        OrderDTO newOrder = new OrderDTO(name, price, aqty); 
        return dao.save(newOrder);
    }

    public List<OrderDTO> getAllOrders() {
        return dao.findAll();
    }

    public Optional<OrderDTO> getOrderById(int id) {
        return Optional.ofNullable(dao.findById(id));
    }
    
    public List<OrderDTO> getOrdersByName(String name) {
        return dao.findAll().stream()
                       .filter(order -> order.getName().contains(name))
                       .collect(Collectors.toList());
    }

    public boolean deleteOrder(int id) {
        return dao.delete(id);
    }

    public boolean updateOrder(int id, String newName, int newPrice, int newAqty, int newCur) {
        OrderDTO existingOrder = dao.findById(id);
        if (existingOrder != null) {

            
           
            existingOrder.setName(newName);
            existingOrder.setPrice(newPrice);
            existingOrder.setAqty(newAqty);
            existingOrder.setCur(newCur);
            
            return dao.update(existingOrder); 
        }
        System.out.println("해당 번호의 주문을 찾을 수 없습니다.");
        return false;
    }
    
    public void getStatistics() {
        List<OrderDTO> orders = dao.findAll();
        if (orders.isEmpty()) {
            System.out.println("등록된 주문 품목이 없습니다.");
            return;
        }

        long totalItems = orders.size();
        
        long totalStockValue = orders.stream()
                 .mapToLong(order -> (long)order.getCur() * order.getPrice())
                 .sum();
        
        System.out.println("--- 주문 품목 통계 ---");
        System.out.printf("총 상품 수: %d개%n", totalItems);
        System.out.printf("총 금액: %d원%n", totalStockValue);
    }
}