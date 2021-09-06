package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

    //  Ctrl Shift Enter하면 ;랑 엔터 자동 완성됨
    //  private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;


    @Autowired // ac.getBean(MemberRepository.class)와 같이 동작한다.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
        // MemoryMemberRepository 구현 클래스에 대한 내용은 전혀 없다.
        // 오로지 MemberRepository 인터페이스에 대한 내용만 있다.
        // DIP를 지키고 있음
        // AppConfig에서 생성자 주입
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // AppConfig에서 memberRepository가 싱글톤 패턴으로 생성되고 있는지 확인할 테스트 용도로 만든 메서드
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}
