package Prof29Homework_01_06_2023;

import java.time.LocalDate;

public class Event {

    private static int eventId;
    private final String userName;
    private final String userIp;
    private final LocalDate eventDate;
    private final EventState eventState;

    public Event(String userName, String userIp, LocalDate eventDate, EventState eventState) {
        eventId++;
        this.userName = userName;
        this.userIp = userIp;
        this.eventDate = eventDate;
        this.eventState = eventState;
    }

    public int getEventId() {
        return eventId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserIp() {
        return userIp;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public EventState getEventState() {
        return eventState;
    }
}