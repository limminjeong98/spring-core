package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        /**
         // ThreadA : A사용자 10000원 주문문
         statefulService1.order("userA", 10000);
         // ThreadB : B사용자 10000원 주문문
         statefulService2.order("userB", 20000);

         // ThreadA : 사용자A 주문 금액 조회
         int price = statefulService1.getPrice();
         System.out.println("price = " + price); // 10000원이 나오길 기대했지만 20000원이 나옴

         Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);

         */

        // ThreadA : A사용자 10000원 주문문
        int userAPrice = statefulService1.order("userA", 10000);
        // ThreadB : B사용자 10000원 주문문
        int userBPrice = statefulService2.order("userB", 20000);

        // ThreadA : 사용자A 주문 금액 조회
//        int price = statefulService1.getPrice();
        System.out.println("price = " + userAPrice); // 이제 10000원이 나옴

//        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);


    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}
