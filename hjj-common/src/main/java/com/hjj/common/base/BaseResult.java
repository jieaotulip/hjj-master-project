package com.hjj.common.base;
/**
 * 统一返回结果类 
 * @author hujunjie
 * @time 2018年11月27日
 */
public class BaseResult {
	private int code;
	private String message;
	private Object obj;
	public BaseResult(int code, String message, Object obj) {
		super();
		this.code = code;
		this.message = message;
		this.obj = obj;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
}
