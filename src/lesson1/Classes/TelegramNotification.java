package lesson1.Classes;

import lesson1.AbstractClases.Notification;

import java.util.Random;

public class TelegramNotification extends Notification {

    private final static Random random = new Random();

    public TelegramNotification(String title, String message) {
        super(title, message);
    }

    @Override
    public void send() {
        System.out.println("Telegram Notification\n" + title + ": " + message);
    }

    public int  getId(){
        return random.nextInt(1000, 100000);
    }
}
