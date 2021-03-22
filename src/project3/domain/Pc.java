package project3.domain;

public class Pc implements Equipment {
	private String model;
	private String display;

	public Pc() {
		super();
	}

	public Pc(String model, String display) {
		super();
		this.display = display;//显示器名称
		this.model = model;//机器型号
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	@Override
	public String getDescription() {
		return model + "(" + display + ")";
	}
}
