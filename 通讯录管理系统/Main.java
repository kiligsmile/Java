package 通讯录管理系统;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int select1 = 0; // 选择主菜单
		int select2 = 0; // 选择附件菜单
		boolean bool1 = true;
		String name;
		ShowMenu showmenu = new ShowMenu();
		while (bool1) {  // 当bool1为false时，退出循环
			showmenu.showMenu(); // 显示菜单
			System.out.println("请输入你的选择：");
			select1 = reader.nextInt();
			while(select1<0||select1>7) {   // 输入正确的序号，才会终止循环
				System.out.println("请输入正确的序号：");  
				select1 = reader.nextInt();
			}
			switch (select1) {
			case 1:  // 添加联系人
				AddPerson addperson = new AddPerson();
				addperson.addPerson();
				break;
			case 2:  // 显示联系人
				ShowPerson showperson = new ShowPerson();
				showperson.showPerson();
				break;
			case 3:  // 删除联系人
				DeletePerson deleteperson = new DeletePerson();
				deleteperson.deletePerson();
				break;
			case 4:   // 查找联系人
				FindPerson findperson = new FindPerson();
				findperson.findPerson();
				break;
			case 5:   // 修改联系人
				ModifyPerson modifyperson = new ModifyPerson();
				modifyperson.modifyPerson();
				break;
			case 6: // 清空联系人
				CleanAllPerson cleanallperson = new CleanAllPerson();
				cleanallperson.cleanAllPerson();
				break;
			case 0: // 退出程序
				System.out.println("欢迎下次使用~");
				bool1 = false;
				break;
			case 7:
				PersonalCollection personalcollection = new PersonalCollection();
				showmenu.ShowMenu2();
				System.out.println("请输入你的选择：");
				select2 = reader.nextInt();
				while(select2<1||select2>4) {
					System.out.println("请输入正确的序号：");  // 输入正确序号时，才会退出循环
					select2 = reader.nextInt();
				}
				switch (select2) {
				case 1:// 收藏
					personalcollection.CollectionContacts();						
					break;
				case 2: // 显示收藏
					personalcollection.show();						
					break;
				case 3:  // 生成多个用户
					AddMultiplePerson addmultipleperson = new AddMultiplePerson();
					addmultipleperson.view();
					break;
				case 4:
					// 排序
				}
			default:
				break;
			}
			
		}
			

	}
}
