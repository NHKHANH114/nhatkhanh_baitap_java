public class TestMain {
    public static void main(String[] args) {
        Student s1 = new Student("PRO192", 2021, 300, "Ho Nhat Khanh", "Da Nang");
        System.out.println(s1);
        s1.setAddress("Quang Nam");
        System.out.println(s1);
        s1.setFee(300);
        s1.setProgram("MAD101");
        s1.setYear(2022);
        System.out.println("Name is " + s1.getName());
        System.out.println("Adress is " + s1.getAddress());
        System.out.println("Fee is " + s1.getFee());
        System.out.println("Program is " + s1.getProgram());
        System.out.println("Year is " + s1.getYear());
        Staff sf1 = new Staff("Nhat Khanh", "Viet Nam", "VKU", 250);
        System.out.println(sf1);
        sf1.setAddress("VKU");
        System.out.println(sf1);
        sf1.setPay(300);
        sf1.setSchool("Seoul Universe");
        System.out.println("Name is " + sf1.getName());
        System.out.println("Adress is " + sf1.getAddress());
        System.out.println("Pay is " + sf1.getPay());
        System.out.println("School is " + sf1.getSchool());
    }
}