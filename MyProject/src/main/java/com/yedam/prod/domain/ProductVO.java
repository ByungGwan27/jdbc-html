package com.yedam.prod.domain;

import lombok.Data;

@Data
public class ProductVO {
	private int prodCode;
	private String prodName;
	private String prodContent;
	private int prodPrice;
	private int discount;
	private String starMark;
	
}
