package Prof34Homework_22_06_2023;

//В данном классе должно быть получено только поле number
//префикс QA

@ExecutableAnnotation(prefix = "QA")
public class StudentQA extends AbstractStudent {

    private final String name;

    private final String surname;

    @ExecutableAnnotation(prefix = "number")
    private final String number;

    public StudentQA() {
        name = NameUtil.getRandomName();
        surname = NameUtil.getRandomName();
        number = NameUtil.getRandomNumber();
    }
}
