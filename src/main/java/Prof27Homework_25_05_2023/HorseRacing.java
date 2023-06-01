package Prof27Homework_25_05_2023;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HorseRacing {
    public static final int HIPPODROME_LENGTH = 1000;
    public static Map<Horse, Long> resultMap = new ConcurrentHashMap<>();

    public static Thread threadOne;
    public static Thread threadTwo;
    public static Thread threadThree;
    public static Thread threadFour;
    public static Thread threadFive;
    public static Thread threadSix;
    public static Thread threadSeven;
    public static Thread threadEight;
    public static Thread threadNine;
    public static Thread threadTen;
    public static List<Thread> horses;

    public static void main(String[] args) {

        threadOne = new Thread(new Horse("Молния"));
        threadTwo = new Thread(new Horse("Мустанг"));
        threadThree = new Thread(new Horse("Отчаянный"));
        threadFour = new Thread(new Horse("Челюсти"));
        threadFive = new Thread(new Horse("Эклипс"));
        threadSix = new Thread(new Horse("Сухарь"));
        threadSeven = new Thread(new Horse("Афина"));
        threadEight = new Thread(new Horse("Вендетта"));
        threadNine = new Thread(new Horse("Великий"));
        threadTen = new Thread(new Horse("Зорька"));

        horses = Arrays.asList(threadOne, threadTwo, threadThree, threadFour,
                threadFive, threadSix, threadSeven, threadEight, threadNine, threadTen);
        for (Thread horse : horses) {
            horse.start();
        }

        Thread printer = new Thread(new ResultPrinter());
        printer.start();
    }
}
