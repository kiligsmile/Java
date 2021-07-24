package 通讯录管理系统;
import java.util.Scanner;

// 删除指定联系人
class DeletePerson {
	Scanner reader = new Scanner(System.in);
	String name;
	void deletePerson() {
		System.out.println("请输入要删除的联系人姓名：");
		name = reader.next();
		if(IsExist.isExist(name)==-1) {
			System.out.println("查无此人！");
		}
		else {
			for(int i=IsExist.isExist(name);i<Addressbooks.m_Size-1;i++) {
				Addressbooks.persons[i]=Addressbooks.persons[i+1];
			}
			Addressbooks.m_Size = Addressbooks.m_Size-1;
			System.out.println("删除成功！");
		}
	}
}
