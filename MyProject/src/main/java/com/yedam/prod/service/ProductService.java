package com.yedam.prod.service;

import java.util.List;

import com.yedam.prod.domain.ProductVO;

public interface ProductService {
	// 전체 상품 조회
	public List<ProductVO> getProductAllInfo();
	// 상품별 조회
	public ProductVO ProductInfo(int prodCode);
	
}
