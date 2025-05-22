package umc.week7.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.week7.domain.Member;
import umc.week7.domain.Review;
import umc.week7.domain.Store;
import umc.week7.repository.MemberRepository.MemberRepository;
import umc.week7.repository.ReviewRepository.ReviewRepository;
import umc.week7.repository.StoreRepository.StoreRepository;
import umc.week7.web.dto.ReviewRequestDTO;
import umc.week7.converter.ReviewConverter;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void createReview(Long storeId, ReviewRequestDTO.CreateDto dto) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 가게입니다."));

        // 로그인 기능 없으므로 DB에 있는 아무 회원 1명 하드코딩
        Member member = memberRepository.findAll().stream().findFirst()
                .orElseThrow(() -> new IllegalStateException("저장된 회원이 없습니다."));

        Review review = ReviewConverter.toReviewEntity(dto, member, store);
        reviewRepository.save(review);
    }
}
