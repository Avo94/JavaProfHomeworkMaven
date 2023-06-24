package Prof32Homework_13_06_2023.Hippodrome;

import java.util.Map;

public class Horse implements Runnable, Comparable<Horse> {
    private final String name;
    private final double step;
    private final Map<Horse, Long> resultsRecords;
    private final int hippodromeLength;

    public Horse(String name, Map<Horse, Long> resultsRecords, int hippodromeLength) {
        this.name = name;
        this.step = Math.random() * 2;
        this.resultsRecords = resultsRecords;
        this.hippodromeLength = hippodromeLength;
    }

    @Override
    public void run() {
        double alreadyRan = 0;
        while (alreadyRan <= hippodromeLength) {
            alreadyRan += step;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        resultsRecords.put(this, System.currentTimeMillis());
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Horse o) {
        return 0;
    }
}