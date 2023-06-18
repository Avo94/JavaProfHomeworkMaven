package Prof32Homework_13_06_2023.GasStation;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class WorkingTime {

    private final GregorianCalendar time;

    public WorkingTime(GregorianCalendar start, int lifeTimeSeconds) {
        this.time = start;
        this.time.set(Calendar.SECOND, lifeTimeSeconds);
    }

    public GregorianCalendar getTime() {
        return time;
    }
}
