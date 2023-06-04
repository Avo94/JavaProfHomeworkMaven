package Prof25Homework_16_05_2023;

import java.util.HashMap;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

public class Student {
    private int id;
    private String name;
    private int age;
    private Degree degree;
    private static Map<Integer, Student> allStudents = new HashMap<>();
    private static int countId = 0;

    public Student(String name, int age, Degree degree) {
        this.id = countId++;
        this.name = name;
        this.age = age;
        this.degree = degree;
        allStudents.put(id, this);
    }

    public int getAge() {
        return age;
    }

    public Degree getDegree() {
        return degree;
    }

    public static Map<Integer, Student> getAllStudents() {
        return allStudents;
    }

    public static Set<Map.Entry<Integer, Student>> getListOfStudents() {
        return allStudents.entrySet();
    }

    public static Set<Map.Entry<Integer, Student>> getListOfStudents(Degree degree) {
        return allStudents.entrySet().stream()
                .filter(x -> x.getValue().getDegree().equals(degree))
                .collect(Collectors.toSet());
    }

    public static int getAverageAge() {
        OptionalDouble average = allStudents.values().stream().mapToInt(Student::getAge).average();
        return (int) Math.round(average.orElse(0));
    }

    public static int getAverageAge(Degree degree) {
        OptionalDouble average = allStudents.values().stream().filter(x -> x.getDegree().equals(degree))
                .mapToInt(Student::getAge).average();
        return (int) Math.round(average.orElse(0));
    }

    @Override
    public String toString() {
        return name + "-" + age + "-" + degree;
    }
}
