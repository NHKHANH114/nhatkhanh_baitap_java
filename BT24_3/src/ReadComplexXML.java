import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ReadComplexXML {
    public static void main(String[] args) {
        String fileName = "company.xml";
        try {
            File xmlFile = new File(fileName);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            document.getDocumentElement().normalize();
            NodeList employeeList = document.getElementsByTagName("employee");

            for (int i = 0; i < employeeList.getLength(); i++) {
                Node node = employeeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element employee = (Element) node;
                    String id = employee.getAttribute("id");
                    String name = employee.getElementsByTagName("name").item(0).getTextContent();

                    Element contact = (Element) employee.getElementsByTagName("contact").item(0);
                    String email = contact.getElementsByTagName("email").item(0).getTextContent();
                    String phone = contact.getElementsByTagName("phone").item(0).getTextContent();

                    Element department = (Element) employee.getElementsByTagName("department").item(0);
                    String deptName = department.getElementsByTagName("name").item(0).getTextContent();
                    String location = department.getElementsByTagName("location").item(0).getTextContent();

                    System.out.println("Employee ID: " + id);
                    System.out.println("Name: " + name);
                    System.out.println("Email: " + email);
                    System.out.println("Phone: " + phone);
                    System.out.println("Department: " + deptName);
                    System.out.println("Location: " + location);
                    System.out.println("-------------------------");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
