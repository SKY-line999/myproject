package project3.domain;

import project3.service.Status;

public class Programmer extends Employee {

	private int memberld;//开发团队的id
	private Status status = Status.FREE;//成员状态
	private Equipment equipment;//设备

	public Programmer() {
		super();
	}

	public Programmer(int id, String name, int age, double salary, Equipment equipment) {
		super(id, name, age, salary);
		this.equipment = equipment;
	}

	public int getMemberld() {
		return memberld;
	}

	public void setMemberld(int memberld) {
		this.memberld = memberld;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	@Override
	public String toString() {
		return super.toString() + "\t" + "程序员" + "\t" + status + "\t\t\t" + equipment.getDescription();
		
	}
	
	public String getDetailsForTeam() {
		return memberld + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t" + getSalary() + "\t程序员";
	}

}
