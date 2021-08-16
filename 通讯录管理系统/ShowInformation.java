package 通讯录管理系统;
// 为避免代码重复，将显示信息，单独设置为类方法

public class ShowInformation {
	static void showinformation(int i) {
		System.out.print("姓名："+Addressbooks.persons[i].m_name+'\t');
		System.out.print("性别："+Addressbooks.persons[i].m_Sex+'\t');
		if(Addressbooks.persons[i].num.equals("2")) {
			System.out.print("电话1："+Addressbooks.persons[i].com1+'-'+Addressbooks.persons[i].m_phone+'\t');
			System.out.print("电话2："+Addressbooks.persons[i].com2+'-'+Addressbooks.persons[i].m_phone2+'\t');
		}
		else {                                                                                            		
			System.out.print("电话： "+Addressbooks.persons[i].com1+'-'+Addressbooks.persons[i].m_phone+'\t'+"	           	        ");
		}
		System.out.println("住址："+Addressbooks.persons[i].m_Addr);
	}
}