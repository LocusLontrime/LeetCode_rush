package JavaOOP.HomeWork3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Nurse extends Human implements Speaker {

    Map<String, String> cure = new HashMap<String, String>() {{
       put("Cold", "Levofloxacin");
       put("Flue", "Arbidol");
       put("Overwork", "Immunomodulator");
    }};

    public Nurse() {

    }

    public Nurse(String name, int age) {
        super(name, age);
        students = new ArrayList<>();
        pillows = new HashMap<>();
    }

    public void takeStudentsList(List<Student> studentsList) {
        students = studentsList;
    }

    public void takePillows(Map<String, Integer> pillows) {
        this.pillows = pillows;
    }

    private List<Student> students;
    private Map<String, Integer> pillows;

    public Nurse(ArrayList<Student> students, Map<String, Integer> pillows) {
        this.students = students;
        this.pillows = pillows;
    }

    public void sortStudentsList() {

        students = students.stream().sorted((st1, st2) -> {

            if (st1.getAge() == st2.getAge()) {
                return st1.getName().compareTo(st2.getName());
            } else if (st1.getAge() > st2.getAge()) {
                return 1;
            } else {
                return -1;
            }
        })
        .collect(Collectors.toList());

        System.out.println("Students ");
    }

    public void conductMedExam() {

        goToCheckup(students);

        sortStudentsList();

        for (Student student : students) {
            String illness = student.getIllness();
            if (illness != null) {
                int quantity = pillows.getOrDefault(illness, 0);
                if (quantity > 0) {
                    System.out.println(student.getName() + " возьми упаковку: " + cure.get(illness) + ", следующий!");
                    pillows.put(illness, quantity - 1);
                }
                else System.out.println(student.getName() + " купи в аптеке: " + cure.get(illness) + ", следующий!");
            } else {
                System.out.println(student.getName() + " - здоров, следующий!");
            }
        }

        System.out.println("Медосмотр окончен");
    }

    public List<Student> getStudents() {
        return students;
    }

    public Map<String, Integer> getPillows() {
        return pillows;
    }

    @Override
    public void goToCheckup(List<Student> students) {
        for (Student student : students) {
            System.out.println(student.getName() + " беги на медосмотр");
        }
    }
}