package umc.week7.service.MissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.week7.apiPayload.code.status.ErrorStatus;
import umc.week7.apiPayload.exception.handler.StoreHandler;
import umc.week7.converter.MissionConverter;
import umc.week7.domain.Mission;
import umc.week7.domain.Store;
import umc.week7.repository.MissionRepository.MissionRepository;
import umc.week7.repository.StoreRepository.StoreRepository;
import umc.week7.web.dto.MissionRequestDTO;
import umc.week7.web.dto.MissionResponseDTO;

@Service
@RequiredArgsConstructor
@Transactional
public class MissionCommandServiceImpl implements MissionCommandService {

    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;

    @Override
    public MissionResponseDTO.MissionResult createMission(MissionRequestDTO.CreateMission request) {
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        Mission mission = MissionConverter.toMission(request, store);
        Mission savedMission = missionRepository.save(mission);

        // 연관관계 편의 메소드 또는 직접 리스트에 추가 (양방향 관리)
        store.getMissionList().add(savedMission);

        return MissionConverter.toMissionResult(savedMission);
    }
}