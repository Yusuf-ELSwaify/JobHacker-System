package org.jobhacker.exercise;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class App {
    public static void main(String[] args) {
        Properties properties = new Properties();
        String sqlSelectAllPersons = "select p.id, p.first_name, p.last_name " +
                "from person p";
        try {
            // DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            properties.load(App.class.getResourceAsStream("/db.properties"));
            try (Connection conn = DriverManager.getConnection(properties.get("URL").toString(), properties);
                    PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
                    ResultSet rs = ps.executeQuery()) {
                System.out.println("All entities in person table:");
                while (rs.next()) {
                    long id = rs.getLong("id");
                    String name = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    System.out.println("{id = " + id + ", name = " + name + ", lastName = " + lastName + "}");
                }
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
