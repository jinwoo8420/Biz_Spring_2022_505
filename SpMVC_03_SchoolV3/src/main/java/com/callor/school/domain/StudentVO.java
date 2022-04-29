package com.callor.school.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class StudentVO {
	private String stNum;
	private String stName;
	private int intGrade;
	private String stTel;
	private String stAddr;
	private String stDept;

}
