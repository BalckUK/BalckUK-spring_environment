package kh.spring.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class testIntercepter extends HandlerInterceptorAdapter {

	protected Log log = LogFactory.getLog(testIntercepter.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		if (log.isDebugEnabled()) {
			
			System.out.println("인터셉트테스트입니다 preHandle");
//			log.debug("========================");
//			log.debug("Request URL \t: " + request.getRequestURI());
//		}
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if (log.isDebugEnabled()) {
			
			System.out.println("인터셉트테스트입니다 postHandle");
			log.debug("===================        END        ===================\n");
		}
	}

}
