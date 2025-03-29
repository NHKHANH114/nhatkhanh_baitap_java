import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class LibraryManagement extends JFrame {
    private JTextField txtId, txtTitle, txtAuthor, txtYear, txtPublisher, txtPages, txtGenre, txtPrice;
    private JTable table;
    private DefaultTableModel tableModel;
    private static final String FILE_NAME = "books.xml";

    public LibraryManagement() {
        setTitle("\ud83d\udcda Library Management System");
        setSize(900, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Panel nhập thông tin sách
        JPanel inputPanel = new JPanel(new GridLayout(4, 4, 10, 10));
        inputPanel.setBorder(new TitledBorder("\ud83d\udcda Book Details"));

        inputPanel.add(new JLabel("\ud83d\udccc ID:")); txtId = new JTextField(); inputPanel.add(txtId);
        inputPanel.add(new JLabel("\ud83d\udcda Title:")); txtTitle = new JTextField(); inputPanel.add(txtTitle);
        inputPanel.add(new JLabel("\u270d\ufe0f Author:")); txtAuthor = new JTextField(); inputPanel.add(txtAuthor);
        inputPanel.add(new JLabel("\ud83d\udcc5 Year:")); txtYear = new JTextField(); inputPanel.add(txtYear);
        inputPanel.add(new JLabel("\ud83c\udfe2 Publisher:")); txtPublisher = new JTextField(); inputPanel.add(txtPublisher);
        inputPanel.add(new JLabel("\ud83d\udcdd Pages:")); txtPages = new JTextField(); inputPanel.add(txtPages);
        inputPanel.add(new JLabel("\ud83d\udcda Genre:")); txtGenre = new JTextField(); inputPanel.add(txtGenre);
        inputPanel.add(new JLabel("\ud83d\udcb2 Price:")); txtPrice = new JTextField(); inputPanel.add(txtPrice);
        add(inputPanel, BorderLayout.NORTH);

        // Panel chứa các nút chức năng
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        JButton btnAdd = new JButton("➕ Add");
        JButton btnUpdate = new JButton("✏️ Update");
        JButton btnDelete = new JButton("🗑️ Delete");
        JButton btnLoad = new JButton("🔄 Load");

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnLoad);
        add(buttonPanel, BorderLayout.CENTER);

        // Bảng hiển thị danh sách sách
        tableModel = new DefaultTableModel(new String[]{"ID", "Title", "Author", "Year", "Publisher", "Pages", "Genre", "Price"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(new TitledBorder("📋 Book List"));
        add(scrollPane, BorderLayout.SOUTH);

        // Gắn sự kiện cho các nút
        btnAdd.addActionListener(this::addBook);
        btnUpdate.addActionListener(this::updateBook);
        btnDelete.addActionListener(this::deleteBook);
        btnLoad.addActionListener(e -> loadBooks());

        setVisible(true);
        loadBooks();
    }

    private void addBook(ActionEvent e) {
        try {
            File file = new File(FILE_NAME);
            Document document;
            Element root;

            if (file.exists()) {
                DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                document = builder.parse(file);
                root = document.getDocumentElement();
            } else {
                document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
                root = document.createElement("books");
                document.appendChild(root);
            }

            Element book = document.createElement("book");
            book.setAttribute("id", txtId.getText());
            book.appendChild(createElement(document, "title", txtTitle.getText()));
            book.appendChild(createElement(document, "author", txtAuthor.getText()));
            book.appendChild(createElement(document, "year", txtYear.getText()));
            book.appendChild(createElement(document, "publisher", txtPublisher.getText()));
            book.appendChild(createElement(document, "pages", txtPages.getText()));
            book.appendChild(createElement(document, "genre", txtGenre.getText()));
            book.appendChild(createElement(document, "price", txtPrice.getText()));

            root.appendChild(book);
            saveXML(document);
            loadBooks();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void updateBook(ActionEvent e) {
        // TODO: Implement update logic
    }

    private void deleteBook(ActionEvent e) {
        // TODO: Implement delete logic
    }

    private void saveXML(Document document) {
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(new DOMSource(document), new StreamResult(new File(FILE_NAME)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadBooks() {
        tableModel.setRowCount(0);
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) return;

            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
            NodeList books = document.getElementsByTagName("book");

            for (int i = 0; i < books.getLength(); i++) {
                Element book = (Element) books.item(i);
                tableModel.addRow(new Object[]{
                        book.getAttribute("id"),
                        book.getElementsByTagName("title").item(0).getTextContent(),
                        book.getElementsByTagName("author").item(0).getTextContent(),
                        book.getElementsByTagName("year").item(0).getTextContent(),
                        book.getElementsByTagName("publisher").item(0).getTextContent(),
                        book.getElementsByTagName("pages").item(0).getTextContent(),
                        book.getElementsByTagName("genre").item(0).getTextContent(),
                        book.getElementsByTagName("price").item(0).getTextContent()
                });
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private Element createElement(Document doc, String tagName, String value) {
        Element element = doc.createElement(tagName);
        element.appendChild(doc.createTextNode(value));
        return element;
    }

    public static void main(String[] args) {
        new LibraryManagement();
    }
}
