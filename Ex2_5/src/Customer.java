class Customer {

    private int ID;
    private String name;
    private char gender;
    private double discount;

    public Customer(int ID, String name, double discount) {
        this.ID = ID;
        this.name = name;
        this.discount = discount;
    }


    public Customer(int ID, String name, char gender) {
        this.ID = ID;
        this.name = name;
        if (gender == 'm' || gender == 'f') {
            this.gender = gender;
        } else {
            System.out.println("Gender of 'm' or 'f'");
        }
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        if (gender == 'm' || gender == 'f') {
            this.gender = gender;
        } else {
            System.out.println("Gender of 'm' or 'f'");
        }
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }



    @Override
    public String toString() {
        return name + "(" + ID + ")";
    }

}