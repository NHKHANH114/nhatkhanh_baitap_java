public class Animal {
    private String name;

    public Animal() {
        this.name = "Bảo Bối";
    }

    public Animal(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void greets() {
        System.out.println("Some generic animal sound");
    }

    @Override
    public String toString() {
        return "Animal[name=" + name + "]";
    }
}
