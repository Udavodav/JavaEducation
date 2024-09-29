package lesson1.Interfaces;

import lesson1.Classes.Employee;

import java.util.List;

public interface WagesInterface {

    float wagesAllEmployees(List<Employee> employees);

    float calculateWages(Employee employee);
}
