package com.callor.ems.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
public class UserVO {
	@Size(min = 5, max = 12, message = "USER NAME은 5 ~ 12자")
	private String username;
//	@Pattern(regexp = "/^.*(?=^.{8,15}$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/", message = "비밀번호는 영문 숫자 특수문자 포함 8 ~ 15자")
	private String password;

	@Email(message = "email 정확히 입력")
	private String email;
	private String name;
	private String role;

	private String key;
	private String key_ok;
}
