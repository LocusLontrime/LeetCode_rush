package JavaOOP.HomeWork3;

public class Student extends Human {
    private String illness;

    public Student(String name, int age, String illness) {
        super(name, age);
        this.illness = illness;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }
}