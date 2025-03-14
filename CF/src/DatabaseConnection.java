import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/CoffeeShopDB";
    private static final String USER = "root"; // Thay bằng user của bạn
    private static final String PASSWORD = ""; // Thay bằng mật khẩu của bạn (XAMPP thường để trống)

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Lỗi kết nối MySQL: " + e.getMessage());
            return null;
        }
    }
}
