package Prof25Homework_16_05_2023;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

class StudentTest {

    Map<Integer, Student> students = Student.getAllStudents();

    @Test
    void getListOfStudents() {
        Set<Map.Entry<Integer, Student>> actual = Student.getListOfStudents();
        Assertions.assertEquals(students.entrySet(), actual);
    }

    @Test
    void getListOfStudentsWithDegreeMaster() {
        Set<Map.Entry<Integer, Student>> expected = students.entrySet().stream()
                .filter(x -> x.getValue().getDegree().equals(new Degree("Master"))).collect(Collectors.toSet());
        Set<Map.Entry<Integer, Student>> masters = Student.getListOfStudents(new Degree("Master"));
        Assertions.assertEquals(expected, masters);
    }

    @Test
    void getListOfStudentsWithDegreeBachelor() {
        Set<Map.Entry<Integer, Student>> expected = students.entrySet().stream()
                .filter(x -> x.getValue().getDegree().equals(new Degree("Bachelor"))).collect(Collectors.toSet());
        Set<Map.Entry<Integer, Student>> bachelors = Student.getListOfStudents(new Degree("Bachelor"));
        Assertions.assertEquals(expected, bachelors);
    }

    @Test
    void getAverageAge() {
        OptionalDouble studentsAge = students.values().stream().mapToInt(Student::getAge).average();
        int expected = (int) Math.round(studentsAge.orElse(0));
        int averageAge = Student.getAverageAge();
        Assertions.assertEquals(expected, averageAge);
    }

    @Test
    void getAverageAgeWithDegreeMaster() {
        OptionalDouble average = students.values().stream().filter(x -> x.getDegree().equals(new Degree("Master")))
                .mapToInt(Student::getAge).average();
        int expected = (int) Math.round(average.orElse(0));
        int averageMastersAge = Student.getAverageAge(new Degree("Master"));
        Assertions.assertEquals(expected, averageMastersAge);
    }

    @Test
    void getAverageAgeWithDegreeBachelor() {
        OptionalDouble average = students.values().stream().filter(x -> x.getDegree().equals(new Degree("Bachelor")))
                .mapToInt(Student::getAge).average();
        int expected = (int) Math.round(average.orElse(0));
        int averageMastersAge = Student.getAverageAge(new Degree("Bachelor"));
        Assertions.assertEquals(expected, averageMastersAge);
    }
}