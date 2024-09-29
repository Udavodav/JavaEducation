package lesson1.Classes;

import lesson1.Enums.NotificationType;
import lesson1.Interfaces.WorkingInterface;

import java.util.Random;

public class Employee extends Person implements WorkingInterface {

    private int countHors = 0;
    private static int workingNorm = 8;
    private final static Random random = new Random();

    public Employee(String firstname, String lastname) {
        this(firstname, lastname, NotificationType.MAIL);
    }

    public Employee(String firstname, String lastname, NotificationType notificationType) {
        super(firstname, lastname, notificationType);
    }

    public int getCountHors() {
        return countHors;
    }

    public void setCountHors(int countHors) {
        this.countHors = countHors;
    }

    public static int getWorkingNorm() {
        return workingNorm;
    }

    public static void setWorkingNorm(int workingNorm) {
        Employee.workingNorm = workingNorm;
    }

    public String getFullname(){
        if(super.getFullname() == null){
            return "Noname";
        }

        return super.getFullname();
    }

    @Override
    public void work() {
        int hours = random.nextInt(3, 5);
        System.out.println(this.getFullname() + " working in " + hours + " hours");
        countHors += hours;
        chill();
        hours = random.nextInt(3, 5);
        System.out.println(this.getFullname() + " working in " + hours + " hours");
        countHors += hours;
    }

    @Override
    public void chill() {
        System.out.println(this.getFullname() + " chilling");
    }
}
