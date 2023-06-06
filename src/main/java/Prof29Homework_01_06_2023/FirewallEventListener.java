package Prof29Homework_01_06_2023;

import java.util.ArrayList;
import java.util.List;

import static Prof29Homework_01_06_2023.EventCreator.*;

public class FirewallEventListener implements Runnable {

    private final Object monitor;

    private static int logCounter = 0;

    static List<String> log = new ArrayList<>();

    public FirewallEventListener(Object monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                break;
            }

            synchronized (monitor) {
                if (logCounter >= eventsList.length || eventsList[logCounter] == null) continue;
                log.add("Обработчик " + Thread.currentThread().getName() + " ID-" +
                        eventsList[logCounter].getEventId() + " " + eventsList[logCounter].getUserName());
                log.add("Обработчик " + Thread.currentThread().getName() + " ID-" +
                        eventsList[logCounter].getEventId() + " " + eventsList[logCounter].getUserIp());
                log.add("Обработчик " + Thread.currentThread().getName() + " ID-" +
                        eventsList[logCounter].getEventId() + " " + eventsList[logCounter].getEventDate());
                log.add("Обработчик " + Thread.currentThread().getName() + " ID-" +
                        eventsList[logCounter].getEventId() + " " + eventsList[logCounter].getEventState() + "\n");
                logCounter++;
            }
        }
    }
}