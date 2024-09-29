package lesson1.Classes;

import lesson1.AbstractClases.Notification;

import java.util.ArrayList;
import java.util.List;

public class MailNotification extends Notification {

    private List<String> filenames = new ArrayList<String>();

    public MailNotification(String title, String message) {
        super(title, message);
    }

    @Override
    public void send() {
        System.out.println("Mail Notification\n" + title + ": " + message);
    }

    public void printFilenames() {
        for (String filename : filenames) {
            System.out.println(filename);
        }
    }

    public void addFilename(String filename) {
        filenames.add(filename);
    }

    public void removeFilename(String filename) {
        filenames.remove(filename);
    }
}
