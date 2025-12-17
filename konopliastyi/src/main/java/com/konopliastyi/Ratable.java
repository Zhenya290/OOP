package com.konopliastyi;

// Интерфейс для об'єктів, які можуть бути оцінені
public interface Ratable {
    // Отримати оцінку (1-5)
    int getRating();
    
    // Встановити оцінку
    void setRating(int rating);
}
