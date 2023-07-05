package Prof34Homework_22_06_2023;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/*
1.В классы можно добавлять только аннотации над методами или полями и классам
Добавлять что-то еще нельзя.
2.Определять какие поля должны быть использованы в результате, можно только
по аннотациям. Аналогично, какой метод нужно вызвать только по аннотации.
3. instanceof - не используем
4. Указывать явно имена классов или полей и методов - нельзя. Только по аннотации
Для того что бы понять есть ли там аннотация - используйте isAnnotationPresent
5. Должна быть только одна собственная аннотация для всех полей, классов и метода.
 */

public class StringCollectorApp {

    public static void main(String[] args) throws Exception {

        List<String> strings = Arrays.asList("Prof34Homework_22_06_2023.StudentBE",
                "Prof34Homework_22_06_2023.StudentFE",
                "Prof34Homework_22_06_2023.StudentQA");

        List<AbstractStudent> studentList = new ArrayList<>();

        //Создаем список из 20 студентов с помощью reflection
        for (int i = 0; i < 20; i++) {
            int index = ThreadLocalRandom.current().nextInt(0, 3);
            String className = strings.get(index);
            AbstractStudent student = (AbstractStudent) Class.forName(className).getDeclaredConstructor().newInstance();
            studentList.add(student);
        }

        //Здесь написать логику , которая переберет все объекты в списке
        //определит по аннотации к какому типу относится данный объект
        //(каждый класс помеченный аннотацией, должен иметь поле префикс в аннотации)

        AbstractStudent result = (AbstractStudent) Class.forName("Prof34Homework_22_06_2023.Result")
                .getDeclaredConstructor().newInstance();
        Method[] methods = result.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(ExecutableAnnotation.class)) {
                method.setAccessible(true);
                for (AbstractStudent student : studentList) {
                    Field[] fields = student.getClass().getDeclaredFields();
                    for (Field field : fields) {
                        if (field.isAnnotationPresent(ExecutableAnnotation.class)) {
                            field.setAccessible(true);
                            method.invoke(result, student.getClass()
                                    .getAnnotation(ExecutableAnnotation.class)
                                    .prefix() + " " + field.get(student));
                        }
                    }
                }
            }
        }

        //Вся собранная информация должна добавиться в одну строку.
        //Например : из объекта типа StudentBE - берем префикс из аннотации класса + добавляем
        //значение из поля , которое должно быть помечено этой же аннотацией в классе
        //(внутри каждого класса прописано, какие поля нужно пометить и какой префикс должен быть)
        //что бы получить значение поля через reflection api - используем метод get у поля, в который
        //передаем тот объект у которого получаем. Не забывайте, если поли приватное, то нужно дать к нему доступ.

        //После того как вся информация из полей будет добавлена в результирующую строку, создать
        //объект типа Result и вызвать у него метод помеченный аннотацией.
        //в метод передать результирующую строку
    }
}