package umc.week7.service.MissionService;

import umc.week7.web.dto.MissionRequestDTO;
import umc.week7.web.dto.MissionResponseDTO;

public interface MissionCommandService {
    MissionResponseDTO.MissionResult createMission(MissionRequestDTO.CreateMission request);
}