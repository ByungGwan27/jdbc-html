package com.yedam.member.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@AllArgsConstructor
public class EventVO {
	private String title;
	private String startDate;
	private String endDate;
}
