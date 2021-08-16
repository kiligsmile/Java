package 通讯录管理系统;
import java.io.File;
// 读入txt文件中联系人信息，并储存在数组中
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ReadInformation {
	static void readinformation() throws FileNotFoundException{
		
		File file = new File("information.txt");
		if(!file.exists()) {
			System.out.println("文件未找到");
			System.exit(0);
		}
		Scanner s = new Scanner(file);
		try {			
			for(int i=0;i<Addressbooks.m_Size;i++) {
				Person person = new Person();
				person.m_name=s.next();
				person.m_Sex=s.next();
				person.num=s.next();
				person.com1=s.next();
				person.m_phone=s.next();
				if(person.num.equals("2")) { //这里考虑到一个联系人两个号码时，信息的读入
					person.com2=s.next(); 
					person.m_phone2=s.next();		             
	             } 
				person.m_Addr=s.next();
				Addressbooks.persons[i]=person;	
			}	
			s.close();
		}
		catch(Exception e) {
			System.out.println("发现错误");
		}
	}
}
