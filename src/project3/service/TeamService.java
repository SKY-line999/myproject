package project3.service;

/**
 * 关于开发团队成员的管理：添加、删除等
 * @author sky  Email:m15809282611@163.com
 * 
 * @date 2021年3月21日下午7:38:34
 */

import project3.domain.Architect;
import project3.domain.Designer;
import project3.domain.Employee;
import project3.domain.Programmer;

public class TeamService {
	private static int counter = 1;// 团队中成员的id
	private final int MAX_MEMBER = 5;// 开发团队中最大成员数
	private Programmer[] team = new Programmer[MAX_MEMBER];// 各对象成员
	private int total = 0;// 记录实际人数

	/**
	 * 获取开发团队中的成员
	 * 
	 * @author sky Email:m15809282611@163.com
	 * 
	 * @date 2021年3月21日下午7:45:36
	 * @return
	 */
	public Programmer[] getTeam() {
		Programmer[] team = new Programmer[total];
		for (int i = 0; i < team.length; i++) {
			team[i] = this.team[i];
		}
		return team;
	}

	/**
	 * 添加成员信息
	 * 
	 * @author sky Email:m15809282611@163.com
	 * 
	 * @date 2021年3月21日下午7:51:13
	 * @param e
	 * @throws TeamException
	 */
	public void addMember(Employee e) throws TeamException {
		// 失败信息包含以下几种：
		// 成员已满，无法添加
		if (total >= MAX_MEMBER) {
			throw new TeamException("成员已满，无法添加");
		}
		// 该成员不是开发人员，无法添加
		if (!(e instanceof Programmer)) {
			throw new TeamException("该成员不是开发成员，无法添加");
		}
		// 该员工已在本开发团队中
		if (isExist(e)) {
			throw new TeamException("该员工已在本开发团队中");
		}
		// 该员工已是某团队成员
		// 该员正在休假，无法添加
		Programmer p = (Programmer) e;
		if ("BUSY".equals(p.getStatus().getNAME())) {
			throw new TeamException("该员工已是某团队成员");
		} else if ("VOCATION".equals(p.getStatus().getNAME())) {
			throw new TeamException("成员正在休假");
		}
		// 团队中至多只能有一名架构师
		// 团队中至多只能有两名设计师
		// 团队中至多只能有三名程序员
		int numOfArch = 0, numOfDes = 0, numOfPro = 0;
		for (int i = 0; i < total; i++) {
			if (team[i] instanceof Architect) {
				numOfArch++;
			} else if (team[i] instanceof Designer) {
				numOfDes++;
			} else if (team[i] instanceof Programmer) {
				numOfPro++;
			}
		}
		if (p instanceof Architect) {
			if (numOfArch >= 1) {
				throw new TeamException("团队中至多只能有一名架构师");
			}
		} else if (p instanceof Designer) {
			if (numOfDes >= 2) {
				throw new TeamException("团队中至多只能有二名设计师");
			}
		} else if (p instanceof Programmer) {
			if (numOfPro >= 3) {
				throw new TeamException("团队中至多只能有三名程序员");
			}
		}

		p.setStatus(Status.BUZY);
		p.setMemberld(counter++);
		team[total++] = p;

	}

	/**
	 * 删除团队中的成员
	 * 
	 * @author sky Email:m15809282611@163.com
	 * 
	 * @date 2021年3月21日下午8:17:59
	 * @param memberId
	 * @throws TeamException
	 */
	public void removeMember(int memberId) throws TeamException {
		int i = 0;
		for (i = 0; i < total; i++) {
			if (team[i].getMemberld() == memberId) {
				team[i].setStatus(Status.FREE);
				break;
			}
		}
		
		if (i == total) {
			throw new TeamException("未找到此员工、删除失败");
		}
		
		for (int j = i + 1; j < total; j++) {
			team[j - 1] = team[j];
		}
		team[--total] = null;

	}

	public boolean isExist(Employee e) {
		for (int i = 0; i < total; i++) {
			if (team[i].getId() == e.getId()) {
				return true;
			}
		}

		return false;
	}

}
