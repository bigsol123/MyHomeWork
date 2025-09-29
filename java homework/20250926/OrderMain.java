package ch8;

public class OrderMain {
    public static void main(String[] args) {
    	String filename = "DB/order.csv";
    	OrderDAO orderDAO = new OrderDAO(filename); // CSV 파일명 전달
        OrderService orderService = new OrderService(orderDAO);
        OrderController orderController = new OrderController(orderService);

        orderController.run();
    }
}