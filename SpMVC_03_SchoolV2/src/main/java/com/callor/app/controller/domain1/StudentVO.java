package com.callor.app.controller.domain1;

/*
 * spring project에서 VO(DTO) 클래스를 선언 할 때는 필드 변수를 private으로 선언하고
 * getter() & setter() method를 선언하고
 * toString() method를 재정의하고
 * 기본 생성자와 필드 생성자를 정의해둔다
 */

public class StudentVO {
	private String stNum;
	private String stName;
	private int intGrade;
	private String stTel;
	private String stAddr;
	private String stDept;

	public StudentVO() {

	}

	public StudentVO(String stNum, String stName, int intGrade, String stTel, String stAddr, String stDept) {
		this.stNum = stNum;
		this.stName = stName;
		this.intGrade = intGrade;
		this.stTel = stTel;
		this.stAddr = stAddr;
		this.stDept = stDept;
	}

	public String getStNum() {
		return stNum;
	}

	public void setStNum(String stNum) {
		this.stNum = stNum;
	}

	public String getStName() {
		return stName;
	}

	public void setStName(String stName) {
		this.stName = stName;
	}

	public int getIntGrade() {
		return intGrade;
	}

	public void setIntGrade(int intGrade) {
		this.intGrade = intGrade;
	}

	public String getStTel() {
		return stTel;
	}

	public void setStTel(String stTel) {
		this.stTel = stTel;
	}

	public String getStAddr() {
		return stAddr;
	}

	public void setStAddr(String stAddr) {
		this.stAddr = stAddr;
	}

	public String getStDept() {
		return stDept;
	}

	public void setStDept(String stDept) {
		this.stDept = stDept;
	}

	@Override
	public String toString() {
		return "StudentVO [stNum=" + stNum + ", stName=" + stName + ", intGrade=" + intGrade + ", stTel=" + stTel
				+ ", stAddr=" + stAddr + ", stDept=" + stDept + "]";
	}

}
