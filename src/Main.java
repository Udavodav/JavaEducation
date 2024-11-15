import classes.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("John", "Group 1", 1, new ArrayList<>(Arrays.asList(4,5,2,2,3))));
        students.add(new Student("Genry", "Group 1", 3, new ArrayList<>(Arrays.asList(2,2,4,3,3))));
        students.add(new Student("Mark", "Group 2", 1, new ArrayList<>(Arrays.asList(4,5,4,3,3))));
        students.add(new Student("Rose", "Group 3", 2, new ArrayList<>(Arrays.asList(4,3,3,2,2))));
        students.add(new Student("Milana", "Group 2", 2, new ArrayList<>(Arrays.asList(2,3,3,4,3))));
        students.add(new Student("Max", "Group 1", 3, new ArrayList<>(Arrays.asList(5,4,5,3,4))));

        System.out.println("Список студентов до удаления и перевода на след курс:");
        for (Student student : students) {
            System.out.println(student.print());
        }

        students = Student.getGoodStudents(students);

        System.out.println("\nСписок студентов после удаления и перевода на след курс:");
        for (Student student : students) {
            System.out.println(student.print());
        }

        System.out.println("\nСписок студентов на курсе 2:");
        Student.printStudents(students, 2);
    }
}
