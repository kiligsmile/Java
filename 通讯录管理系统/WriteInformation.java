package 通讯录管理系统;
import java.io.*;
import java.util.*;
// 在退出程序前，将对电话簿的操作进行储存
public class WriteInformation {
	static void writeinformation() throws FileNotFoundException{
		File file = new File("information.txt");
		try {
			if(!file.exists()) {
				file.createNewFile();
				}
			FileWriter fileWriter =new FileWriter(file);
			fileWriter.write("");
			fileWriter.flush();
			fileWriter.close();
			} 
		catch (IOException e) {
			e.printStackTrace();
		}		
		try{
      		 FileWriter fw=null;
      		 BufferedWriter bw=null;   
      		 if(!file.exists()){
      			 file.createNewFile();
      		 }
      		fw=new FileWriter(file.getAbsoluteFile(),true);  //true表示可以追加新内容  
            bw=new BufferedWriter(fw);
            for(int i=0;i<Addressbooks.m_Size;i++) {
	            bw.write(Addressbooks.persons[i].m_name);
	            bw.write(" ");
	            bw.write(Addressbooks.persons[i].m_Sex);
	            bw.write(" ");
	            bw.write(Addressbooks.persons[i].num);
	            bw.write(" ");      
	            bw.write(Addressbooks.persons[i].com1);
	            bw.write(" ");
	            bw.write(Addressbooks.persons[i].m_phone);
	            bw.write(" ");		             
	            if(Addressbooks.persons[i].num.equals("2")) {
	            	 bw.write(Addressbooks.persons[i].com2);
		             bw.write(" ");
		             bw.write(Addressbooks.persons[i].m_phone2);
		             bw.write(" ");
	            }
	            bw.write(Addressbooks.persons[i].m_Addr);
	            bw.write("\n");	    	        
	        }
            bw.close();
		}
		catch(Exception e){
	           e.printStackTrace();
	     }
	}
}
