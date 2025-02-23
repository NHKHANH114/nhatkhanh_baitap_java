class TestMain{
    public static void main(String[] args) {
        Book book = new Book("Python", new Author[]{new Author("Nhat Khanh", "khanhhn.24itb@vku.udn.vn", 'm'),new Author("Cong Minh", "MCN2006@vku.udn.vn", 'f')}, 200.5, 30);
        System.out.println(book.getAuthorNames());
        System.out.println(book.toString());
    }
}