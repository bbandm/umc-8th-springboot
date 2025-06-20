package umc.week7.repository.MemberRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.week7.domain.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);
}