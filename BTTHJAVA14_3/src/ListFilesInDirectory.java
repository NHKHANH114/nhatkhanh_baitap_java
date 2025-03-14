import java.io.File;

public class ListFilesInDirectory {
    public static void main(String[] args) {
        String directoryPath = "path/to/your/directory";
        File directory = new File(directoryPath);
        if (directory.isDirectory()) {
            File[] filesList = directory.listFiles();
            if (filesList != null && filesList.length > 0) {
                System.out.println("Danh sách các file trong thư mục \"" + directoryPath + "\":");
                for (File file : filesList) {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getName());
                    } else if (file.isDirectory()) {
                        System.out.println("Thư mục: " + file.getName());
                    }
                }
            } else {
                System.out.println("Thư mục rỗng.");
            }
        } else {
            System.out.println("Đường dẫn không phải là thư mục.");
        }
    }
}