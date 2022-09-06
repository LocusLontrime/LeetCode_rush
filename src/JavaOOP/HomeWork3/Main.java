package JavaOOP.HomeWork3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Nurse nurse = new Nurse("Милая медсестра", 23);

        Student student1 = new Student("Анатолий Вассерман", 23, "Overwork");
        Student student2 = new Student("Виталий Попчик", 24, null);
        Student student3 = new Student("Виктор Лабейко", 22, "Cold");

        List<Student> students = new ArrayList<Student>() {{
            add(student1);
            add(student2);
            add(student3);
        }};

        Map<String, Integer> pillows = new HashMap<String, Integer>() {{
            put("Levofloxacin", 17);
            put("Arbidol", 11);
            put("Immunomodulator", 98);
        }};


        nurse.takePillows(pillows);
        nurse.takeStudentsList(students);

        nurse.conductMedExam();
    }
}
