package wang.liangchen.matrix.iam.authorization.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wang.liangchen.matrix.iam.authorization.message_pl.AuthorizationSubjectCommandRequest;
import wang.liangchen.matrix.iam.authorization.northbound_ohs.local.AuthorizationSubjectCommandService;

import javax.annotation.Resource;

/**
 * @author Liangchen.Wang 2022-07-08 11:31
 */
@SpringBootTest
public class SubjectTest {
    @Resource
    private AuthorizationSubjectCommandService commandService;

    @Test
    public void testAdd() {
        AuthorizationSubjectCommandRequest commandRequest = AuthorizationSubjectCommandRequest.newInstance();
        commandRequest.setTenantCode("a");
        commandRequest.setConsumerCode("b");
        commandRequest.setSubjectCode("c");
        commandRequest.setSubjectName("d");
        commandService.add(commandRequest);
    }
}
