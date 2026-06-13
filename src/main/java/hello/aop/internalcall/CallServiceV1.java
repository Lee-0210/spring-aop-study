package hello.aop.internalcall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CallServiceV1 {

    private CallServiceV1 callServiceV1;

    /**
     * Setter 로 주입하게 되면 자기 자신의 인스턴스 생성 후 주입할 수 있다.
     */
    @Autowired
    @Lazy
    public void setCallServiceV1(CallServiceV1 callServiceV1) {
        log.info("callServiceV1 setter={}", callServiceV1.getClass());
        this.callServiceV1 = callServiceV1;
    }

    public void external() {
        log.info("call external");
        callServiceV1.internal(); // 주입받은 자기 자신의 인스턴스로 외부 호출
    }

    public void internal() {
        log.info("call internal");
    }
}
