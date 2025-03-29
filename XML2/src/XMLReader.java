import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public static void displayStudents() {
    try {
        File file = new File(StudentXMLWriter.FILE_NAME);
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

public void main() {
}
