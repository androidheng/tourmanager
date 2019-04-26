package entity;

import java.io.Serializable;
import java.util.List;

/**
 * 用于向页面传递信息的类
 * @author jt
 *
 */
public class Result implements Serializable{
	
	private boolean success;
	private String message;
	private Object data;
	public Result(boolean success, String message) {
		super();
		this.success=success;
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Result(boolean success, Object data) {
		super();
		this.success = success;
		this.data = data;
	}
	
}
