package com.example.farmfarm_refact.service;

import com.example.farmfarm_refact.converter.MyPageConverter;
import com.example.farmfarm_refact.dto.MyPageResponseDto;
import com.example.farmfarm_refact.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class MyPageService {

    // 유저 이름, 농장 보여주기
    public MyPageResponseDto.myPageResponseDto mypage(UserEntity user) {
        return MyPageConverter.toMyPageResponseDto(user);
    }
}
