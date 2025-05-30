package umc.week7.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.week7.apiPayload.ApiResponse;
import umc.week7.apiPayload.code.status.ErrorStatus;
import umc.week7.apiPayload.exception.handler.PageHandler;
import umc.week7.validation.annotation.StoreExists;
import umc.week7.service.ReviewService.ReviewService;
import umc.week7.validation.annotation.ValidPage;
import umc.week7.web.dto.ReviewRequestDTO;
import umc.week7.web.dto.ReviewResponseDTO;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewRestController {

    private final ReviewService reviewService;

    @GetMapping("/my")
    @Operation(summary = "내가 작성한 리뷰 목록 조회", description = "내 리뷰 목록을 페이징 처리하며 조회합니다.")
    public ApiResponse<List<ReviewResponseDTO>> getMyReviews(
            @Parameter(description = "페이지 번호 (1부터 시작)", example = "1")
            @RequestParam("page") @ValidPage Integer page,
            @RequestParam Long memberId
    ) {
        int pageIndex = page - 1;
        return ApiResponse.onSuccess(reviewService.getMyReviews(memberId, pageIndex));
    }

    @PostMapping("/{storeId}/reviews")
    public void addReview(@PathVariable @StoreExists Long storeId,
                          @RequestBody @Valid ReviewRequestDTO.CreateDto reviewRequestDto) {
        reviewService.createReview(storeId, reviewRequestDto);
    }

}
