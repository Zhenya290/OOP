// Перелік можливих статусів замовлення
public enum OrderStatus {
    NEW,       // Нове замовлення
    PREPARING, // Готується
    READY,     // Готово
    SERVED,    // Видане клієнту
    CANCELLED  // Скасовано
}
