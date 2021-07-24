package 通讯录管理系统;
import java.util.*;

// 一键删除所有联系人
class CleanAllPerson {
	Scanner reader = new Scanner(System.in);
	int tag;
	void cleanAllPerson() {
		while(true) {
			System.out.println("确定清空当前通讯录中所有联系人？ 1——确定 / 2——取消");
			tag = reader.nextInt();
			if(tag==1) {
				Addressbooks.m_Size=  0;
				System.out.println("清空成功！");
				break;
			}
			else if(tag==2) {
				break;
			}
			else {
				System.out.println("请输入正确的数字");
			}
		}
	}

}
