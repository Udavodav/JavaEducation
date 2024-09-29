package lesson1.Classes;


import lesson1.Enums.NotificationType;

public class Person {

    private String firstname;
    private String lastname;
    NotificationType notificationType;

    public Person(String firstname, String lastname, NotificationType notificationType) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.notificationType = notificationType;
    }

    public String getFullname() {
        if(!(firstname.isEmpty() || lastname.isEmpty())){
            return firstname + " " + lastname;
        } else {
            return "Firstname or lastname is empty";
        }
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
