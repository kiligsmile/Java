package com.bjsxt.advice;

import org.springframework.aop.ThrowsAdvice;

public class ThrowAdvice  implements ThrowsAdvice {

    /**
     * Exception：异常对象
     *
     * */
    public void afterThrowing(Exception ex) throws Throwable {
        // Do something with remote exception
        System.out.println("异常通知");
    }

}
