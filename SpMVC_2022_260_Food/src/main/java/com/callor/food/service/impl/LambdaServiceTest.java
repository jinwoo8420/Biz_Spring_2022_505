package com.callor.food.service.impl;

import com.callor.food.service.LambdaService;

public class LambdaServiceTest {

	public void home() {

		/* 
		 * Java 8에서 사용하는 functional interface라는 개념
		 * 
		 * LambdaService interface에 한개의 method만 존재 할 경우
		 * 별도의 클래스를 선언하지 않고 직접 Lambda 코드를 사용하여
		 * 객체를 생성하고 생성된 객체의 method를 사용 할 수 있다
		 */
		LambdaService lService = (nation, name, num) -> {
			return nation + name + num;
		};

		String result = lService.getObject("대한민국", "김철수", 100);
		System.out.println(result);
	}

}
