package Prof29Homework_01_06_2023;

import java.util.Arrays;
import java.util.List;

public class EventCreator {

    static Integer programLifetime = 20;
    static Integer startEventsListSize = 10;
    static Event[] eventsList = new Event[startEventsListSize];
    static Object monitor = new Object();
    static List<Thread> eventListeners = Arrays.asList(
            new Thread(new FirewallEventListener(monitor)),
            new Thread(new FirewallEventListener(monitor)),
            new Thread(new FirewallEventListener(monitor)),
            new Thread(new FirewallEventListener(monitor)));

    public static void main(String[] args) throws InterruptedException {
        List<Thread> users = Arrays.asList(
                new Thread(new User("Anton", "172.58.222.207")),
                new Thread(new User("Evgenij", "114.86.3.169")),
                new Thread(new User("Elena", "153.132.40.197")),
                new Thread(new User("Dmitrij", "32.48.114.5")),
                new Thread(new User("Anastasia", "210.212.141.169")),
                new Thread(new User("Ksenia", "185.189.131.67")),
                new Thread(new User("Olga", "172.48.151.59")),
                new Thread(new User("Artur", "65.175.100.107")),
                new Thread(new User("Igor", "117.189.68.47")),
                new Thread(new User("Boris", "39.211.21.212")));

        users.forEach(Thread::start);
        eventListeners.forEach(Thread::start);
        new Thread(new LogPrinter()).start();

        Thread.sleep(programLifetime * 1000);
        users.forEach(Thread::interrupt);
        eventListeners.forEach(Thread::interrupt);
    }

    public static void expandArray() {
        Event[] newArray = new Event[eventsList.length * (eventsList.length / 2)];
        System.arraycopy(eventsList, 0, newArray, 0, eventsList.length);
        eventsList = newArray;
    }
}