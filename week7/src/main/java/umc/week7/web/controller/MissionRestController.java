package umc.week7.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.week7.service.MissionService.MissionCommandService;
import umc.week7.service.MissionService.MissionService;
import umc.week7.web.dto.MissionRequestDTO;
import umc.week7.web.dto.MissionResponseDTO;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionRestController {

    private final MissionService missionService;
    private final MissionCommandService missionCommandService;

    @PostMapping("/challenge")
    public ResponseEntity<String> challengeMission(@RequestBody @Valid MissionRequestDTO.ChallengeDto request) {
        missionService.challengeMission(request);
        return ResponseEntity.ok("미션 도전이 성공적으로 등록되었습니다.");
    }

    @PostMapping
    public ResponseEntity<MissionResponseDTO.MissionResult> createMission(@RequestBody MissionRequestDTO.CreateMission request) {
        MissionResponseDTO.MissionResult response = missionCommandService.createMission(request);
        return ResponseEntity.ok(response);
    }
}