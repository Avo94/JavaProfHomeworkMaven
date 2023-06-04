package Prof27Homework_25_05_2023;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;

import static Prof27Homework_25_05_2023.HorseRacing.*;

public class ResultPrinter implements Runnable {

    @Override
    public void run() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SS");
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }

            if (horses.size() == resultMap.size()) {
                resultMap.entrySet().stream()
                        .sorted(Comparator.comparingDouble(Map.Entry::getValue))
                        .forEach(x -> System.out.println(x.getKey() +
                                ", время финиша - " + simpleDateFormat.format(new Date(x.getValue()))));
                resultMap.forEach((k, v) -> System.out.println(k + ", время финиша - " + simpleDateFormat.format(new Date(v))));
                Thread.currentThread().interrupt();
            }
        }
    }
}
