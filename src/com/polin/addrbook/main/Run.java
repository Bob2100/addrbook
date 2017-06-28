package com.polin.addrbook.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import com.polin.addrbook.management.ManaFunction;


public class Run {
	public static void main(String[] args) {
		ManaFunction mf = null;
		ObjectInputStream in = null;
		// 反序列化对象
		try {
			in = new ObjectInputStream(new FileInputStream(
					"g:\\develop_luna\\stu"));
			mf = (ManaFunction) in.readObject(); // 读取ManaFunction对象
		} catch (Exception e) {
			if (mf == null) {
				mf = new ManaFunction();
			}
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		// 系统主页
		System.out.println("------欢迎使用坡林通讯录------");
		System.out.println("1 添加联系人");
		System.out.println("2 查看联系人");
		System.out.println("3 修改联系人");
		System.out.println("4 删除联系人");
		System.out.println("5 退出");
		mf.printSymbolLine();
		System.out.println("请输入对应的数字：");
		mf.printSymbolLine();


		// 创建键盘录入对象
		Scanner scanner = new Scanner(System.in);

		while (true) {
			String num = scanner.nextLine();
			if ("1".equals(num)) {
				mf.addStudent(scanner);
			} else if ("2".equals(num)) {
				mf.queryStudent();
			} else if ("3".equals(num)) {
				mf.editStudent();
			} else if ("4".equals(num)) {
				mf.deleteStudent();
			} else {
				// 序列化到本地，数据不会丢失
				// 创建序列化对象
				try {
					ObjectOutputStream out = new ObjectOutputStream(
							new FileOutputStream("g:\\develop_luna\\stu"));
					out.writeObject(mf);
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				mf.exit();
				break;
			}
		}
		scanner.close();
	}
}
