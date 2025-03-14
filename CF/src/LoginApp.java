import java.util.Scanner;

public class LoginApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập tên đăng nhập: ");
        String username = scanner.nextLine();

        System.out.print("Nhập mật khẩu: ");
        String password = scanner.nextLine();

        String role = UserDAO.authenticateUser(username, password);

        if (role != null) {
            System.out.println("Đăng nhập thành công! Vai trò: " + role);
            if (role.equals("admin")) {
                System.out.println("Chào mừng Admin! Bạn có toàn quyền quản lý.");
            } else {
                System.out.println("Chào mừng nhân viên! Bạn có quyền hạn hạn chế.");
            }
        } else {
            System.out.println("Sai tài khoản hoặc mật khẩu.");
        }

        scanner.close();
    }
}
