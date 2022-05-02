package com.callor.school.exec;

public class ExecV2 {
	public static void main(String[] args) {
		int[] intKor = new int[5];
		int[] intEng = new int[5];
		int[] intMath = new int[5];
		int[] intSum = new int[5];
		int temp = 0, temp_kor = 0, temp_eng = 0, temp_math = 0;

		for (int i = 0; i < intKor.length; i++) {
			int iKor = (int) (Math.random() * 100) + 1;
			int iEng = (int) (Math.random() * 100) + 1;
			int iMath = (int) (Math.random() * 100) + 1;
			int iSum = iKor + iEng + iMath;

			intKor[i] = iKor;
			intEng[i] = iEng;
			intMath[i] = iMath;
			intSum[i] = iSum;
		}

		System.out.println("국\t영\t수\t총합");

		printScore(intKor, intEng, intMath, intSum);

//		for (int i = 0; i < intKor.length; i++) {
//			System.out.println(intKor[i] + "\t" + intEng[i] + "\t" + intMath[i] + "\t" + intSum[i]);
//		}

		for (int i = 0; i < intKor.length; i++) {
			for (int j = i + 1; j < intKor.length; j++) {
				if (intSum[i] > intSum[j]) {
					temp = intSum[i];
					intSum[i] = intSum[j];
					intSum[j] = temp;

					temp_kor = intKor[i];
					intKor[i] = intKor[j];
					intKor[j] = temp_kor;

					temp_eng = intEng[i];
					intEng[i] = intEng[j];
					intEng[j] = temp_eng;

					temp_math = intMath[i];
					intMath[i] = intMath[j];
					intMath[j] = temp_math;
				}
			}
		}

		System.out.println("=".repeat(50));

//		for (int i = 0; i < intKor.length; i++) {
//			System.out.println(intKor[i] + "\t" + intEng[i] + "\t" + intMath[i] + "\t" + intSum[i]);
//		}
		
		System.out.println("국\t영\t수\t총합");

		printScore(intKor, intEng, intMath, intSum);

	} // end main

	private static void printScore(int[] intKor, int[] intEng, int[] intMath, int[] intSum) {
		for (int i = 0; i < intKor.length; i++) {
			System.out.printf("%3d\t", intKor[i]);
			System.out.printf("%3d\t", intEng[i]);
			System.out.printf("%3d\t", intMath[i]);
			System.out.printf("%3d\n", intSum[i]);
		}
	}
}
