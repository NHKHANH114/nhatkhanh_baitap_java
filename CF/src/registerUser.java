import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

public class UserDAO {

    // 📌 Đăng ký tài khoản (Mã hóa mật khẩu)
    public static boolean registerUser(String username, String password, String role) {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(12)); // Mã hóa mật khẩu
        String sql = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, hashedPassword);
            stmt.setString(3, role);

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0; // Trả về true nếu đăng ký thành công

        } catch (SQLException e) {
            System.out.println("Lỗi khi đăng ký tài khoản: " + e.getMessage());
            return false;
        }
    }

    // 📌 Xác thực đăng nhập (Phân quyền)
    public static String authenticateUser(String username, String password) {
        String sql = "SELECT password, role FROM users WHERE username = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String hashedPassword = rs.getString("password");
                if (BCrypt.checkpw(password, hashedPassword)) { // Kiểm tra mật khẩu nhập vào với mật khẩu đã mã hóa
                    return rs.getString("role"); // Trả về vai trò của người dùng
                }
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi đăng nhập: " + e.getMessage());
        }
        return null; // Trả về null nếu đăng nhập thất bại
    }
}
