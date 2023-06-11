package Prof27Homework_25_05_2023;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HorseRacing {
    public static final int HIPPODROME_LENGTH = 1000;
    public static Map<Horse, Long> resultMap = new ConcurrentHashMap<>();
    public static List<Thread> horses;

    public static void main(String[] args) {

        Thread threadOne = new Thread(new Horse("Молния"));
        Thread threadTwo = new Thread(new Horse("Мустанг"));
        Thread threadThree = new Thread(new Horse("Отчаянный"));
        Thread threadFour = new Thread(new Horse("Челюсти"));
        Thread threadFive = new Thread(new Horse("Эклипс"));
        Thread threadSix = new Thread(new Horse("Сухарь"));
        Thread threadSeven = new Thread(new Horse("Афина"));
        Thread threadEight = new Thread(new Horse("Вендетта"));
        Thread threadNine = new Thread(new Horse("Великий"));
        Thread threadTen = new Thread(new Horse("Зорька"));

        horses = Arrays.asList(threadOne, threadTwo, threadThree, threadFour,
                threadFive, threadSix, threadSeven, threadEight, threadNine, threadTen);
        for (Thread horse : horses) {
            horse.start();
        }

        Thread printer = new Thread(new ResultPrinter());
        printer.start();
    }
}
