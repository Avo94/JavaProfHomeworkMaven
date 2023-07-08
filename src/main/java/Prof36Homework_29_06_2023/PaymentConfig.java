package Prof36Homework_29_06_2023;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("Prof36Homework_29_06_2023")
public class PaymentConfig {

    @Bean
    public static Card card() {
        return new Card();
    }

    @Bean
    public static Cash cash() {
        return new Cash();
    }

    @Bean
    public static Check check() {
        return new Check();
    }
}
