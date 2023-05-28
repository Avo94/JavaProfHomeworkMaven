package Prof26Homework_23_05_2023;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class AdditionalTasks {
    public static void main(String[] args) {

        // a)
        GregorianCalendar myDateOfBirth = new GregorianCalendar(1994, Calendar.OCTOBER, 12);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMMM yyyy");
        System.out.println("Мой день рождения - " + simpleDateFormat.format(myDateOfBirth.getTime()) + "\n");

        // b)
        GregorianCalendar checkForFridayDate = new GregorianCalendar(1985, Calendar.JANUARY, 10);
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("EEEEE");
        String dayOfWeek = simpleDateFormat1.format(checkForFridayDate.getTime());
        if (dayOfWeek.equals("пятница")) System.out.println("10 января 1985 - это пятница");
        else System.out.println("10 января 1985 - это " + dayOfWeek);

        // c)
        checkForFridayDate.add(Calendar.YEAR, -10);
        String friday = simpleDateFormat1.format(checkForFridayDate.getTime());
        if (friday.equals("пятница")) System.out.println("А вот " +
                simpleDateFormat.format(checkForFridayDate.getTime()) + " - это пятница! =)\n");

        // d)
        LocalDateTime myTime = LocalDateTime.now();
        ZoneId id = ZoneId.of("Pacific/Midway");
        ZonedDateTime resultTime = ZonedDateTime.of(myTime, id);
        System.out.println(resultTime);
    }
}
