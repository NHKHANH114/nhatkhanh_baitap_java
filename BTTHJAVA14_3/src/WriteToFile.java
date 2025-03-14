import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class WriteToFile {
    public static void main(String[] args) {
        String destFile = "output.txt";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             FileWriter fw = new FileWriter(destFile)) {

            System.out.println("Nhập dữ liệu (nhập 'exit' để kết thúc):");

            String line;
            while (!(line = br.readLine()).equalsIgnoreCase("exit")) {
                fw.write(line + System.lineSeparator());
            }
            System.out.println("Dữ liệu đã được ghi vào file thành công!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}