package umc.week7.converter;

import umc.week7.domain.Member;
import umc.week7.domain.Review;
import umc.week7.domain.Store;
import umc.week7.web.dto.ReviewRequestDTO;

public class ReviewConverter {

    public static Review toReviewEntity(ReviewRequestDTO.CreateDto dto, Member member, Store store) {
        return Review.builder()
                .content(dto.getContent())
                .rating(dto.getRating())
                .member(member)
                .store(store)
                .build();
    }
}