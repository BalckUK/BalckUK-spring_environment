package kh.spring.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

public class CustomExceptionResolver extends AbstractHandlerExceptionResolver {

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ModelAndView modeAndView = new ModelAndView();
		
		modeAndView.setViewName("/error/error1");
		
		
		if(handler != null) {
			HandlerMethod handlerMetho = (HandlerMethod)handler;
			modeAndView.addObject("errorMethod", handlerMetho.getMethod().getName());
		}
		modeAndView.addObject("errorCause", ex.getCause());
		modeAndView.addObject("errorClass", ex.getClass().getSimpleName());
		modeAndView.addObject("errorMessage", ex.getMessage());
		
		return modeAndView;
	}

}
