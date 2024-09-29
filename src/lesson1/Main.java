package lesson1;

import lesson1.Classes.Employee;
import lesson1.Classes.Manager;
import lesson1.Enums.NotificationType;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
public class Main {
    public static void main(String[] args) {

        System.out.println("Hello all employees in this factory!");

        Manager manager = new Manager("Main", "Manager");

        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("Mike", "Luger"));
        employees.add(new Employee("Duck", "Mercur", NotificationType.TELEGRAM));
        employees.add(new Employee("Lisa", "Bucket"));

        for (Employee employee : employees) {
            employee.work();
        }

        System.out.println();

        for (Employee employee : employees) {
            System.out.println("Wages of " + employee.getFullname() + ": " + manager.calculateWages(employee));
        }

        System.out.println();
        System.out.println("Wages all employees: " + manager.wagesAllEmployees(employees));
        System.out.println();

        for (Employee employee : employees) {
            manager.customNotify(employee, "your salary is " + manager.calculateWages(employee));
        }
    }
}

