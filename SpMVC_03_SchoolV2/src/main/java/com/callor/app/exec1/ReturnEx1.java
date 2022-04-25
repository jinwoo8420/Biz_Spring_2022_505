package com.callor.app.exec1;

public class ReturnEx1 {
	public static void main(String[] args) {
		Integer result = add("30", "40");

		System.out.println(result);
		
		if (result==null) {
			System.out.println("연산 오류");
		} else {
			System.out.println(result);
		}

		result = add("30 ", "40 ");
		System.out.println(result);
	}

	private static Integer add(String num1, String num2) { // 두개의 문자열형 정수를 매개변수로 받아 숫자 연산을 수행한 후 결과 return
		int intNum1 = 0, intNum2 = 0;

		try {
			intNum1 = Integer.valueOf(num1);
			intNum2 = Integer.valueOf(num2);
		} catch (Exception e) {
			return null;
		}

		int intSum = intNum1 + intNum2;

		return intSum;
	}
}
