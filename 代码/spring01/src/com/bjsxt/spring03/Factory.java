package com.bjsxt.spring03;

public class Factory {

      public   People   getInstance(String  param){

            if("tea".equals(param)){

                return  new Teacher();
            }else if("stu".equals(param)){

                return   new Student();

            }else {

                return  null;
            }

      }

    public   static People   getInstance2(String  param){

        if("tea".equals(param)){

            return  new Teacher();
        }else if("stu".equals(param)){

            return   new Student();

        }else {

            return  null;
        }

    }


}
