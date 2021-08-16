package 通讯录管理系统;

// (number.matches("^((13[4-9])|(147)|(15([0-3]|[7-9]))|(178)|(18[2-4]|[7|8]))\\d{8}$"))

public class Phonenumber {
	// 判断用户输入的电话号码形式上是否正确
	int getnumber(String number) {
		if(number.matches("^((13[0-9])|(14[5|7|9])|(15([0-3]|[5-9]))|(17[35678])|(18[0-9]))\\d{8}$")) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
	// 区分移动，联通，电信
	 String PhoneNumber(String number) {
		 if(number.matches("^((133)|(149)|(153)|(17[3|7])|(18[0|1|9]))\\d{8}$")){
			 return "中国电信";
		 }
		 else if(number.matches("^((13[0-2])|(145)|(15([5|6]))|(166)|(17[56])|(18[56]))\\d{8}$")) {
			 return "中国联通";
		 }
		 else if(number.matches("^((13[4-9])|(147)|(15([0-2]))|(15([7-9]))|(178)|(18[2|3|4|7|8]))\\d{8}$")) {
			 return "中国移动";
		 }
		 else {
			 return "未知类型";
		 }
	 }
}
