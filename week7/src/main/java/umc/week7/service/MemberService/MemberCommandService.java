package umc.week7.service.MemberService;

import umc.week7.domain.Member;
import umc.week7.web.dto.MemberRequestDTO;
import umc.week7.web.dto.MemberResponseDTO;

public interface MemberCommandService {
    static Member joinMember(MemberRequestDTO.JoinDto request);
    MemberResponseDTO.LoginResultDTO loginMember(MemberRequestDTO.LoginRequestDTO request);

}
