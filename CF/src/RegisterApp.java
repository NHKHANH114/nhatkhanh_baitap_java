import java.util.Scanner;

public class RegisterApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập tên đăng nhập: ");
        String username = scanner.nextLine();

        System.out.print("Nhập mật khẩu: ");
        String password = scanner.nextLine();

        System.out.print("Chọn vai trò (admin/employee): ");
        String role = scanner.nextLine();

        // Gọi phương thức registerUser() và kiểm tra kết quả
        boolean success = UserDAO.registerUser(username, password, role);

        if (success) {
            System.out.println("✅ Đăng ký thành công!");
        } else {
            System.out.println("❌ Đăng ký thất bại! Username có thể đã tồn tại.");
        }

        scanner.close();
    }
}
