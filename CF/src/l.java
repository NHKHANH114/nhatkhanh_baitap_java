import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/cafe_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Lỗi kết nối cơ sở dữ liệu: " + e.getMessage());
        }
    }
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT password, role FROM users WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getUsername());

            ResultSet rs = stmt.executeQuery();
            if (rs.next() && BCrypt.checkpw(user.getPassword(), rs.getString("password"))) {
                return "Đăng nhập thành công với quyền: " + rs.getString("role");
            }
            return "Sai tài khoản hoặc mật khẩu";
        } catch (Exception e) {
            return "Lỗi: " + e.getMessage();
        }
    }

}
