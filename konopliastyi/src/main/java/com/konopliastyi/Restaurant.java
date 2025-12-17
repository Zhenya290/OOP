package com.konopliastyi;

import java.util.ArrayList;
import java.util.List;

// Клас для управління рестораном
public class Restaurant {
    // Назва ресторану
    private String name;
    
    // Список позицій меню
    private List<MenuItem> menuItems;
    
    // Список замовлень
    private List<Order> orders;
    
    // Конструктор
    public Restaurant(String name) {
        this.name = name;
        this.menuItems = new ArrayList<>();
        this.orders = new ArrayList<>();
        System.out.println("[LOG] Ресторан відкритий: " + name);
    }
    
    // Отримати назву ресторану
    public String getName() {
        return name;
    }
    
    // Додати позицію до меню
    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
        System.out.println("[LOG] Позиція додана в меню: " + item.getName());
    }
    
    // Отримати меню
    public List<MenuItem> getMenu() {
        return new ArrayList<>(menuItems);
    }
    
    // Виведення меню
    public void displayMenu() {
        System.out.println("\n=== МЕНЮ " + name + " ===");
        if (menuItems.isEmpty()) {
            System.out.println("Меню порожнє");
        } else {
            for (MenuItem item : menuItems) {
                item.displayInfo();
            }
        }
    }
    
    // Створити нове замовлення
    public Order createOrder(Customer customer) {
        String orderId = "ORD-" + (orders.size() + 1);
        Order order = new Order(orderId, customer);
        orders.add(order);
        customer.incrementOrdersCount();
        return order;
    }
    
    // Обробити замовлення (змінити статус)
    public void processOrder(Order order, OrderStatus status) {
        order.changeStatus(status);
    }
    
    // Отримати всі замовлення
    public List<Order> getAllOrders() {
        return new ArrayList<>(orders);
    }
    
    // Знайти замовлення за ID
    public Order findOrderById(String orderId) {
        for (Order order : orders) {
            if (order.getOrderId().equals(orderId)) {
                return order;
            }
        }
        return null;
    }
    
    // Виведення статистики
    public void displayStatistics() {
        System.out.println("\n=== СТАТИСТИКА РЕСТОРАНУ ===");
        System.out.println("Назва: " + name);
        System.out.println("Позицій в меню: " + menuItems.size());
        System.out.println("Всього замовлень: " + orders.size());
        
        int completedOrders = 0;
        int cancelledOrders = 0;
        double totalRevenue = 0.0;
        
        for (Order order : orders) {
            if (order.getStatus() == OrderStatus.SERVED) {
                completedOrders++;
                totalRevenue += order.getTotal();
            } else if (order.getStatus() == OrderStatus.CANCELLED) {
                cancelledOrders++;
            }
        }
        
        System.out.println("Виконаних замовлень: " + completedOrders);
        System.out.println("Скасованих замовлень: " + cancelledOrders);
        System.out.println("Загальна виручка: " + totalRevenue + " грн");
    }
}
