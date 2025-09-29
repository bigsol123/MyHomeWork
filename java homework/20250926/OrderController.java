package ch8;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class OrderController {
    private OrderService orderService;
    private Scanner scanner;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("배달 주문 리스트 프로그램에 오신 것을 환영합니다!");
        int choice;
        do {
            displayMenu();
            System.out.print("메뉴를 선택해주세요: ");
            choice = getUserInputAsInt();

            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    viewAllItems();
                    break;
                case 3:
                    viewIndividualItem();
                    break;
                case 4:
                    deleteItem();
                    break;
                case 5:
                    updateItem();
                    break;
                case 6:
                    showStatistics();
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다. 안녕히 계세요!");
                    break;
                default:
                    System.out.println("잘못된 메뉴 선택입니다. 다시 시도해주세요.");
            }
            System.out.println(); 
        } while (choice != 0);
        scanner.close();
    }

    private void displayMenu() {
        System.out.println("--- 메뉴 ---");
        System.out.println("1. 품명 입력 (새 품목 추가)");
        System.out.println("2. 전체 조회");
        System.out.println("3. 개별 조회");
        System.out.println("4. 삭제");
        System.out.println("5. 수정");
        System.out.println("6. 통계");
        System.out.println("0. 종료");
        System.out.println("------------");
    }

    private int getUserInputAsInt() {
        while (!scanner.hasNextInt()) {
            System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
            scanner.next(); 
            System.out.print("메뉴를 선택해주세요: ");
        }
        int input = scanner.nextInt();
        scanner.nextLine(); 
        return input;
    }
    
    private String getUserInputAsString() {
        return scanner.nextLine().trim();
    }

    // 1. 품명 입력 (새 품목 추가)
    private void addItem() {
        System.out.println("\n--- 새 품목 추가 ---");
        System.out.print("품명을 입력하세요: ");
        String name = getUserInputAsString();
        System.out.print("가격을 입력하세요: ");
        int price = getUserInputAsInt();
        System.out.print("주문가능수를 입력하세요: ");
        int aqty = getUserInputAsInt();

        OrderDTO newOrder = orderService.addOrder(name, price, aqty);
        if (newOrder != null) {
            System.out.println("새 품목이 성공적으로 추가되었습니다: " + newOrder);
        } else {
            System.out.println("품목 추가에 실패했습니다.");
        }
    }

    // 2. 전체 조회
    private void viewAllItems() {
        System.out.println("\n--- 전체 주문 품목 조회 ---");
        List<OrderDTO> orders = orderService.getAllOrders();
        if (orders.isEmpty()) {
            System.out.println("등록된 주문 품목이 없습니다.");
        } else {
            orders.forEach(System.out::println);
        }
    }

    // 3. 개별 조회
    private void viewIndividualItem() {
        System.out.println("\n--- 개별 품목 조회 ---");
        System.out.print("1. ID로 조회  2. 품명으로 조회 : ");
        int searchType = getUserInputAsInt();

        if (searchType == 1) {
            System.out.print("조회할 품목의 ID를 입력하세요: ");
            int id = getUserInputAsInt();
            Optional<OrderDTO> orderOpt = orderService.getOrderById(id);
            orderOpt.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("ID " + id + " 에 해당하는 품목을 찾을 수 없습니다.")
            );
        } else if (searchType == 2) {
            System.out.print("조회할 품목의 품명 (일부 또는 전체)을 입력하세요: ");
            String name = getUserInputAsString();
            List<OrderDTO> foundOrders = orderService.getOrdersByName(name);
            if (foundOrders.isEmpty()) {
                System.out.println("품명 '" + name + "' 에 해당하는 품목을 찾을 수 없습니다.");
            } else {
                foundOrders.forEach(System.out::println);
            }
        } else {
            System.out.println("잘못된 조회 방식입니다.");
        }
    }

    // 4. 삭제
    private void deleteItem() {
        System.out.println("\n--- 품목 삭제 ---");
        System.out.print("삭제할 품목의 ID를 입력하세요: ");
        int id = getUserInputAsInt();
        if (orderService.deleteOrder(id)) {
            System.out.println("ID " + id + " 품목이 성공적으로 삭제되었습니다.");
        } else {
            System.out.println("ID " + id + " 에 해당하는 품목을 찾을 수 없거나 삭제에 실패했습니다.");
        }
    }

    // 5. 수정
    private void updateItem() {
        System.out.println("\n--- 품목 수정 ---");
        System.out.print("수정할 품목의 ID를 입력하세요: ");
        int id = getUserInputAsInt();

        Optional<OrderDTO> existingOrderOpt = orderService.getOrderById(id);
        if (existingOrderOpt.isPresent()) {
            OrderDTO existingOrder = existingOrderOpt.get();
            System.out.println("현재 품목 정보: " + existingOrder);

            System.out.print("새 품명 (현재: " + existingOrder.getName() + ", 변경 없으면 Enter): ");
            String name = getUserInputAsString();
            if (name.isEmpty()) name = existingOrder.getName();

            System.out.print("새 가격 (현재: " + existingOrder.getPrice() + ", 변경 없으면 0 입력): ");
            int price = getUserInputAsInt();
            if (price == 0) price = existingOrder.getPrice();

            System.out.print("새 주문가능수 (현재: " + existingOrder.getAqty() + ", 변경 없으면 0 입력): ");
            int aqty = getUserInputAsInt();
            if (aqty == 0) aqty = existingOrder.getAqty();
            
            System.out.print("새 현재재고 (현재: " + existingOrder.getCur() + ", 변경 없으면 0 입력): ");
            int cur = getUserInputAsInt();
            if (cur == 0) cur = existingOrder.getCur();
            
            if (orderService.updateOrder(id, name, price, aqty, cur)) {
                System.out.println("품목이 성공적으로 수정되었습니다.");
            } else {
                System.out.println("품목 수정에 실패했습니다. (유효성 검사 실패 또는 내부 오류)");
            }
        } else {
            System.out.println("ID " + id + " 에 해당하는 품목을 찾을 수 없습니다.");
        }
    }
    
    // 6. 통계
    private void showStatistics() {
        System.out.println("\n--- 주문 품목 통계 ---");
        orderService.getStatistics();
    }
}