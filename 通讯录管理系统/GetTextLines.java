package 通讯录管理系统;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//读取txt文件有多少行，即储存了多少联系人
public class GetTextLines {
	public static int getTextLines() throws IOException {
		String path = "/Users/Kilig/eclipse-workspace/通讯录管理系统/information.txt";// 定义文件路径
		FileReader fr = new FileReader(path); //这里定义一个字符流的输入流的节点流，用于读取文件（一个字符一个字符的读取）
		BufferedReader br = new BufferedReader(fr); // 在定义好的流基础上套接一个处理流，用于更加效率的读取文件（一行一行的读取）
		int x = 0; // 用于统计行数，从0开始
		while(br.readLine() != null) { // readLine()方法是按行读的，返回值是这行的内容
			x++; // 每读一行，则变量x累加1
		}
		return x; //返回总的行数
	}
}
