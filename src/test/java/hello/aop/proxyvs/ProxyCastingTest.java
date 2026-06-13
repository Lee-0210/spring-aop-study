package hello.aop.proxyvs;

import hello.aop.member.MemberService;
import hello.aop.member.MemberServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;

@Slf4j
public class ProxyCastingTest {

    @Test
    void jdkProxy() {
        MemberService target = new MemberServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.setProxyTargetClass(false); // JDK 동적 프록시 사용

        // JDK 동적 프록시를 인터페이스로 캐스팅 (성공)
        Object proxy1 = (MemberService)proxyFactory.getProxy();

        // JDK 동적 프록시를 구현 클래스로 캐스팅 (실패), ClassCastException 예외 발생
        Assertions.assertThrows(ClassCastException.class, () -> {
            MemberServiceImpl proxy2 = (MemberServiceImpl)proxyFactory.getProxy();
        });
    }

    @Test
    void cglibProxy() {
        MemberService target = new MemberServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.setProxyTargetClass(true); // CGLIB 프록시 사용

        // CGLIB 동적 프록시를 인터페이스로 캐스팅 (성공)
        Object proxy1 = (MemberService)proxyFactory.getProxy();

        // CGLIB 동적 프록시를 구현 클래스로 캐스팅 (성공)
        MemberServiceImpl proxy2 = (MemberServiceImpl)proxyFactory.getProxy();
    }
}
