package kh.spring.controller;

import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kh.spring.dto.testDTO;

@RestController
public class RestControllerException {
	
	@GetMapping(value="/testgetapi")
	public String testgetapi(testDTO tdto) throws JsonProcessingException {
		ObjectMapper obj = new ObjectMapper();
		String sJson = obj.writeValueAsString(tdto);		
		System.out.println("입력된값 : "+ sJson);
		System.out.println("get테스트api입니다");
		testDTO dto = obj.readValue(sJson, testDTO.class);
		System.out.println("읽기 : "+dto);
		return sJson;
	}
	
	@GetMapping(value="/testgetapi2", produces="application/text; charset=utf8")
	public String testgetapi2() {
		return "오웬";
	}
	
	@GetMapping("/testgetapi3")
	public String testgetapi3(String test) {
		System.out.println("test : "+ test);
		return test;
	}
	
	@PostMapping("/testpostapi")
	public String testpostapi(String cat, String test) {
		System.out.println("값은 : "+ cat);
		System.out.println("테스트는 : "+ test);
		System.out.println("post테스트api입니다");
		return "postapi";
	}
	
	@ExceptionHandler(NullPointerException.class)
	public Object notfound(Exception e) {
		System.err.print(e.getClass());
		System.out.println("null입니다");
		return "/error/error";
	}
}
