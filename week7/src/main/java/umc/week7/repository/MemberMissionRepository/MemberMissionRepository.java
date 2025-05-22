package umc.week7.repository.MemberMissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.week7.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    boolean existsByMemberIdAndMissionId(Long memberId, Long missionId);
}