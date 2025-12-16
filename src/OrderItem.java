// Клас для представлення позиції замовлення
public class OrderItem {
    // Позиція меню
    private MenuItem menuItem;
    
    // Кількість позицій
    private int quantity;
    
    // Конструктор
    public OrderItem(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }
    
    // Отримати позицію меню
    public MenuItem getMenuItem() {
        return menuItem;
    }
    
    // Отримати кількість
    public int getQuantity() {
        return quantity;
    }
    
    // Встановити кількість
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    // Обчислити суму для цієї позиції
    public double getSubtotal() {
        return menuItem.getPrice() * quantity;
    }
    
    // Виведення інформації
    public void displayInfo() {
        System.out.println("    - " + menuItem.getName() + " x" + quantity + 
                         " = " + getSubtotal() + " грн");
    }
    
    @Override
    public String toString() {
        return menuItem.getName() + " x" + quantity + " (" + getSubtotal() + " грн)";
    }
}
