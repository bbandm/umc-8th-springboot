package umc.week7.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.week7.apiPayload.ApiResponse;
import umc.week7.service.MissionService.MissionCommandService;
import umc.week7.service.MissionService.MissionService;
import umc.week7.validation.annotation.ValidPage;
import umc.week7.web.dto.MissionRequestDTO;
import umc.week7.web.dto.MissionResponseDTO;

import java.util.List;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionRestController {

    private final MissionService missionService;
    private final MissionCommandService missionCommandService;

    @GetMapping("/store/{storeId}")
    @Operation(summary = "특정 가게의 미션 목록 조회", description = "특정 가게의 미션 목록을 페이지 단위로 조회합니다.")
    public ApiResponse<List<MissionResponseDTO.MissionResult>> getMissionByStore(
            @PathVariable Long storeId,
            @RequestParam("page") @ValidPage Integer page
    ) {
        int internalPage = page - 1;  // 1-based to 0-based page 변환
        List<MissionResponseDTO.MissionResult> result = missionService.getMissionByStore(storeId, internalPage);
        return ApiResponse.onSuccess(result);
    }

    @GetMapping("/my")
    @Operation(summary = "내가 진행중인 미션 목록 조회", description = "내가 현재 진행 중인 미션 목록을 페이지 단위로 조회합니다.")
    public ApiResponse<List<MissionResponseDTO.MissionResult>> getMyOngoingMissions(
            @RequestParam("memberId") Long memberId,
            @RequestParam("page") @ValidPage Integer page
    ) {
        int internalPage = page - 1;
        List<MissionResponseDTO.MissionResult> result = missionService.getMyOngoingMissions(memberId, internalPage);
        return ApiResponse.onSuccess(result);
    }

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