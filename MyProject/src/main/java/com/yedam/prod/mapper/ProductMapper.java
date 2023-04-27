package com.yedam.prod.mapper;

import java.util.List;

import com.yedam.prod.domain.ProductVO;

public interface ProductMapper {
	// 전체 정보 조회
	public List<ProductVO> getProductAllInfo();
	// 상품별 조회
	public ProductVO getProductInfo(int prodCode);
}
