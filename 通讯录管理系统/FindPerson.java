package 通讯录管理系统;
import java.util.Scanner;

// 查找指定联系人
class FindPerson {
	Scanner reader = new Scanner(System.in);
	String name;
	void findPerson() {
		int i;
		System.out.println("请输入你要查找的联系人：");
		name = reader.next();
		for(i=0;i<Addressbooks.m_Size;i++) {
			if(name.equals(Addressbooks.persons[i].m_name)) {
				System.out.print("姓名："+Addressbooks.persons[i].m_name+'\t');
				System.out.print("性别："+Addressbooks.persons[i].m_Sex+'\t');
				if(Addressbooks.persons[i].num==2) {
					System.out.print("电话1："+Addressbooks.persons[i].com1+'-'+Addressbooks.persons[i].m_phone+'\t');
					System.out.print("电话2："+Addressbooks.persons[i].com2+'-'+Addressbooks.persons[i].m_phone2+'\t');
				}
				else {                                                                                            		
					System.out.print("电话： "+Addressbooks.persons[i].com1+'-'+Addressbooks.persons[i].m_phone+'\t'+"	           	          ");
				}
				System.out.println("住址："+Addressbooks.persons[i].m_Addr);
				break;
			}
		}
		if(i>=Addressbooks.m_Size) {
			System.out.println("不存在该联系人！");
		}
	}
	
}
