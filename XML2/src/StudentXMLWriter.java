import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.util.Scanner;

public class StudentXMLWriter {
    public static final String FILE_NAME = "students.xml";

    public static void addStudent(String id, String name, String age, String major) {
        try {
            File file = new File(FILE_NAME);
            Document document;
            Element root;

            if (file.exists()) {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                document = builder.parse(file);
                root = document.getDocumentElement();
            } else {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                document = builder.newDocument();
                root = document.createElement("students");
                document.appendChild(root);
            }

            Element student = document.createElement("student");
            student.setAttribute("id", id);

            Element nameElement = document.createElement("name");
            nameElement.appendChild(document.createTextNode(name));
            student.appendChild(nameElement);

            Element ageElement = document.createElement("age");
            ageElement.appendChild(document.createTextNode(age));
            student.appendChild(ageElement);

            Element majorElement = document.createElement("major");
            majorElement.appendChild(document.createTextNode(major));
            student.appendChild(majorElement);

            root.appendChild(student);

            saveXML(document);

            System.out.println("Student " + name + " has been added successfully!");
        } catch (ParserConfigurationException | TransformerException | IOException | org.xml.sax.SAXException e) {
            e.printStackTrace();
        }
    }

    public static void deleteStudent(String id) {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                System.out.println("File not found.");
                return;
            }

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);

            NodeList students = document.getElementsByTagName("student");
            for (int i = 0; i < students.getLength(); i++) {
                Element student = (Element) students.item(i);
                if (student.getAttribute("id").equals(id)) {
                    student.getParentNode().removeChild(student);
                    saveXML(document);
                    System.out.println("Student with ID " + id + " has been deleted.");
                    return;
                }
            }
            System.out.println("Student with ID " + id + " not found.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateStudent(String id, String newName, String newAge, String newMajor) {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                System.out.println("File not found.");
                return;
            }

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);

            NodeList students = document.getElementsByTagName("student");
            for (int i = 0; i < students.getLength(); i++) {
                Element student = (Element) students.item(i);
                if (student.getAttribute("id").equals(id)) {
                    student.getElementsByTagName("name").item(0).setTextContent(newName);
                    student.getElementsByTagName("age").item(0).setTextContent(newAge);
                    student.getElementsByTagName("major").item(0).setTextContent(newMajor);
                    saveXML(document);
                    System.out.println("Student with ID " + id + " has been updated.");
                    return;
                }
            }
            System.out.println("Student with ID " + id + " not found.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void saveXML(Document document) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File(FILE_NAME));
        transformer.transform(source, result);
    }

    public static void displayStudents() {  // ✅ Đặt ngoài `main()`
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                System.out.println("No students found.");
                return;
            }

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            document.getDocumentElement().normalize();

            NodeList students = document.getElementsByTagName("student");
            if (students.getLength() == 0) {
                System.out.println("No students found.");
                return;
            }

            System.out.println("Student List:");
            System.out.println("----------------------");
            for (int i = 0; i < students.getLength(); i++) {
                Element student = (Element) students.item(i);
                String id = student.getAttribute("id");
                String name = student.getElementsByTagName("name").item(0).getTextContent();
                String age = student.getElementsByTagName("age").item(0).getTextContent();
                String major = student.getElementsByTagName("major").item(0).getTextContent();

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Major: " + major);
                System.out.println("----------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {  // ✅ `main()` nằm ngoài `displayStudents()`
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an option: ");
        System.out.println("1. Add Student");
        System.out.println("2. Delete Student");
        System.out.println("3. Update Student");
        System.out.println("4. Display Students"); // ✅ Thêm tùy chọn hiển thị danh sách
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter student ID: ");
                String id = scanner.nextLine();
                System.out.print("Enter student name: ");
                String name = scanner.nextLine();
                System.out.print("Enter student age: ");
                String age = scanner.nextLine();
                System.out.print("Enter student major: ");
                String major = scanner.nextLine();
                addStudent(id, name, age, major);
                break;
            case 2:
                System.out.print("Enter student ID to delete: ");
                String deleteId = scanner.nextLine();
                deleteStudent(deleteId);
                break;
            case 3:
                System.out.print("Enter student ID to update: ");
                String updateId = scanner.nextLine();
                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                System.out.print("Enter new age: ");
                String newAge = scanner.nextLine();
                System.out.print("Enter new major: ");
                String newMajor = scanner.nextLine();
                updateStudent(updateId, newName, newAge, newMajor);
                break;
            case 4:
                displayStudents(); // ✅ Gọi phương thức hiển thị danh sách
                break;
            default:
                System.out.println("Invalid option");
        }
    }
}
