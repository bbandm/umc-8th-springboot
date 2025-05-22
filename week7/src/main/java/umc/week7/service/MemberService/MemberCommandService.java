package umc.week7.service.MemberService;

import umc.week7.domain.Member;
import umc.week7.web.dto.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);

}
