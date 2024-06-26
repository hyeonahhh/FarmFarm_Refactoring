package com.example.farmfarm_refact.converter;


import com.example.farmfarm_refact.dto.FarmRequestDto;
import com.example.farmfarm_refact.dto.FarmResponseDto;
import com.example.farmfarm_refact.dto.ProductRequestDto;
import com.example.farmfarm_refact.dto.ProductResponseDto;
import com.example.farmfarm_refact.entity.FarmEntity;
import com.example.farmfarm_refact.entity.ProductEntity;

import java.util.List;
import java.util.stream.Collectors;


public class ProductConverter {

  // 요청
//  public static ProductEntity toProductEntity(ProductRequestDto.ProductCreateRequestDto productCreateRequestDto) {
//
//      return ProductEntity.builder()
//              .name(farmCreateRequestDto.getName())
//              .locationCity(farmCreateRequestDto.getLocationCity())
//              .locationGu(farmCreateRequestDto.getLocationGu())
//              .locationFull(farmCreateRequestDto.getLocationFull())
//              .locationDetail(farmCreateRequestDto.getLocationDetail())
//              .detail(farmCreateRequestDto.getDetail())
//              .image(farmCreateRequestDto.getImage())
//              .auction_time(farmCreateRequestDto.getAuction_time())
//        .build();
//  }
  public static ProductResponseDto.ProductCreateResponseDto toProductCreateResponseDto(ProductEntity product) {
      return ProductResponseDto.ProductCreateResponseDto.builder()
              .pId(product.getPId())
              .build();
  }

    // ProductEntity를 ProductListDto로 변환하는 메서드
    public static ProductResponseDto.ProductListDto toProductDto(ProductEntity product) {
        return ProductResponseDto.ProductListDto.builder()
                .pId(product.getPId())
                .build();
    }

    // ProductEntity 리스트를 ProductListResponseDto로 변환하는 메서드
  public static ProductResponseDto.ProductListResponseDto toProductList(List<ProductEntity> productList) {
      List<ProductResponseDto.ProductListDto> productDtoList = productList.stream()
              .map(ProductConverter::toProductDto)
              .collect(Collectors.toList());

      return ProductResponseDto.ProductListResponseDto.builder()
              .productList(productDtoList)
              .build();
  }
}
