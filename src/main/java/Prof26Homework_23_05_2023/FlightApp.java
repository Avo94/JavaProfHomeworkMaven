package Prof26Homework_23_05_2023;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FlightApp {
    public static void main(String[] args) {

        String exit;
        List<Trip> routes = List.of(
                new Trip("Warsaw", "Madrid", 4, 220.57,
                        new GregorianCalendar(2023, Calendar.MAY, 15),
                        new GregorianCalendar(2023, Calendar.MAY, 19)),
                new Trip("Berlin", "Athens", 6, 291.12,
                        new GregorianCalendar(2023, Calendar.JUNE, 18),
                        new GregorianCalendar(2023, Calendar.JUNE, 27)),
                new Trip("Lisbon", "London", 3, 85.98,
                        new GregorianCalendar(2023, Calendar.MAY, 4),
                        new GregorianCalendar(2023, Calendar.MAY, 17)),
                new Trip("Reykjavik", "Rome", 10, 713.5,
                        new GregorianCalendar(2023, Calendar.MAY, 31),
                        new GregorianCalendar(2023, Calendar.JUNE, 2)),
                new Trip("Brussels", "Belgrade", 5, 384.12,
                        new GregorianCalendar(2023, Calendar.MAY, 17),
                        new GregorianCalendar(2023, Calendar.JUNE, 4)),
                new Trip("Riga", "Sofia", 4, 244.45,
                        new GregorianCalendar(2023, Calendar.JUNE, 24),
                        new GregorianCalendar(2023, Calendar.JUNE, 28)),
                new Trip("Paris", "London", 2, 152.99,
                        new GregorianCalendar(2023, Calendar.MAY, 15),
                        new GregorianCalendar(2023, Calendar.MAY, 19)),
                new Trip("Lisbon", "Belgrade", 12, 191,
                        new GregorianCalendar(2023, Calendar.JUNE, 20),
                        new GregorianCalendar(2023, Calendar.JUNE, 28)),
                new Trip("Dublin", "Bucharest", 7, 748.4,
                        new GregorianCalendar(2023, Calendar.JULY, 1),
                        new GregorianCalendar(2023, Calendar.JULY, 22)),
                new Trip("Riga", "Madrid", 6, 267.5,
                        new GregorianCalendar(2023, Calendar.MAY, 19),
                        new GregorianCalendar(2023, Calendar.MAY, 31)));

        // A
        System.out.println("(A) Список всех поездок:");
        routes.forEach(System.out::println);

        // B
        System.out.println("\n(B) Список поездок, отсортированных по возрастанию цены:");
        routes.stream().sorted(Comparator.comparingDouble(Trip::getPrice)).forEach(System.out::println);

        // C
        System.out.println("\n(C) Список поездок, отсортированных по убыванию цены:");
        routes.stream().sorted(Comparator.comparingDouble(Trip::getPrice).reversed()).forEach(System.out::println);

        do {
            // D
            Scanner decimal = new Scanner(System.in);
            System.out.println("\nВведите минимальное значение диапазона цен, в котором хотите найти билеты:");
            double minPrice = decimal.nextDouble();
            System.out.println("Введите максимальное значение диапазона цен, в котором хотите найти билеты:");
            double maxPrice = decimal.nextDouble();
            System.out.println("\n(D) Список поездок в указанном ценовом диапазоне:");
            routes.stream().filter(x -> x.getPrice() >= minPrice && x.getPrice() <= maxPrice).forEach(System.out::println);

            // E
            System.out.println("\nВыберете город начала поездки из списка доступных:");
            System.out.println(routes.stream().map(Trip::getSource).collect(Collectors.toSet()));
            String source = new Scanner(System.in).nextLine();
            System.out.println("\n(E) Все доступыне поездки из выбранного города:");
            routes.stream().filter(x -> source.equals(x.getSource())).forEach(System.out::println);

            // F
            System.out.println("\nВведите минимальное значение диапазона цен из города " + source + ":");
            double sourceMinPrice = decimal.nextDouble();
            System.out.println("Введите максимальное значение диапазона цен из города " + source + ":");
            double sourceMaxPrice = decimal.nextDouble();
            System.out.println("\n(F) Список поездок в указанном ценовом диапазоне из города " + source + ":");
            routes.stream().filter(x -> source.equals(x.getSource()))
                    .filter(x -> x.getPrice() >= sourceMinPrice && x.getPrice() <= sourceMaxPrice)
                    .forEach(System.out::println);

            // New option 1
            System.out.println("\nВы можете увидеть все поездки в указанном диапазоне дат. " +
                    "Необходима дата начала диапазона поиска.");
            GregorianCalendar startDate = setTime();
            System.out.println("\nТеперь необходима дата конца диапазона поиска.");
            GregorianCalendar endDate = setTime();
            System.out.println("\n(New option (1)) Список поездок в указанном временном диапазоне:");
            routes.stream().filter(x -> x.getStartDate().compareTo(startDate) >= 0 &&
                    x.getReturnDate().compareTo(endDate) <= 0).forEach(System.out::println);

            // New option 2
            System.out.println("\nТакже вы можете найти все вылеты в указанном диапазоне. " +
                    "Необходима дата вылета и интервал дат для поиска.");
            GregorianCalendar startDateTwo = setTime();
            GregorianCalendar[] departureDatesInterval = getDatesInterval(startDateTwo);
            System.out.println("\n(New option (2)) Список всех вылетов в указанном временном диапазоне:");
            routes.stream().filter(x -> x.getStartDate().compareTo(departureDatesInterval[0]) >= 0 &&
                    x.getStartDate().compareTo(departureDatesInterval[1]) <= 0).forEach(System.out::println);

            // New option 3
            System.out.println("\nТакже вы можете найти все прилёты в указанном диапазоне. " +
                    "Необходима дата прилёта и интервал дат для поиска.");
            GregorianCalendar endDateTwo = setTime();
            GregorianCalendar[] arrivalDatesInterval = getDatesInterval(endDateTwo);
            System.out.println("\n(New option (3)) Список всех прилётов в указанном временном диапазоне:");
            routes.stream().filter(x -> x.getReturnDate().compareTo(arrivalDatesInterval[0]) >= 0 &&
                    x.getReturnDate().compareTo(arrivalDatesInterval[1]) <= 0).forEach(System.out::println);

            System.out.println("\nНажмите Enter, чтобы использвать программу повторно. Чтобы выйти введите exit.");
            exit = new Scanner(System.in).nextLine();
        } while (!"exit".equals(exit));

        // G
        System.out.println("\n(G) Общее количество доступных поездок - " + routes.size());
        List<Double> minTripPrice = routes.stream().sorted(Comparator.comparingDouble(Trip::getPrice))
                .limit(1).map(Trip::getPrice).toList();
        System.out.println("Минимальная цена поездки - " + minTripPrice + " euro");
        List<Double> maxTripPrice = routes.stream().sorted(Comparator.comparingDouble(Trip::getPrice).reversed())
                .limit(1).map(Trip::getPrice).toList();
        System.out.println("Максимальная цена поездки - " + maxTripPrice + " euro");
        Set<String> sourceList = routes.stream().map(Trip::getSource).collect(Collectors.toSet());
        System.out.println("Список всех городов отправления - " + sourceList);
        Set<String> destinationList = routes.stream().map(Trip::getDestination).collect(Collectors.toSet());
        System.out.println("Список всех городов прибытия - " + destinationList);
    }

    public static GregorianCalendar setTime() {
        String date;
        boolean correctDate;
        do {
            System.out.println("Введите дату в формате dd.MM.yy:");
            date = new Scanner(System.in).nextLine();
            Pattern pattern = Pattern.compile("((0?[1-9]|[1-2]\\d|3[0-1])\\.(0?[1-9]|1[0-2])\\.23)");
            correctDate = pattern.matcher(date).matches();
        } while (!correctDate);
        String[] split = date.split("\\.");
        return new GregorianCalendar(Integer.parseInt(split[2]) + 2000,
                Integer.parseInt(split[1]) - 1, Integer.parseInt(split[0]));
    }

    public static GregorianCalendar[] getDatesInterval(GregorianCalendar tripDate) {
        System.out.println("Введите число дней от указанной даты в диапазоне которых хотите найти все рейсы.");
        int interval = new Scanner(System.in).nextInt();
        GregorianCalendar afterTripDate = tripDate;
        GregorianCalendar beforeTripDate = tripDate;
        afterTripDate.add(Calendar.DATE, interval);
        beforeTripDate.add(Calendar.DATE, (-1) * interval);
        return new GregorianCalendar[]{beforeTripDate, afterTripDate};
    }
}