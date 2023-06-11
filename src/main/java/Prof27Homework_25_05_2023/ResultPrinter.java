package Prof27Homework_25_05_2023;

import java.text.SimpleDateFormat;
import java.util.Date;

import static Prof27Homework_25_05_2023.HorseRacing.*;

public class ResultPrinter implements Runnable {

    @Override
    public void run() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SS");
        while (resultMap.size() < horses.size()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        resultMap.forEach((k, v) -> System.out.println(k + ", время финиша - " + simpleDateFormat.format(new Date(v))));
    }
}