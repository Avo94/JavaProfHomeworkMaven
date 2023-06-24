package Prof32Homework_13_06_2023.Hippodrome;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class ResultPrinter implements Callable<Map<Horse, Long>> {

    private final Map<Horse, Long> resultMap;
    private final String[] horses;

    public ResultPrinter(Map<Horse, Long> resultMap, String[] horses) {
        this.resultMap = resultMap;
        this.horses = horses;
    }

    @Override
    public Map<Horse, Long> call() {
        Map<Horse, Long> result = new HashMap<>();
        while (resultMap.size() < horses.length) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        resultMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEach(x -> result.put(x.getKey(), x.getValue()));
        return result;
    }
}