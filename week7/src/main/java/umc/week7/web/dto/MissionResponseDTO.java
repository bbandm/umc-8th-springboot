package umc.week7.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class MissionResponseDTO {

    @Getter
    @Builder
    @AllArgsConstructor
    public static class MissionResult {
        private Long missionId;
        private String missionSpec;
        private Integer reward;
    }
}
