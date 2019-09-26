package hr01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Aspect
public class ServiceAop {

    private long start=0;

    @Pointcut(value = "execution(* hr01..*Controller.*(..))")  //执行类名以controller结尾的类的所有方法
    public void getTimeCost(){}

    @Before(value = "getTimeCost()")
    public void before(JoinPoint jp){
        start=new Date().getTime();
    }


    @After(value = "getTimeCost()")
    public void after(JoinPoint jp){

        System.out.println(jp.getSignature().getName()+" 耗时："+(new Date().getTime()-start) +" 毫秒");
    }
}
