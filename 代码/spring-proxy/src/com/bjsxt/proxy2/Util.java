package com.bjsxt.proxy2;

import java.io.FileOutputStream;
import java.io.IOException;

import sun.misc.ProxyGenerator;

public class Util {
	
	  
	  
    /** 
     *  Util.writeProxyClassToHardDisk("E:/$Proxy11.class",new FD1().getClass().getInterfaces() );
     */  
    public static void writeProxyClassToHardDisk(String path,Class[]  cla) {  

        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy11", cla);
          
        FileOutputStream out = null;  
          
        try {  
            out = new FileOutputStream(path);  
            out.write(classFile);  
            out.flush();  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                out.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  

}
