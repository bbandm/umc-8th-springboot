package umc.week7.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.week7.domain.Member;
import umc.week7.domain.Mission;
import umc.week7.domain.mapping.MemberMission;
import umc.week7.repository.MemberMissionRepository.MemberMissionRepository;
import umc.week7.repository.MemberRepository.MemberRepository;
import umc.week7.repository.MissionRepository.MissionRepository;
import umc.week7.web.dto.MissionRequestDTO;
import umc.week7.converter.MissionConverter;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Transactional
    public void challengeMission(MissionRequestDTO.ChallengeDto dto) {
        Member member = memberRepository.findById(dto.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("해당 회원이 존재하지 않습니다."));

        Mission mission = missionRepository.findById(dto.getMissionId())
                .orElseThrow(() -> new IllegalArgumentException("해당 미션이 존재하지 않습니다."));

        MemberMission memberMission = MissionConverter.toMemberMission(member, mission);
        memberMissionRepository.save(memberMission);
    }
}