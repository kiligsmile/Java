package 通讯录管理系统;

// 判断联系人是否存在
class IsExist {
	static int isExist(String name) {
		for(int i=0;i<Addressbooks.m_Size;i++) {
			if(Addressbooks.persons[i].m_name.equals(name)) {
				return i;
			}
		}
		return -1; // 不存在该用户返回-1，否则返回联系人所在位置的索引值
	}
}
