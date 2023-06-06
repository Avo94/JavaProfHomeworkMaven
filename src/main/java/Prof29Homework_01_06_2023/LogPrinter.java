package Prof29Homework_01_06_2023;

import static Prof29Homework_01_06_2023.EventCreator.*;
import static Prof29Homework_01_06_2023.FirewallEventListener.log;

public class LogPrinter implements Runnable {

    @Override
    public void run() {
        try {
            for (Thread listener : eventListeners) listener.join();
            System.out.println("\nВсе пользователи были отключены.\nЛог действий пользователей:");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        log.forEach(System.out::println);
    }
}