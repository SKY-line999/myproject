package project3.service;

/**
 * 
 * @author sky Email:m15809282611@163.com 枚举类 自定义类，表示员工的状态 FREE BUZY VOCATION
 * @date 2021年3月21日下午4:41:51
 */
public class Status {
	private final String NAME;

	private Status(String name) {
		this.NAME = name;
	}

	public static final Status FREE = new Status("FREE");
	public static final Status BUZY = new Status("BUZY");
	public static final Status VOCATION = new Status("VOCATION");

	public String getNAME() {
		return NAME;
	}

	@Override
	public String toString() {
		return NAME;
	}

}
