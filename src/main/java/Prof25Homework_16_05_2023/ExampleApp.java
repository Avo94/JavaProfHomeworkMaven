package Prof25Homework_16_05_2023;

import java.util.Arrays;

public class ExampleApp {

    public static void main(String[] args) {

        //Part 1
        Calculator calculator = new Calculator();
        int max = calculator.max(new int[]{2, 4, 7, 1, 3});
        int min = calculator.min(new int[]{2, 4, 7, 1, 3});
        System.out.println(max);
        System.out.println(min);

        int[] exampleArray = new int[]{0, 3, -2, 4, 3, 2};
        int[] result = ArraysUtil.removeDuplicates(exampleArray);
        System.out.println(Arrays.toString(result));

        //Part 2
        Degree bachelor = new Degree("Bachelor");
        Degree master = new Degree("Master");

        new Student("Evgenij", 28, bachelor);
        new Student("Elena", 30, master);
        new Student("Anatolij", 36, master);
        new Student("Yulia", 23, bachelor);
        new Student("Roman", 33, bachelor);
        new Student("Victoria", 24, master);

        System.out.println("\nAll students");
        Student.getListOfStudents().forEach(System.out::println);
        System.out.println("\nBachelors");
        Student.getListOfStudents(bachelor).forEach(System.out::println);
        System.out.println("\nMasters");
        Student.getListOfStudents(master).forEach(System.out::println);

        System.out.println("\nAverage age of all Students");
        System.out.println(Student.getAverageAge());
        System.out.println("Average age of Bachelors");
        System.out.println(Student.getAverageAge(bachelor));
        System.out.println("Average age of Masters");
        System.out.println(Student.getAverageAge(master));
    }
}