import org.mindrot.jbcrypt.BCrypt;

public class PasswordHashing {
    public static void main(String[] args) {
        String password = "admin123"; // Mật khẩu gốc
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(10));
        System.out.println("Mật khẩu đã mã hóa: " + hashedPassword);
    }
}
{
}
