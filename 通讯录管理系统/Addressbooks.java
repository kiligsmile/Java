package 通讯录管理系统;
import java.util.ArrayList;

// 联系人基本属性
class Person {
	String m_name;
	String m_Sex;
	String m_phone;
	String m_phone2;
	String m_Addr;
	String com1; // 移动、电信...
	String com2; // 第二个电话号码
	String num = "1";
}
// 对象数组
class Addressbooks{
	final static int MAX = 1000;
	static int m_Size=0;
	static Person persons[] = new Person[MAX];
}