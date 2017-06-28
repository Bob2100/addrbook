package com.polin.addrbook.management;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import com.polin.addrbook.domain.Person;


public class ManaFunction implements Serializable {

	private static final long serialVersionUID = 1L;

	// 用于存放学生信息
	ArrayList<Person> stus = new ArrayList<Person>();

	// 添加学生
	public void addStudent(Scanner scanner) {


		while (true) {// 学号重复可以重复输入
			boolean flag = false;
			System.out.println("请输入电话：");
			printSymbolLine();

			String id = scanner.nextLine();

			// 查询id是否已经存在
			if (stus != null && stus.size() != 0) {
				// 遍历
				for (Person student : stus) {
					if (id.equals(student.getId())) {
						System.out.println("电话已存在，请重新输入！");
						printSymbolLine();
						flag = true;
						break;
					}
				}

				if (!flag) {// 电话存在flag为true，不存在才能添加
					// 添加联系人
					addStu(scanner, id);
					flag = true;
					break;
				}

			} else {
				// 第一次添加
				addStu(scanner, id);
				break;
			}
		}

	}

	private void addStu(Scanner scanner, String id) {
		System.out.println("请输入联系人姓名，性别，年龄，住址，以空格分隔：");
		printSymbolLine();
		String line = scanner.nextLine();
		String[] msg = line.split(" ");
		Person stu = new Person();
		stu.setId(id);
		stu.setName(msg[0]);
		stu.setSex(msg[1]);
		stu.setAge(msg[2]);
		stu.setAddr(msg[3]);
		stus.add(stu);
		System.out.println("添加联系人成功！");
		printSymbolLine();
	}

	// 查看学生
	public void queryStudent() {
		System.out.println("电话\t\t姓名\t\t性别\t\t年龄\t\t住址");
		printSymbolLine();
		if (stus != null && stus.size() != 0) {
			for (Person s : stus) {
				System.out.println(s.getId() + "\t\t" + s.getName() + "\t\t"
						+ s.getSex() + "\t\t" + s.getAge() + "\t\t"
						+ s.getAddr());
				printSymbolLine();
			}
		} else {
			System.out.println("没有联系人，请添加！");
			printSymbolLine();
		}

	}

	public void printSymbolLine() {
		System.out.println("----------------------------");
	}

	// 修改学生
	public void editStudent() {
		System.out.println("修改学生----");

	}

	// 删除学生
	public void deleteStudent() {
		System.out.println("删除学生----");

	}

	public void exit() {
		System.out.println("退出系统----");
		System.exit(0);// 关闭虚拟机

	}

}
