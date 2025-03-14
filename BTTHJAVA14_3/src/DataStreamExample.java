import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamExample {
    public static void main(String[] args) {
        String filePath = "numbers.dat";
        int[] numbersToWrite = {1, 2, 3, 4, 5};
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {
            for (int number : numbersToWrite) {
                dos.writeInt(number);
            }
            System.out.println("Đã ghi danh sách số nguyên vào file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            System.out.println("Danh sách số nguyên đọc từ file:");
            while (dis.available() > 0) {
                int number = dis.readInt();
                System.out.println(number);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}