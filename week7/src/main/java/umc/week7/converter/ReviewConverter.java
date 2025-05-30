package umc.week7.converter;

import umc.week7.domain.Member;
import umc.week7.domain.Review;
import umc.week7.domain.Store;
import umc.week7.web.dto.ReviewRequestDTO;
import umc.week7.web.dto.ReviewResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {

    public static Review toReviewEntity(ReviewRequestDTO.CreateDto dto, Member member, Store store) {
        return Review.builder()
                .content(dto.getContent())
                .rating(dto.getRating())
                .member(member)
                .store(store)
                .build();
    }

    public static List<ReviewResponseDTO> toReviewResponseDTOList(List<Review> reviewList) {
        return reviewList.stream()
                .map(review -> ReviewResponseDTO.builder()
                        .reviewId(review.getId())
                        .content(review.getContent())
                        .rating(review.getRating())
                        .storeName(review.getStore().getName())
                        .build())
                .collect(Collectors.toList());
    }
}