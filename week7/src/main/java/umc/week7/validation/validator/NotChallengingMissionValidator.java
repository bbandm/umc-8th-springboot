package umc.week7.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.week7.validation.annotation.ValidNotChallengingMission;
import umc.week7.repository.MemberMissionRepository.MemberMissionRepository;
import umc.week7.web.dto.MissionRequestDTO;

@Component
@RequiredArgsConstructor
public class NotChallengingMissionValidator implements ConstraintValidator<ValidNotChallengingMission, MissionRequestDTO.ChallengeDto> {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public boolean isValid(MissionRequestDTO.ChallengeDto dto, ConstraintValidatorContext context) {
        if (dto.getMemberId() == null || dto.getMissionId() == null) {
            return false;
        }

        return !memberMissionRepository.existsByMemberIdAndMissionId(dto.getMemberId(), dto.getMissionId());
    }
}