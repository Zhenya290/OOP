// Основний клас для запуску програми та демонстрації функціональності
public class Application {
    
    // Точка входу програми
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════╗");
        System.out.println("║    Система управління замовленнями ресторану      ║");
        System.out.println("║          (Імітаційний прототип на Java)           ║");
        System.out.println("╚════════════════════════════════════════════════════╝\n");
        
        // Запустити демонстрацію
        demonstrateSystem();
    }
    
    // Метод для демонстрації роботи системи
    private static void demonstrateSystem() {
        System.out.println("[INFO] Початок демонстрації...\n");
        
        // 1. Створити ресторан
        Restaurant restaurant = new Restaurant("Їжак");
        
        // 2. Додати позиції до меню
        System.out.println("\n[INFO] Підготовка меню...");
        restaurant.addMenuItem(new MenuItem("1", "Борщ", 45.0));
        restaurant.addMenuItem(new MenuItem("2", "Коломиї", 55.0));
        restaurant.addMenuItem(new MenuItem("3", "Ведмежа лапа", 75.0));
        restaurant.addMenuItem(new MenuItem("4", "Компот", 15.0));
        restaurant.addMenuItem(new MenuItem("5", "Олії булочка", 25.0));
        
        restaurant.displayMenu();
        
        // 3. Зареєструвати клієнтів
        System.out.println("\n[INFO] Реєстрація клієнтів...");
        Customer customer1 = new Customer("C001", "Іван Петренко", "ivan@example.com");
        Customer customer2 = new Customer("C002", "Марія Коваль", "maria@example.com");
        
        // 4. Демонстрація першого замовлення
        System.out.println("\n[INFO] Клієнт 1 робить замовлення...");
        Order order1 = restaurant.createOrder(customer1);
        
        // Додати позиції до замовлення
        order1.addItem(new OrderItem(restaurant.getMenu().get(0), 1)); // Борщ
        order1.addItem(new OrderItem(restaurant.getMenu().get(3), 2)); // Компот x2
        order1.addItem(new OrderItem(restaurant.getMenu().get(4), 1)); // Булочка
        
        order1.displayOrderInfo();
        
        // Обробка замовлення персоналом
        System.out.println("\n[INFO] Персонал обробляє замовлення...");
        restaurant.processOrder(order1, OrderStatus.PREPARING);
        restaurant.processOrder(order1, OrderStatus.READY);
        restaurant.processOrder(order1, OrderStatus.SERVED);
        
        // Клієнт оцінює замовлення
        System.out.println("\n[INFO] Клієнт 1 оцінює замовлення...");
        order1.setRating(5);
        order1.displayOrderInfo();
        
        // 5. Демонстрація другого замовлення
        System.out.println("\n[INFO] Клієнт 2 робить замовлення...");
        Order order2 = restaurant.createOrder(customer2);
        
        order2.addItem(new OrderItem(restaurant.getMenu().get(1), 1)); // Коломиї
        order2.addItem(new OrderItem(restaurant.getMenu().get(2), 1)); // Ведмежа лапа
        
        order2.displayOrderInfo();
        
        // Клієнт змінює рішення і скасовує замовлення
        System.out.println("\n[INFO] Клієнт 2 скасовує замовлення...");
        order2.cancel();
        order2.displayOrderInfo();
        
        // 6. Демонстрація третього замовлення
        System.out.println("\n[INFO] Клієнт 1 робить ще одне замовлення...");
        Order order3 = restaurant.createOrder(customer1);
        
        order3.addItem(new OrderItem(restaurant.getMenu().get(2), 2)); // Ведмежа лапа x2
        order3.addItem(new OrderItem(restaurant.getMenu().get(3), 1)); // Компот
        
        restaurant.processOrder(order3, OrderStatus.PREPARING);
        restaurant.processOrder(order3, OrderStatus.READY);
        
        // Оцінити замовлення, навіть якщо воно ще не видане
        order3.setRating(4);
        
        // 7. Виведення інформації про клієнтів
        System.out.println("\n[INFO] Інформація про клієнтів...");
        customer1.displayInfo();
        System.out.println();
        customer2.displayInfo();
        
        // 8. Виведення статистики ресторану
        restaurant.displayStatistics();
        
        // 9. Виведення всіх замовлень
        System.out.println("\n[INFO] Всі замовлення в ресторані:");
        for (Order order : restaurant.getAllOrders()) {
            System.out.println("  " + order);
        }
        
        System.out.println("\n╔════════════════════════════════════════════════════╗");
        System.out.println("║           Демонстрація завершена успішно           ║");
        System.out.println("╚════════════════════════════════════════════════════╝");
    }
}
