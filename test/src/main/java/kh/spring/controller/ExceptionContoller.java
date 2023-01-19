package kh.spring.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionContoller {

	//오류처리 일괄
	public String exceptionHandler(Exception e) {
		e.printStackTrace();
		System.out.println("에러테스트입니다");
		return "error";
	}
	
}
