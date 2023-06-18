package Prof32Homework_13_06_2023.Hippodrome;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.*;

public class HorseRacing {

    public static void main(String[] args) throws Exception {
        final int hippodromeLength = 1000;
        String[] horses = new String[]{"Молния", "Мустанг", "Отчаянный", "Челюсти", "Эклипс",
                "Сухарь", "Афина", "Вендетта", "Великий", "Зорька"};
        Map<Horse, Long> resultsRecords = new ConcurrentHashMap<>();

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Horse(horses[i], resultsRecords, hippodromeLength));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SS");
        Map<Horse, Long> resultList = executorService.submit(new ResultPrinter(resultsRecords, horses)).get();
        resultList.forEach((k, v) -> System.out.println(k + ", время финиша - " + simpleDateFormat.format(new Date(v))));
        executorService.shutdown();
    }
}