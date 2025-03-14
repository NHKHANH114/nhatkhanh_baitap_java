import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n📌 Chọn chức năng:");
            System.out.println("1. Đăng ký");
            System.out.println("2. Đăng nhập");
            System.out.println("3. Thoát");
            System.out.print("Nhập lựa chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng trống

            if (choice == 1) {
                System.out.print("Nhập username: ");
                String username = scanner.nextLine();

                System.out.print("Nhập password: ");
                String password = scanner.nextLine();

                System.out.print("Nhập vai trò (admin/employee): ");
                String role = scanner.nextLine();

                boolean success = UserDAO.registerUser(username, password, role);
                if (success) {
                    System.out.println("✅ Đăng ký thành công!");
                } else {
                    System.out.println("❌ Đăng ký thất bại! Username có thể đã tồn tại.");
                }

            } else if (choice == 2) {
                System.out.print("Nhập username: ");
                String username = scanner.nextLine();

                System.out.print("Nhập password: ");
                String password = scanner.nextLine();

                String role = UserDAO.authenticateUser(username, password);
                if (role != null) {
                    System.out.println("✅ Đăng nhập thành công! Vai trò: " + role);
                } else {
                    System.out.println("❌ Sai username hoặc password.");
                }

            } else if (choice == 3) {
                System.out.println("👋 Thoát chương trình.");
                break;
            } else {
                System.out.println("❌ Lựa chọn không hợp lệ.");
            }
        }

        scanner.close();
    }
}
