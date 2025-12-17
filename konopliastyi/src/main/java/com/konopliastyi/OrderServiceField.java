package com.konopliastyi;

import com.google.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderServiceField {

    @Inject
    private Connection connection;

    public void saveOrder(String id, String status, double total) {
        String sql = "INSERT INTO orders (id, status, total) VALUES (?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, id);
            ps.setString(2, status);
            ps.setDouble(3, total);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
