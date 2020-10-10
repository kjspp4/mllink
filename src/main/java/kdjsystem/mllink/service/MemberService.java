package kdjsystem.mllink.service;

import kdjsystem.mllink.domain.Member;
import kdjsystem.mllink.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional(readOnly = true) // 일기 옵션..
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    //  회원 가입
    @Transactional
    public Long join(Member member){
        validateDuplicateMember(member);  // 중복회원 체크..
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        // EXCEPTION
       List<Member> findMember =    memberRepository.findByName(member.getName());

       if(!findMember.isEmpty()){
           throw  new IllegalStateException("이미 존재하는 회원입니다...");
       }
    }


    //  회원 전체 조회. .

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    // 단건 조회..

    public Member findOne(Long id){
        return memberRepository.findOne(id);
    }

}
