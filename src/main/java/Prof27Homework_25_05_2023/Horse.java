package Prof27Homework_25_05_2023;

import java.util.GregorianCalendar;

import static Prof27Homework_25_05_2023.HorseRacing.*;

public class Horse implements Runnable {
    private final String name;
    private final double step;

    public Horse(String name) {
        this.name = name;
        this.step = Math.random() * 2;
    }

    @Override
    public void run() {
        double alreadyRan = 0;
        while (alreadyRan < hippodromeLength) {
            alreadyRan += this.step;
        }
        resultMap.put(this.name, new GregorianCalendar().getTime().getTime());
    }
}