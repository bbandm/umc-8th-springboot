package umc.week7.repository.MemberRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.week7.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}