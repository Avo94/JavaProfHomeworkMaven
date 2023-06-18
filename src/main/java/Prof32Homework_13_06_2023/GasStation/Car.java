package Prof32Homework_13_06_2023.GasStation;

import java.util.concurrent.Semaphore;

public class Car implements Runnable {

    private final String carName;
    private final Semaphore semaphore;
    private final boolean[] freeGasStations;

    public Car(String carName, Semaphore semaphore, boolean[] freeGasStations) {
        this.carName = carName;
        this.semaphore = semaphore;
        this.freeGasStations = freeGasStations;
    }

    @Override
    public void run() {
        System.out.println("Автомобиль " + carName + " подъехал к заправке и ожидает...");
        try {
            semaphore.acquire();
            int tempGasStation = -1;

            synchronized (freeGasStations) {
                for (int i = 0; i < freeGasStations.length; i++) {
                    if (!freeGasStations[i]) {
                        freeGasStations[i] = true;
                        System.out.println(carName + " занял " + (i + 1) + " колонку для заправки.");
                        tempGasStation = i;
                        break;
                    }
                }
            }

            Thread.sleep(4350); // tanking
            synchronized (freeGasStations) {
                semaphore.release();
                freeGasStations[tempGasStation] = false;
                System.out.println("Автомобиль " + carName + " заправился и освободил " + (tempGasStation + 1) + " колонку.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
