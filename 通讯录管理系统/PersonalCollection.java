package 通讯录管理系统;
import java.util.*;

// 个人收藏
public class PersonalCollection {
	Scanner reader = new Scanner(System.in);
	final static int MAX = 1000;
	String n_name;
	Person persons[] = new Person[MAX];
	static int m_Size=0;
	void CollectionContacts() {
		if(PersonalCollection.m_Size<PersonalCollection.MAX) {
			System.out.println("请输入您要收藏的联系人姓名：");
			n_name = reader.next();
			if(IsExist.isExist(n_name)==-1) {
				System.out.println("该联系人不存在");
			}
			else {
				persons[Addressbooks.m_Size]=Addressbooks.persons[IsExist.isExist(n_name)];
				m_Size++;
				System.out.println("收藏成功！");
			}
			
		}
	}
	
	void show() {
		if(m_Size>0) {
			for(int i=0;i<m_Size;i++) {
				System.out.print("姓名："+Addressbooks.persons[i].m_name+'\t');
				System.out.print("性别："+Addressbooks.persons[i].m_Sex+'\t');
				System.out.print("电话："+Addressbooks.persons[i].m_phone+'\t');
				System.out.println("住址："+Addressbooks.persons[i].m_Addr);
			}
		}
		else {
			System.out.println("收藏目录为空");
		}
		
	}

}
