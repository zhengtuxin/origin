package com.winxuan.console.util;

/**
 * 返回消息
 * 
 * @author ztx
 */
public class Message {

	private String msg = "success";
	private Boolean status = true;
	private Object data;

	public Message() {
	}

	public Message(Object data) {
		super();
		this.data = data;
	}

	public Message(String msg, Boolean status) {
		super();
		this.msg = msg;
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
