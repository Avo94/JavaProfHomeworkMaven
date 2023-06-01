package Prof27Homework_25_05_2023;

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
        while (alreadyRan <= HIPPODROME_LENGTH) {
            alreadyRan += this.step;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        resultMap.put(this, System.currentTimeMillis());
    }

    @Override
    public String toString() {
        return name;
    }
}