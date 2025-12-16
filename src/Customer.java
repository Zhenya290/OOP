// Клас для представлення клієнта ресторану
public class Customer extends Person {
    // Кількість замовлень
    private int ordersCount;
    
    // Конструктор
    public Customer(String customerId, String name, String email) {
        super(customerId, name, email);
        this.ordersCount = 0;
        System.out.println("[LOG] Клієнт зареєстрований: " + name);
    }
    
    // Отримати кількість замовлень
    public int getOrdersCount() {
        return ordersCount;
    }
    
    // Збільшити кількість замовлень
    public void incrementOrdersCount() {
        this.ordersCount++;
    }
    
    // Виведення інформації про клієнта
    @Override
    public void displayInfo() {
        System.out.println("=== Інформація про клієнта ===");
        System.out.println(getFullDetails());
        System.out.println("Кількість замовлень: " + ordersCount);
    }
    
    // Статичний метод для виведення інформації
    public static void printCustomerInfo(Customer customer) {
        System.out.println("Клієнт: " + customer.getFullDetails());
    }
}
