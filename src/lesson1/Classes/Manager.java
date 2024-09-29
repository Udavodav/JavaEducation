package lesson1.Classes;

import lesson1.Enums.NotificationType;
import lesson1.Interfaces.NotificableInterface;
import lesson1.Interfaces.WagesInterface;

import java.util.List;

public class Manager extends Person implements WagesInterface, NotificableInterface {

    private static float betWages = 314.15f;

    public static float indexWages = 1.1f;

    public Manager(String firstname, String lastname) {
        super(firstname, lastname, NotificationType.MAIL);
    }

    public static float getBetWages() {
        return betWages;
    }

    public static void setBetWages(float betWages) {
        Manager.betWages = betWages;
    }

    @Override
    public float wagesAllEmployees(List<Employee> employees) {
        float sum = 0;

        for (Employee employee : employees) {
            sum += calculateWages(employee);
        }

        return sum;
    }

    @Override
    public float calculateWages(Employee employee) {
        float wages =  employee.getCountHors() * betWages;
        int hours = employee.getCountHors() - Employee.getWorkingNorm();
        wages += hours > 0 ? employee.getCountHors() * betWages * Manager.indexWages : 0;

        return wages;
    }

    @Override
    public void customNotify(Person person, String message) {
        switch (person.notificationType){
            case MAIL -> new MailNotification("Mail notify", "Body message = " + message).send();
            case TELEGRAM -> new TelegramNotification("Telegram notify", "Body message = " + message).send();
        }
    }
}
