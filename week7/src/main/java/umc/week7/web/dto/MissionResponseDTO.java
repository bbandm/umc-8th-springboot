package umc.week7.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class MissionResponseDTO {

    @Getter
    @AllArgsConstructor
    public static class MissionResult {
        private Long missionId;
        private String missionSpec;
        private Integer reward;
    }
}
