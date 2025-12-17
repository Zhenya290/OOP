package com.konopliastyi;

// Клас для представлення позиції меню
public class MenuItem {
    // Унікальний ідентифікатор позиції
    private String itemId;
    
    // Назва страви
    private String name;
    
    // Вартість страви
    private double price;
    
    // Конструктор
    public MenuItem(String itemId, String name, double price) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
    }
    
    // Отримати ID позиції
    public String getItemId() {
        return itemId;
    }
    
    // Отримати назву
    public String getName() {
        return name;
    }
    
    // Отримати вартість
    public double getPrice() {
        return price;
    }
    
    // Встановити вартість
    public void setPrice(double price) {
        this.price = price;
    }
    
    // Виведення інформації про позицію меню
    public void displayInfo() {
        System.out.println("  [" + itemId + "] " + name + " - " + price + " грн");
    }
    
    @Override
    public String toString() {
        return name + " (" + price + " грн)";
    }
}
