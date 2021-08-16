package 通讯录管理系统;
import java.util.Scanner;

// 查找指定联系人
class FindPerson {
	Scanner reader = new Scanner(System.in);
	String name;
	void findPerson() {
		int i;
		System.out.println("请输入你要查找的联系人姓名：");
		name = reader.next();
		for(i=0;i<Addressbooks.m_Size;i++) {
			if(name.equals(Addressbooks.persons[i].m_name)) {
				ShowInformation showInformation = new ShowInformation();
				showInformation.showinformation(i);
				break;
			}
		}
		if(i>=Addressbooks.m_Size) {
			System.out.println("不存在该联系人！");
		}
	}
	
}
