package com.hgx.common.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hgx.common.exception.ResultCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * @Title: HttpJsonEsult.java
 * @Package
 * @Description: 自定义响应数据结构
 * 				本类可提供给 H5/ios/安卓/公众号/小程序 使用
 * 				前端接受此类数据（json object)后，可自行根据业务去实现相关功能
 * 
 * 				200：表示成功
 * 				500：表示错误，错误信息在msg字段中
 * 				501：bean验证错误，不管多少个错误都以map形式返回
 * 				502：拦截器拦截到用户token出错
 * 			Pa	555：异常抛出信息
 * 				556: 用户qq校验异常
 * @Copyright: Copyright (c) 2020
 * @version V1.0
 */

@ApiModel(value = "统一数据返回格式", description = "所有数据经此包装")
public class HttpJsonResult<T> {

    /**
     * 状态码
     */
    @ApiModelProperty(required = true, value = "返回状态码", dataType = "int", example = "200", position = 0)
    private Integer status;

    /**
     * msg信息
     */
    @ApiModelProperty(required = true, value = "返回msg信息", dataType = "string", example = "success", position = 3)
    private String msg;

    /**
     * 返回数据
     */
    @ApiModelProperty(required = true, value = "返回数据")
    private T data;

    @JsonIgnore
    private String ok;	// 不使用

    public static HttpJsonResult build(Integer status, String msg, Object data) {
        return new HttpJsonResult(status, msg, data);
    }

    public static HttpJsonResult build(Integer status, String msg, Object data, String ok) {
        return new HttpJsonResult(status, msg, data, ok);
    }


    public static HttpJsonResult okRedis(Object data, String redisKey) {
        return new HttpJsonResult(data,redisKey);
    }

    public static HttpJsonResult okRedis(Object data, String redisKey, Integer count) {
        return new HttpJsonResult(data,count,redisKey);
    }
    
    public static HttpJsonResult ok(Object data) {
        return new HttpJsonResult(data);
    }


    public static HttpJsonResult ok(Object data , Integer count) {
        return new HttpJsonResult(data,count);
    }

    public static HttpJsonResult ok() {
        return new HttpJsonResult(null);
    }
    
    public static HttpJsonResult errorMsg(String msg) {
        return new HttpJsonResult(ResultCode.BUSINESS_EXECUTION_FAILED.getCode(), msg, null);
    }
    
    public static HttpJsonResult errorMap(Object data) {
        return new HttpJsonResult(ResultCode.BUSINESS_EXECUTION_FAILED.getCode(), "error", data);
    }
    
    public static HttpJsonResult errorTokenMsg(String msg) {
        return new HttpJsonResult(ResultCode.BUSINESS_IDAAS_LOGIN_ERROR.getCode(), msg, null);
    }
    
    public static HttpJsonResult errorException(String msg) {
        return new HttpJsonResult(ResultCode.SYS_ERROR.getCode(), msg, null);
    }
    
    public static HttpJsonResult errorUserQQ(String msg) {
        return new HttpJsonResult(ResultCode.BUSINESS_EXECUTION_FAILED.getCode(), msg, null);
    }

    public HttpJsonResult() {

    }

    public HttpJsonResult(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
    
    public HttpJsonResult(Integer status, String msg, T data, String ok) {
        this.status = status;
        this.msg = msg;
        this.data = data;
        this.ok = ok;
    }

    public HttpJsonResult(T data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public HttpJsonResult(T data, String redisKey) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public HttpJsonResult(T data, Integer count , String redisKey ) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public HttpJsonResult(T data, Integer count) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public Boolean isOK() {
        return this.status == 200;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

	public String getOk() {
		return ok;
	}

	public void setOk(String ok) {
		this.ok = ok;
	}

}
