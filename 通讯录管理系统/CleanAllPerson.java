package 通讯录管理系统;
import java.util.*;
import java.io.*;
// 一键删除所有联系人 同时将txt文件中储存的信息全部清空
class CleanAllPerson {
	Scanner reader = new Scanner(System.in);
	int tag;
	void cleanAllPerson() {
		while(true) {
			System.out.println("确定清空当前通讯录中所有联系人？ 1——确定 / 2——取消");
			try {
				tag = reader.nextInt();
				if(tag==1) {
					Addressbooks.m_Size=0;
					File file =new File("information.txt");
					try {
						if(!file.exists()) {
							file.createNewFile();
						}
						FileWriter fileWriter =new FileWriter(file);
						fileWriter.write("");
						fileWriter.flush();
						fileWriter.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					System.out.println("清空成功！");
					break;
				}
				else if(tag==2) {
					break;
				}
				else {
					System.out.println("请输入正确的数字");
				}
			}
			catch(InputMismatchException e){
				System.out.println("输入有误，请输入正确的数字！");
				reader.next();
			}
		}
	}

}
