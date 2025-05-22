package umc.week7.repository.MissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.week7.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}