package Prof36Homework_29_06_2023;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PayApp {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(PaymentConfig.class);
        PaymentService paymentService = context.getBean(PaymentService.class);
        paymentService.pay(PaymentType.CASH);
        paymentService.pay(PaymentType.CARD);
        paymentService.pay(PaymentType.CHECK);
    }
}