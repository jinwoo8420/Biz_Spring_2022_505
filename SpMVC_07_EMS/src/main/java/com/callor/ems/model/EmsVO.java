package com.callor.ems.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

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
@Builder
@ToString
public class EmsVO {
	private String e_seq;
	private String e_from_email;

	@Email(message = "Email 형식이 아님")
	@NotEmpty(message = "받는 사람 Email 필수 입력")
	private String e_to_email;

	@NotNull(message = "보내는 사람 이름 null 일 수 없음")
	private String e_from_name;

	@Length(min = 1, max = 100, message = "받는 사람 이름은 1 ~ 100 글자까지 가능")
	@NotEmpty(message = "받는 사람 이름 필수 입력")
	private String e_to_name;

	@NotEmpty(message = "제목 필수 입력")
	private String e_subject;
	private String e_content;

//	@Size(min = 1, max = 10, message = "num은 1 ~ 10 사이 값")
	private String e_send_date;
	private String e_send_time;

//	@Min(value = 1, message = "num은 1 보다 커야 함")
//	@Max(value = 10, message = "num은 10 보다 작아야 함")
	private int num;

//	@DecimalMin(value = "1", message = "decimal은 십진수 1 보다 커야 함")
//	@DecimalMax(value = "10", message = "decimal은 십진수 10 보다 작아야 함")
	private int decimal;

//	@Pattern(regexp = "/^.*(?=^.{8,15}$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/")
	private String password;
}
