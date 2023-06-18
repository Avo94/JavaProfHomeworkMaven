package Prof32Homework_13_06_2023.Exchanger;

import java.util.concurrent.Exchanger;

public class StringSwitcher implements Runnable {

    private final int number;
    private final Exchanger<String> exchanger;
    String[][] strings;

    public StringSwitcher(int number, String[][] strings, Exchanger<String> exchanger) {
        this.number = number;
        this.exchanger = exchanger;
        this.strings = strings;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            if (number % 2 != 0) Thread.sleep(1000);
            System.out.println("Поток " + Thread.currentThread().getName() +
                    " сформировал предложение \"" + strings[0][number] + " " + strings[1][number] + "\"");

            strings[1][number] = exchanger.exchange(strings[1][number]);

            Thread.sleep(1000);
            if (number % 2 != 0) System.out.println("Потоки обмениваются словами...");
            Thread.sleep(3500);
            if (number % 2 != 0) Thread.sleep(1000);
            System.out.println("Поток " + Thread.currentThread().getName() +
                    " сформировал новое предложение \"" + strings[0][number] + " " + strings[1][number] + "\"");
            if (number % 2 != 0) System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}