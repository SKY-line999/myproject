package project3.service;

import project3.domain.*;
import static project3.service.Data.*;

/**
 * 负责将Data中的数据封装到Employee[]数组中， 同时提供相关操作Employee[]的方法。
 * 
 * @author sky Email:m15809282611@163.com
 * 
 * @date 2021年3月21日下午5:03:42
 */

public class NameListService {

	private Employee[] employees;// 保存公司所有员工对象

	// 給employees以及數組元素初始化
	public NameListService() {
		/*
		 * 1、根据项目提供的Data类构建相应大小的employees数组 
		 * 2、再根据Data类中的数据构建不同的对象，
		 * 包括Employee、Programmer、Designer和Architect对象， 
		 * 以及相关联的Equipment子类的对象 
		 * 3、将对象存于数组中
		 * Data类位于com.atguigu.team.service包中
		 */

		employees = new Employee[EMPLOYEES.length];
		for (int i = 0; i < employees.length; i++) {
			int type = Integer.parseInt(EMPLOYEES[i][0]);

			int id = Integer.parseInt(EMPLOYEES[i][1]);
			String name = EMPLOYEES[i][2];
			int age = Integer.parseInt(EMPLOYEES[i][3]);
			double salary = Double.parseDouble(EMPLOYEES[i][4]);

			Equipment equipment;

			switch (type) {
			case EMPLOYEE:
				employees[i] = new Employee(id, name, age, salary);
				break;
			case PROGRAMMER:
				equipment = creatEquipment(i);
				employees[i] = new Programmer(id, name, age, salary, equipment);
				break;
			case DESIGNER:
				equipment = creatEquipment(i);
				employees[i] = new Designer(id, name, age, salary, equipment, Double.parseDouble(EMPLOYEES[i][5]));
				break;
			case ARCHITECT:
				equipment = creatEquipment(i);
				employees[i] = new Architect(id, name, age, salary, equipment, Double.parseDouble(EMPLOYEES[i][5]),
						Integer.parseInt(EMPLOYEES[i][6]));
				break;

			}

		}

	}

	/**
	 * 获取指定index位置上的数据
	 * 
	 * @author sky Email:m15809282611@163.com
	 * 
	 * @date 2021年3月21日下午5:27:28
	 * @param i
	 * @return
	 */
	private Equipment creatEquipment(int index) {
		int type = Integer.parseInt(EQUIPMENTS[index][0]);

		switch (type) {
		case PC:
			return new Pc(EQUIPMENTS[index][1], EQUIPMENTS[index][2]);
		case NOTEBOOK:
			return new NoteBook(EQUIPMENTS[index][1], Double.parseDouble(EQUIPMENTS[index][2]));
		case PRINTER:
			return new Printer(EQUIPMENTS[index][1], EQUIPMENTS[index][2]);
		}
		return null;
	}

	
	/**
	 * 获取当前的所有员工   指定id的员工
	 * @author sky  Email:m15809282611@163.com
	 * 
	 * @date 2021年3月21日下午5:46:17
	 * @return
	 */
	public Employee[] getAllEmployees() {

		return employees;
	}

	public Employee getEmployee(int id) throws TeamException {
		for(int i = 0 ;i<employees.length;i++) {
			if(employees[i].getId() == id) {
				return employees[i];
			}
		}
		
		throw new TeamException("找不到指定的员工");
	}

}
