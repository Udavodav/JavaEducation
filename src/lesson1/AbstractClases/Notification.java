package lesson1.AbstractClases;

public abstract class Notification {

    protected String title;

    protected String message;

    public Notification(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public abstract void send();
}
