package project3.service;

import org.junit.Test;

import project3.domain.Employee;

/**
 * 对造好的类的测试
 * @author sky  Email:m15809282611@163.com
 * 
 * @date 2021年3月21日下午5:56:43
 */
public class NamListServiceTest {
	@Test
	public void testGetAllEmployees() {
		NameListService service = new NameListService();
		Employee[] employees = service.getAllEmployees();
		for(int i =0;i<employees.length;i++) {
			System.out.println(employees[i]);
		}
		
	}
	
	@Test
	public void testGetEmployee() {
		NameListService service = new NameListService();

		try {
			Employee employee = service.getEmployee(100);
			System.out.println(employee);
		} catch (TeamException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
