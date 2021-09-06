package hello.core.member;

public class MemberServiceImpl implements MemberService {

    //  Ctrl Shift Enter하면 ;랑 엔터 자동 완성됨
    //  private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;


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
}
