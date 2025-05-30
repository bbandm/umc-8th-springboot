package umc.week7.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReviewResponseDTO {
    private Long reviewId;
    private String content;
    private Integer rating;
    private String storeName;
}
