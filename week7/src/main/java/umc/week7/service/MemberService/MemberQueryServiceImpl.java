package umc.week7.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import umc.week7.apiPayload.code.status.ErrorStatus;
import umc.week7.domain.Member;
import umc.week7.web.dto.MemberResponseDTO;

public class MemberQueryServiceImpl {

    @Override
    @Transactional(readOnly = true)
    public MemberResponseDTO.MemberInfoDTO getMemberInfo(HttpServletRequest request){
        Authentication authentication = jwtTokenProvider.extractAuthentication(request);
        String email = authentication.getName();

        Member member = memberRepository.findByEmail(email)
                .orElseThrow(()-> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        return MemberConverter.toMemberInfoDTO(member);
    }
}
