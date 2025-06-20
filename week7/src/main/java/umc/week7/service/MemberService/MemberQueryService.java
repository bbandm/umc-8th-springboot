package umc.week7.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import umc.week7.web.dto.MemberResponseDTO;

public interface MemberQueryService {
    MemberResponseDTO.MemberInfoDTO getMemberInfo(HttpServletRequest request);
}
