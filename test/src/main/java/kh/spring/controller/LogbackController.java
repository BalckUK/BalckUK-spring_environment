package kh.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class LogbackController {

	private static final Logger logger = LoggerFactory.getLogger(LogbackController.class);

	@GetMapping("/basic")
	public void root() {
		logger.trace("/testApi");
		logger.debug("/testApi");
		logger.info("/testApi");
		logger.warn("/testApi");
		logger.error("/testApi");
	}

}
