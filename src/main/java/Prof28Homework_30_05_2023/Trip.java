package Prof28Homework_30_05_2023;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Trip {

    private final String source;
    private final String destination;
    private final int hours;
    private final double price;
    private final GregorianCalendar startDate;
    private final GregorianCalendar returnDate;

    public Trip(String source, String destination, int hours,
                double price, GregorianCalendar startDate, GregorianCalendar returnDate) {
        this.source = source;
        this.destination = destination;
        this.hours = hours;
        this.price = price;
        this.startDate = startDate;
        this.returnDate = returnDate;
    }

    public double getPrice() {
        return price;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public GregorianCalendar getStartDate() {
        return startDate;
    }

    public GregorianCalendar getReturnDate() {
        return returnDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yy");
        String formatStartDate = simpleDateFormat.format(startDate.getTime());
        String formatReturnDate = simpleDateFormat.format(returnDate.getTime());
        return source + " - " + destination + ", " + hours + " hours. "
                + price + " euro. " + formatStartDate + " - " + formatReturnDate;
    }
}