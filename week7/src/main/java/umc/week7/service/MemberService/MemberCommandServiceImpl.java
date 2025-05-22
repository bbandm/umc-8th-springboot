package umc.week7.service.MemberService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.week7.apiPayload.code.status.ErrorStatus;
import umc.week7.apiPayload.exception.handler.FoodCategoryHandler;
import umc.week7.converter.MemberConverter;
import umc.week7.converter.MemberPreferConverter;
import umc.week7.domain.FoodCategory;
import umc.week7.domain.Member;
import umc.week7.domain.mapping.MemberPrefer;
import umc.week7.repository.FoodCategoryRepository.FoodCategoryRepository;
import umc.week7.repository.MemberRepository.MemberRepository;
import umc.week7.web.dto.MemberRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}