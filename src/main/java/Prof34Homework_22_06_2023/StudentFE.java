package Prof34Homework_22_06_2023;

//В данном классе должно быть получено только поле surname
//префикс FE

@ExecutableAnnotation(prefix = "FE")
public class StudentFE extends AbstractStudent {

    private final String name;

    @ExecutableAnnotation(prefix = "surname")
    private final String surname;

    public StudentFE() {
        name = NameUtil.getRandomName();
        surname = NameUtil.getRandomName();
    }
}