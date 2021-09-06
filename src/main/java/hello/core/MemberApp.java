package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

        /**
         AppConfig(DI 컨테이너 사용하기 전)
         MemberService memberService = new MemberServiceImpl();
         */

        /**
        Spring 없이 Java로만 짰을때
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
         */

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // 이렇게 하면 AppConfig에 @Bean으로 적은 클래스들 스프링 컨테이너, 빈에 등록해서 관리해준다
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        // 첫번째 파라미터는 AppConfig에 등록된 public 메서드 이름


        // Ctrl Alt V 하면 new의 왼쪽이 다 자동완성됨
        // id가 1이다. (long type이라 L붙여줘야 함)
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());

    }
}
