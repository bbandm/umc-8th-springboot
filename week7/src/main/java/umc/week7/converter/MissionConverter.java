package umc.week7.converter;

import umc.week7.domain.Member;
import umc.week7.domain.Mission;
import umc.week7.domain.Store;
import umc.week7.domain.mapping.MemberMission;
import umc.week7.web.dto.MissionRequestDTO;
import umc.week7.web.dto.MissionResponseDTO;

public class MissionConverter {

    public static MemberMission toMemberMission(Member member, Mission mission) {
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .build();
    }

    public static Mission toMission(MissionRequestDTO.CreateMission request, Store store) {
        return Mission.builder()
                .store(store)
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .missionSpec(request.getMissionSpec())
                .build();
    }

    public static MissionResponseDTO.MissionResult toMissionResult(Mission mission) {
        return new MissionResponseDTO.MissionResult(
                mission.getId(),
                mission.getMissionSpec(),
                mission.getReward()
        );
    }
}