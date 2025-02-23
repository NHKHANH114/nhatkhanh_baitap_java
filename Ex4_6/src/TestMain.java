public class TestMain {

    public static void main(String[] args) {
        Cat c1 = new Cat("Bảo Bối");
        System.out.println(c1);
        c1.greets();
        Dog d1 = new Dog("Công Minh");
        Dog d2 = new Dog("Như Mạnh");
        System.out.println(d1);
        System.out.println(d2);
        d1.greets();
        d1.greets(d2);
    }
}