package umc.week7.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.week7.validation.annotation.StoreExists;
import umc.week7.service.ReviewService;
import umc.week7.web.dto.ReviewRequestDTO;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class ReviewRestController {

    private final ReviewService reviewService;

    @PostMapping("/{storeId}/reviews")
    public void addReview(@PathVariable @StoreExists Long storeId,
                          @RequestBody @Valid ReviewRequestDTO.CreateDto reviewRequestDto) {
        reviewService.createReview(storeId, reviewRequestDto);
    }

}
