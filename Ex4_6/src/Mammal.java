public class Mammal extends Animal {
    public Mammal() {
        super();
    }
    public Mammal(String name) {
        super(name);
    }
    @Override
    public void greets() {
        System.out.println("Hello, I am a mammal!");
    }
    @Override
    public String toString() {
        return "Mammal[" + super.toString() + "]";
    }
}
