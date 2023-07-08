package Prof36Homework_29_06_2023;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    Cash paymentByCash;
    Card paymentByCard;
    Check paymentByCheck;

    @Autowired
    public PaymentService() {
        paymentByCash = new Cash();
        paymentByCard = new Card();
        paymentByCheck = new Check();
    }

    public void pay(PaymentType type) {
        if (type.equals(PaymentType.CASH)) paymentByCash.pay();
        if (type.equals(PaymentType.CARD)) paymentByCard.pay();
        if (type.equals(PaymentType.CHECK)) paymentByCheck.pay();
    }
}