package 通讯录管理系统;
import java.util.*;

// 修改联系人信息
class ModifyPerson {
	Scanner reader = new Scanner(System.in);
	String name;
	int site;
	void modifyPerson() {
		Phonenumber phonenumber = new Phonenumber();
		System.out.println("请输入需要修改的联系人姓名：");
		name = reader.next();
		site = IsExist.isExist(name);
		if(site == -1) {
			System.out.println("该联系人不存在");
		}
		else {
			System.out.println("请输入姓名：");
			Addressbooks.persons[site].m_name = reader.next();
			System.out.println("请选择性别：");
			System.out.println("1————男  2————女");
			while(true) {
				try {
					int sex = reader.nextInt(); 
					if(sex==1) {
						Addressbooks.persons[site].m_Sex="男";
						break;
					}
					else if(sex==2) {
						Addressbooks.persons[site].m_Sex="女";
						break;
					}
					else {
						System.out.println("请输入正确的数字");
					}
				}
				catch(InputMismatchException e){
					System.out.println("输入有误，请输入正确的数字：");
					reader.next();
				}
			}
			if(Addressbooks.persons[site].num.equals("2")) {
				System.out.println("请输入联系人的电话号码1：");
				Addressbooks.persons[site].m_phone = reader.next();
				System.out.println("请输入联系人的电话号码2：");
				Addressbooks.persons[site].m_phone2 = reader.next();
				Addressbooks.persons[site].com1 = phonenumber.PhoneNumber(Addressbooks.persons[site].m_phone);
				Addressbooks.persons[site].com2 = phonenumber.PhoneNumber(Addressbooks.persons[site].m_phone2);
			}
			else {
				System.out.println("请输入联系人的电话号码：");
				Addressbooks.persons[site].m_phone = reader.next();
				Addressbooks.persons[site].com1 = phonenumber.PhoneNumber(Addressbooks.persons[site].m_phone);
			}
			System.out.println("请输入联系人的家庭住址：");
			Addressbooks.persons[site].m_Addr = reader.next();
			System.out.println("修改成功！");	
		}
	}
}
