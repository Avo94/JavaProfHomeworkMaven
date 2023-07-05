package Prof34Homework_22_06_2023;

//В данном классе должен быть вызван метод printStudentsInfo
public class Result extends AbstractStudent {

    public Result() {
        //
    }
@ExecutableAnnotation(prefix = "result")
    private void printStudentsInfo(String info) {
        System.out.println(info);
    }
}
