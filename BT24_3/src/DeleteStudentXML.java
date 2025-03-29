import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Scanner;

public class DeleteStudentXML {
    public static void main(String[] args) {
        String fileName = "students.xml"; // File XML chứa danh sách sinh viên
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Student ID to delete: ");
        String studentId = scanner.nextLine();

        deleteStudent(fileName, studentId);
    }

    public static void deleteStudent(String fileName, String studentId) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                System.out.println("File not found!");
                return;
            }

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);

            doc.getDocumentElement().normalize();
            NodeList studentList = doc.getElementsByTagName("student");
            boolean found = false;

            for (int i = 0; i < studentList.getLength(); i++) {
                Element student = (Element) studentList.item(i);
                if (student.getAttribute("id").equals(studentId)) {
                    student.getParentNode().removeChild(student);
                    found = true;
                    break;
                }
            }

            if (found) {
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");

                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(file);
                transformer.transform(source, result);

                System.out.println("Student with ID " + studentId + " deleted successfully!");
            } else {
                System.out.println("Student ID not found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
