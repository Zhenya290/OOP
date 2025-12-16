import java.util.ArrayList;
import java.util.List;

// Клас для представлення замовлення
public class Order implements Ratable {
    // Унікальний ідентифікатор замовлення
    private String orderId;
    
    // Клієнт, який замовив
    private Customer customer;
    
    // Список позицій замовлення
    private List<OrderItem> items;
    
    // Статус замовлення
    private OrderStatus status;
    
    // Оцінка замовлення (1-5)
    private int rating;
    
    // Загальна сума
    private double totalAmount;
    
    // Конструктор
    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = new ArrayList<>();
        this.status = OrderStatus.NEW;
        this.rating = 0;
        this.totalAmount = 0.0;
        System.out.println("[LOG] Замовлення створене: " + orderId + " для " + customer.getName());
    }
    
    // Отримати ID замовлення
    public String getOrderId() {
        return orderId;
    }
    
    // Отримати клієнта
    public Customer getCustomer() {
        return customer;
    }
    
    // Додати позицію до замовлення
    public void addItem(OrderItem item) {
        items.add(item);
        calculateTotal();
        System.out.println("[LOG] Позиція додана: " + item.getMenuItem().getName());
    }
    
    // Видалити позицію з замовлення
    public void removeItem(OrderItem item) {
        if (items.remove(item)) {
            calculateTotal();
            System.out.println("[LOG] Позиція видалена: " + item.getMenuItem().getName());
        }
    }
    
    // Отримати список позицій
    public List<OrderItem> getItems() {
        return new ArrayList<>(items);
    }
    
    // Обчислити загальну суму
    public void calculateTotal() {
        totalAmount = 0.0;
        for (OrderItem item : items) {
            totalAmount += item.getSubtotal();
        }
    }
    
    // Отримати загальну суму
    public double getTotal() {
        return totalAmount;
    }
    
    // Отримати статус
    public OrderStatus getStatus() {
        return status;
    }
    
    // Змінити статус замовлення
    public void changeStatus(OrderStatus newStatus) {
        OrderStatus oldStatus = status;
        status = newStatus;
        System.out.println("[LOG] Статус замовлення " + orderId + 
                         " змінений з " + oldStatus + " на " + newStatus);
    }
    
    // Скасувати замовлення
    public void cancel() {
        if (status != OrderStatus.PREPARING && status != OrderStatus.READY) {
            status = OrderStatus.CANCELLED;
            System.out.println("[LOG] Замовлення скасовано: " + orderId);
        } else {
            System.out.println("[LOG] Помилка: Неможливо скасувати замовлення в статусі " + status);
        }
    }
    
    // Отримати оцінку
    @Override
    public int getRating() {
        return rating;
    }
    
    // Встановити оцінку
    @Override
    public void setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            this.rating = rating;
            System.out.println("[LOG] Замовлення оцінено: " + rating + " зірок");
        } else {
            System.out.println("[LOG] Помилка: Оцінка повинна бути від 1 до 5");
        }
    }
    
    // Виведення інформації про замовлення
    public void displayOrderInfo() {
        System.out.println("\n=== Замовлення " + orderId + " ===");
        System.out.println("Клієнт: " + customer.getName());
        System.out.println("Статус: " + status);
        System.out.println("Позиції:");
        
        if (items.isEmpty()) {
            System.out.println("  (немає позицій)");
        } else {
            for (OrderItem item : items) {
                item.displayInfo();
            }
        }
        
        System.out.println("Загальна сума: " + totalAmount + " грн");
        if (rating > 0) {
            System.out.println("Оцінка: " + rating + " ⭐");
        }
    }
    
    @Override
    public String toString() {
        return "Order{" + "ID=" + orderId + ", Status=" + status + ", Total=" + totalAmount + "}";
    }
}
