package kdjsystem.mllink.repository;

import kdjsystem.mllink.domain.Member;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public  class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;




    @Test
    @Transactional
    @Commit
    public  void testMember(){
        // given
        Member member = new Member();
        member.setName("memberA");

        // when
        //Long id = memberRepository.save(member);
        //Member findMember = memberRepository.find(id);

        // then
       // assertThat(id).isEqualTo(findMember.getId());
      //  assertThat(findMember).isEqualTo(member);
    }

}