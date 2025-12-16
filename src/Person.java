// Абстрактний клас для представлення особи
public abstract class Person {
    // Унікальний ідентифікатор
    protected String customerId;
    
    // Ім'я особи
    protected String name;
    
    // Email адреса
    protected String email;
    
    // Конструктор за замовчуванням
    public Person() {
        this.customerId = "Unknown";
        this.name = "Unknown";
        this.email = "unknown@email.com";
    }
    
    // Конструктор з параметрами
    public Person(String customerId, String name, String email) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
    }
    
    // Отримати ID клієнта
    public String getCustomerId() {
        return customerId;
    }
    
    // Отримати ім'я
    public String getName() {
        return name;
    }
    
    // Встановити ім'я
    public void setName(String name) {
        this.name = name;
    }
    
    // Отримати email
    public String getEmail() {
        return email;
    }
    
    // Встановити email
    public void setEmail(String email) {
        this.email = email;
    }
    
    // Абстрактний метод для виведення інформації
    public abstract void displayInfo();
    
    // Фінальний метод для отримання повної інформації
    public final String getFullDetails() {
        return "ID: " + customerId + ", Name: " + name + ", Email: " + email;
    }
}
