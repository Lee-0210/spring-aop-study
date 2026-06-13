package hello.aop.internalcall;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Slf4j
@Import(CallLogAspect.class)
@SpringBootTest
public class CallServiceV0Test {

    @Autowired
    CallServiceV0 callServiceV0;

    @Test
    void external() {
        // external() 안에서 실행되는 internal() 메서드는 this.internal() 이기 때문에 AOP 적용되지 않음
        callServiceV0.external();
    }

    @Test
    void internal() {
        callServiceV0.internal();
    }
}
