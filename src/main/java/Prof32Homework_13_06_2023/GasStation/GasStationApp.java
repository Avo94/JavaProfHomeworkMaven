package Prof32Homework_13_06_2023.GasStation;

import java.util.GregorianCalendar;
import java.util.concurrent.Semaphore;

public class GasStationApp {

    public static void main(String[] args) throws InterruptedException {
        WorkingTime workingTime = new WorkingTime(new GregorianCalendar(), 60);
        long stopTime = workingTime.getTime().getTime().getTime();
        long currentTime = 0;

        Semaphore semaphore = new Semaphore(4, false);
        boolean[] freeGasStations = new boolean[4];

        int i = 0;
        while (stopTime > currentTime) {
            i++;
            new Thread(new Car(String.valueOf(i), semaphore, freeGasStations)).start();
            Thread.sleep(900);
            currentTime = new GregorianCalendar().getTime().getTime();
        }
    }
}
