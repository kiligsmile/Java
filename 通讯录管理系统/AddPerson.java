package 通讯录管理系统;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
// 添加联系人

class AddPerson {
	Scanner reader = new Scanner(System.in);
	String judge = "1";
	void addPerson() throws IOException {
		Phonenumber phonenumber = new Phonenumber();
		if(Addressbooks.m_Size>=Addressbooks.MAX) {
			System.out.println("通讯录已满！");
			return;
		}
		else {
			Person person = new Person();
			System.out.println("请输入联系人的姓名：");
			person.m_name = reader.next();
			for(int i=0;i<Addressbooks.m_Size;i++) {
				if(person.m_name.equals(Addressbooks.persons[i].m_name)) {
					System.out.println("该姓名已存在，是否将号码添加到已有联系人中 Y/N");
					judge = reader.next();
					while(true) {
						if(judge.equals("Y")) {
							if(Addressbooks.persons[i].num.equals("2")) {
								System.out.println("储存该联系人的电话号码不能超过两个");
							}
							else {
								System.out.println("请输入电话号码：");
								Addressbooks.persons[i].m_phone2 = reader.next();
								while(true) {
									if(phonenumber.getnumber(Addressbooks.persons[i].m_phone2)==1) {
										Addressbooks.persons[i].com2=phonenumber.PhoneNumber(Addressbooks.persons[i].m_phone2);
										break;
									}
									else {
										System.out.println("请输入正确的电话号码：");
										person.m_phone = reader.next();
									}
								}
								Addressbooks.persons[i].num = "2";
							}
							break;
						}
						else if(judge.equals("N")) {
							break;
						}
						else {
							System.out.println("请输入 Y or N");
							judge = reader.next();
						}
					}
					break;
				}	
			}
			if(!(judge.equals("Y"))) {
				System.out.println("请选择联系人的性别：");
				System.out.println("1————男  2————女");
				while(true) {
					try {
						int sex = reader.nextInt(); 
						if(sex==1) {
							person.m_Sex="男";
							break;
						}
						else if(sex==2) {
							person.m_Sex="女";
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
				System.out.println("请输入联系人的电话号码：");
				person.m_phone = reader.next();
				while(true) {
					if(phonenumber.getnumber(person.m_phone)==1) { // 判断是否为正确的电话号码形式
						person.com1=phonenumber.PhoneNumber(person.m_phone); // 若为正确，判断移动、电信等
						break;
					}
					else {
						System.out.println("请输入正确的电话号码：");
						person.m_phone = reader.next();
					}
				}
				System.out.println("请输入联系人的家庭住址：");
				person.m_Addr = reader.next();
				Addressbooks.persons[Addressbooks.m_Size]=person;
				Addressbooks.m_Size++;
				System.out.println("添加成功！");				
			}		
		}
	}
}
