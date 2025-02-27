package com.example.farmfarm_refact.controller;

import com.example.farmfarm_refact.apiPayload.ApiResponse;
import com.example.farmfarm_refact.apiPayload.code.status.SuccessStatus;
import com.example.farmfarm_refact.dto.ReviewRequestDto;
import com.example.farmfarm_refact.dto.ReviewResponseDto;
import com.example.farmfarm_refact.entity.UserEntity;
import com.example.farmfarm_refact.service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // 리뷰 등록
    @PostMapping("/{odId}")
    public ApiResponse<ReviewResponseDto.ReviewCreateResponseDto> createReview(@AuthenticationPrincipal UserEntity user, @PathVariable Long odId, @RequestBody ReviewRequestDto.ReviewCreateRequestDto review) {
        return ApiResponse.onSuccess(reviewService.saveReview(user, odId, review));
    }

    // 리뷰 수정
    @PatchMapping("/{rId}")
    public ApiResponse updateReview(@AuthenticationPrincipal UserEntity user, @PathVariable Long rId, @RequestBody @Valid ReviewRequestDto.ReviewUpdateRequestDto reviewUpdateRequestDto) {
        reviewUpdateRequestDto.setRId(rId);
        reviewService.updateReview(user, rId, reviewUpdateRequestDto);
        return ApiResponse.onSuccess(SuccessStatus.LIMJANG_UPDATE);
    }

    // 리뷰 삭제
    @DeleteMapping("/{rId}")
    public ApiResponse deleteReviw(@AuthenticationPrincipal UserEntity user, @PathVariable Long rId) {
        reviewService.deleteReview(user, rId);
        return ApiResponse.onSuccess(SuccessStatus.LIMJANG_DELETE);
    }

    // 상품별 리뷰 조회
    @GetMapping("/{pId}")
    public ApiResponse<ReviewResponseDto.ReviewListResponseDto> getProductReviewList(@PathVariable Long pId) {
        return ApiResponse.onSuccess(reviewService.getProductReviewList(pId));
    }


    // 내가 쓴 리뷰 보기
    @GetMapping("/my")
    public ApiResponse<ReviewResponseDto.ReviewListResponseDto> getMyReviewList(@AuthenticationPrincipal UserEntity user) {
        return ApiResponse.onSuccess(reviewService.getMyReviewList(user));
    }

}
