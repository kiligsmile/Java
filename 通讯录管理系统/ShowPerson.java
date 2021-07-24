package 通讯录管理系统;

import java.util.Scanner;
import java.util.ArrayList;
// 显示联系人
class ShowPerson {
	Scanner reader = new Scanner(System.in);
	String name;
	int site,tag;
	void showPerson() {
		if(Addressbooks.m_Size==0) {
			System.out.println("当前记录为空");
		}
		else {
			for(int i=0;i<Addressbooks.m_Size;i++) {
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
				
			}
		}
	}
}
