package classes;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String group;
    private int course;
    private ArrayList<Integer> marks = new ArrayList<>();

    public Student(String name, String group, int course) {
        this.name = name;
        this.group = group;
        this.course = course;
    }

    public Student(String name, String group, int course, ArrayList<Integer> marks) {
        this(name, group, course);
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void addMark(int mark) {
        marks.add(mark);
    }

    public ArrayList<Integer> getMarks() {
        return marks;
    }

    public String print() {
        return name + " " + group + " Курс - " + course;
    }

    public double getAvgMark(){
        return marks.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }

    public static ArrayList<Student> getGoodStudents(ArrayList<Student> students) {
        ArrayList<Student> goodStudents = new ArrayList<>();
        for (Student student : students) {
            if(student.getAvgMark() >= 3) {
                student.setCourse(student.getCourse() + 1);
                goodStudents.add(student);
            }
        }

        return goodStudents;
    }

    public static void printStudents(List<Student> students, int course) {
        for (Student student : students) {
            if(student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }

}
