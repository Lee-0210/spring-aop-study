package hello.aop.order.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

    /**
     * Pointcut 분리
     * hello.aop.order 패키지와 하위 패키지
     */
    @Pointcut("execution(* hello.aop.order..*(..))")
    public void allOrder() {} // Pointcut Signature

    /**
     * 클래스 이름 패턴이 *Service
     */
    @Pointcut("execution(* *..*Service.*(..))")
    public void allService() {}

    /**
     * allOrder 와 allService 조합
     */
    @Pointcut("allOrder() && allService()")
    public void orderAndService() {}
}
