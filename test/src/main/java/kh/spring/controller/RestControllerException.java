package kh.spring.controller;

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
		System.out.println("�엯�젰�맂媛� : "+ sJson);
		System.out.println("get�뀒�뒪�듃api�엯�땲�떎");
		testDTO dto = obj.readValue(sJson, testDTO.class);
		System.out.println("�씫湲� : "+dto);
		return sJson;
	}
	
	@GetMapping(value="/testgetapi2", produces="application/text; charset=utf8")
	public String testgetapi2() {
		return "테스트";
	}
	
	@GetMapping("/testgetapi3")
	public String testgetapi3(String test) {
		System.out.println("test : "+ test);
		return test;
	}
	
	@PostMapping("/testpostapi")
	public String testpostapi(String cat, String test) {
		System.out.println("媛믪� : "+ cat);
		System.out.println("�뀒�뒪�듃�뒗 : "+ test);
		System.out.println("post�뀒�뒪�듃api�엯�땲�떎");
		return "postapi";
	}
	
	@ExceptionHandler(NullPointerException.class)
	public Object notfound(Exception e) {
		System.err.print(e.getClass());
		System.out.println("null�엯�땲�떎");
		return "/error/error";
	}
}
