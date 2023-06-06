package Prof29Homework_01_06_2023;

import java.time.LocalDate;

import static Prof29Homework_01_06_2023.EventCreator.*;

public class User implements Runnable {

    private static int createEventsCounter = 0;
    private final String userName;
    private final String userIp;

    public User(String userName, String userIp) {
        this.userName = userName;
        this.userIp = userIp;
    }

    @Override
    public synchronized void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep((int) (Math.random() * programLifetime * 1000));
            } catch (InterruptedException e) {
                break;
            }

            EventState eventState;
            int random = (int) (Math.random() * 2);
            if (random < 1) eventState = EventState.ACCESS_DENIED;
            else if (random > 1) eventState = EventState.REQUEST_ERROR;
            else eventState = EventState.SUCCESS;
            if (createEventsCounter >= eventsList.length) expandArray();
            eventsList[createEventsCounter] = new Event(this.userName, this.userIp, LocalDate.now(), eventState);
            createEventsCounter++;
            System.out.println("Actions of user " + this.userName + " have been logged...");
        }
    }
}