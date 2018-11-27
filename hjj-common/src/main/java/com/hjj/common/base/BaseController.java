package com.hjj.common.base;
/**
 * Base Controller
 * @author hujunjie
 * @time 2018年11月27日
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.session.InvalidSessionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hjj.common.util.PropertiesFileUtil;

public class BaseController {
	private final static Logger logger = LoggerFactory.getLogger(BaseController.class);

	/**
	 * 统一处理异常
	 * @param request
	 * @param response
	 * @param exception
	 * @return
	 */
	@ExceptionHandler
	public String exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception exception) {
		logger.error("统一处理异常：", exception);
		request.setAttribute("ex", exception);
		if (null != request.getHeader("X-Requested-With")
				&& "XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"))) {
			request.setAttribute("requestHeader", "ajax");
		}
		// shiro没有权限异常
		if (exception instanceof UnauthorizedException) {
			return "/403.jsp";
		}
		// shiro会话已过期异常
		if (exception instanceof InvalidSessionException) {
			return "/error.jsp";
		}
		return "/error.jsp";
	}
	
	/**
	 * 返回jsp视图
	 * @param path
	 * @return
	 */
	public static String jsp(String path) {
		return path.concat(".jsp");
	}
	
	public static String thymeleaf(String path) {
		String folder = PropertiesFileUtil.getInstance().get("app.name");
		return "/".concat(folder).concat(path).concat(".html");
	}
}
