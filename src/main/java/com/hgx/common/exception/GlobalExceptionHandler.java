package com.hgx.common.exception;

import com.hgx.common.utils.CommonEnum;
import com.hgx.common.utils.ResultBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.security.authentication.ProviderNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>全局异常处理</p>
 *
 * @author 何冠勋
 * @since 2020/7/14
 **/
@ControllerAdvice
public class GlobalExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	/**
	 * 处理自定义的业务异常
	 * @param req
	 * @param e
	 * @return
	 */
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
	public ResultBody bizExceptionHandler(HttpServletRequest req, BizException e){
    	logger.error("发生业务异常！原因是：{}",e.getErrorMsg());
    	return ResultBody.error("500",e.getErrorMsg());
    }

	/**
	 * 处理空指针的异常
	 * @param req
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value =NullPointerException.class)
	@ResponseBody
	public ResultBody exceptionHandler(HttpServletRequest req, NullPointerException e){
		logger.error("发生空指针异常！原因是:",e);
		return ResultBody.error(CommonEnum.INTERNAL_SERVER_ERROR);
	}

	/**
	 * 权限异常处理
	 * @param req
	 * @param e
	 * @return
	 */
//	@ExceptionHandler(value = ProviderNotFoundException.class)
//	@ResponseBody
//	public ResultBody exceptionAuthenticationHandler(HttpServletRequest req, Exception e){
//		logger.error("未登录！");
//		System.out.println(e);
//		return ResultBody.error(CommonEnum.AUTH_NO);
//	}
    /**
        * 处理其他异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =Exception.class)
	@ResponseBody
	public ResultBody exceptionHandler(HttpServletRequest req, Exception e){
    	logger.error("未知异常！原因是:",e);
       	return ResultBody.error(CommonEnum.INTERNAL_SERVER_ERROR);
    }
}