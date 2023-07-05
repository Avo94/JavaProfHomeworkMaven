package Prof34Homework_22_06_2023;

//В данном классе должно быть получено только поле name
//префикс BE

@ExecutableAnnotation(prefix = "BE")
public class StudentBE extends AbstractStudent {

    @ExecutableAnnotation(prefix = "name")
    private final String name;

    private final String surname;

    public StudentBE() {
        name = NameUtil.getRandomName();
        surname = NameUtil.getRandomName();
    }
}