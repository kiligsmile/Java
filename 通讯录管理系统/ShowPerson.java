package 通讯录管理系统;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
// 显示联系人
class ShowPerson {
	Scanner reader = new Scanner(System.in);
	String name;
	int site,tag;
	void showPerson() throws FileNotFoundException{
		if(Addressbooks.m_Size==0) {
			System.out.println("当前记录为空");
		}
		else {
			for(int i=0;i<Addressbooks.m_Size;i++) {
				ShowInformation.showinformation(i);
			}
		}
	}
}
