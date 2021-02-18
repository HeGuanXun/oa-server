package com.hgx.common.utils;

import com.hgx.common.exception.BaseErrorInfoInterface;
import io.swagger.annotations.ApiModelProperty;
public class ResultBody<T> {
	/**
	 * 响应代码
	 */
	@ApiModelProperty(value = "响应代码")
	private String code;

	/**
	 * 响应结果
	 */
	@ApiModelProperty(value = "响应结果")
	private T data;

	public ResultBody() {
	}

	public ResultBody(BaseErrorInfoInterface errorInfo) {
		this.code = errorInfo.getResultCode();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	/**
	 * 成功
	 *
	 * @return
	 */
	public static ResultBody success() {
		return success(null);
	}

	/**
	 * 成功
	 * @param data
	 * @return
	 */
	public static ResultBody success(Object data) {
		ResultBody rb = new ResultBody();
		rb.setCode(CommonEnum.SUCCESS.getResultCode());
		rb.setData(data);
		return rb;
	}

	/**
	 * 失败
	 */
	public static ResultBody error(BaseErrorInfoInterface errorInfo) {
		ResultBody rb = new ResultBody();
		rb.setCode(errorInfo.getResultCode());
		rb.setData(errorInfo.getResultMsg());
		return rb;
	}

	/**
	 * 失败
	 */
	public static ResultBody error(String code, String message) {
		ResultBody rb = new ResultBody();
		rb.setCode(code);
		rb.setData(message);
		return rb;
	}

	/**
	 * 失败
	 */
	public static ResultBody error( String message) {
		ResultBody rb = new ResultBody();
		rb.setCode("500");
		rb.setData(message);
		return rb;
	}
}