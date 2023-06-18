package Prof32Homework_13_06_2023.Exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangerApp {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Exchanger<String> exchanger = new Exchanger<>();
        String[][] strings = new String[][]{
                new String[]{"Hello", "Great", "Wide", "Fast", "Exclusive", "Glorious", "Red", "Big", "Fine", "New"},
                new String[]{"World", "House", "Street", "Car", "Shop", "Man", "Sun", "Tree", "Dog", "Telephone"}};

        for (int i = 0; i < 10; i++) {
            executorService.execute(new StringSwitcher(i, strings, exchanger));
        }
        executorService.shutdown();
    }
}