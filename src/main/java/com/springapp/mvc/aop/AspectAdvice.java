package com.springapp.mvc.aop;

import com.google.gson.Gson;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 切面
 * @author Jett
 *
 */
@Aspect
@Component
public class AspectAdvice {
    @Pointcut("execution(* com.springapp.mvc.service.impl..*(..))")
    private void anyMethod(){}//定义一个切入点

    @Before("anyMethod()")
    public void doAccessCheck(JoinPoint point){
        System.out.println("@Before：模拟权限检查...");
        System.out.println("@Before：目标方法为：" +
                point.getSignature().getDeclaringTypeName() +
                "." + point.getSignature().getName());
        System.out.println("@Before：参数为：" + Arrays.toString(point.getArgs()));
        System.out.println("@Before：被织入的目标对象为：" + point.getTarget());
    }

    @AfterReturning(pointcut="anyMethod()", returning="returnValue")
    public void doAfter(JoinPoint point, Object returnValue){;
        System.out.println("@AfterReturning：模拟日志记录功能...");
        System.out.println("@AfterReturning：目标方法为：" + point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName());
        System.out.println("@AfterReturning：参数为：" + Arrays.toString(point.getArgs()));
        Object[] objects = point.getArgs();
        for (Object object : objects) {
            System.out.println(new Gson().toJson(object));
        }
        System.out.println("@AfterReturning：返回值为：" + returnValue);
        System.out.println("@AfterReturning：被织入的目标对象为：" + point.getTarget());



        String methodName = point.getSignature().getName();
        Object target = point.getTarget();
        Method method = getMethodByClassAndName(target.getClass(), methodName); // 得到拦截的方法
        Class returnType = method.getReturnType(); // 得到方法返回值类型
        System.out.println("@AfterReturning：返回值类型为：" + returnType.toString());


    }

    @After("anyMethod()")
    public void after(){

        System.out.println("@After: 后置通知");
    }

    @AfterThrowing("anyMethod()")
    public void doAfterThrow(){

        System.out.println("例外通知");
    }

    @Around("anyMethod()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("进入环绕通知");
        Object object = pjp.proceed();//执行该方法
        System.out.println("退出环绕通知");
        return object;
    }

    @SuppressWarnings("unchecked")
    public Method getMethodByClassAndName(Class c, String methodName) {
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                return method;
            }
        }
        return null;
    }
}

