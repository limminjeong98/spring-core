package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // @Bean memberService -> new MemoryMemberRepository()
    // @Bean orderService -> new MemoryMemberRepository()

    /**
     * 의도했던 메서드 호출에 의한 출력
     * 스프링(@Configuration annotation)에서 싱글턴을 보장해주고 있기 때문에 아래와 같이 출력되지 않는다.
     * @Configuration 을 지우면 아래와 같이 실행되고 인스턴스도 다르다.
     * call AppConfig.memberService
     * call AppConfig.memberRepository
     * call AppConfig.memberRepository
     * call AppConfig.orderService
     * call AppConfig.memberRepository
     */

    /**
     * 실제 실행했을 때 출력 결과
     * call AppConfig.memberService
     * call AppConfig.memberRepository
     * call AppConfig.orderService
     */


    @Bean
    public MemberService memberService() {
//        sout 탭치면 자동완성
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    /**
     * MemberServiceImpl의 생성자를 통해 구현 클래스 MemoryMemberRepository의
     * 의존관계를 받지 않고 MemoryServiceImpl에서는 인터페이스 MemberRepository만
     * 사용될 수 있도록 하는 생성자 주입 방식
     */

    // new MemoryMemberRepository() 이부분을 드래그하고 Ctl Alt M 해서 클래스 memberRepository로 뽑아냄냄
    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
