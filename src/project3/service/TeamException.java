package project3.service;
/**
 * 自定义异常类
 * @author sky  Email:m15809282611@163.com
 * 
 * @date 2021年3月21日下午5:51:12
 */


public class TeamException extends Exception {
	
	static final long serialVersionUID = -338751429948L;
	
	public TeamException() {
		super();
	}
	public TeamException(String msg) {
		super(msg);
	}
	
}
