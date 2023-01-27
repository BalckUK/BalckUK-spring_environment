package kh.spring.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TestException {

	@ExceptionHandler(Exception.class)
	public void testex() {
//		ErrorResponseEntity response = new ErrorResponseEntity(ErrorCode.INTERNAL_SERVER_ERROR);
//		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		
		System.out.println("오류컨트롤러입니다");
		
	}

}
