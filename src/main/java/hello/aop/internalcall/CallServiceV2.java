package hello.aop.internalcall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CallServiceV2 {

    // ApplicationContext 는 너무 많은 기능을 제공하는 제공하기 때문에 사용하면 비효율적
    // private final ApplicationContext applicationContext;

    private final ObjectProvider<CallServiceV2> callServiceV2Provider;

    /*public CallServiceV2(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }*/

    public CallServiceV2(ObjectProvider<CallServiceV2> callServiceV2Provider) {
        this.callServiceV2Provider = callServiceV2Provider;
    }

    public void external() {
        log.info("call external");
        // ApplicationContext 에서 자기 자신을 지연 조회
        // CallServiceV2 callServiceV2 = applicationContext.getBean(CallServiceV2.class);
        // callServiceV2.internal();

        // ObjectProvider 를 이용해 자기 자신을 지연 조회
        CallServiceV2 callServiceV2 = callServiceV2Provider.getObject();
        callServiceV2.internal();
    }

    public void internal() {
        log.info("call internal");
    }
}
