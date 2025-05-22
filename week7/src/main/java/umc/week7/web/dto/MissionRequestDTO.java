package umc.week7.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.week7.validation.annotation.ValidNotChallengingMission;

import java.time.LocalDate;

public class MissionRequestDTO {

    @Getter
    public static class CreateMission {
        private Long storeId;
        private Integer reward;
        private LocalDate deadline;
        private String missionSpec;
    }

    @Getter
    public static class ChallengeDto {

        @NotNull
        private Long memberId;

        @NotNull
        private Long missionId;
    }
}