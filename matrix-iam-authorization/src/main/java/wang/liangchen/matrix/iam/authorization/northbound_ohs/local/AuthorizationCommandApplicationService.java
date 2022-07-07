package wang.liangchen.matrix.iam.authorization.northbound_ohs.local;

import org.springframework.stereotype.Service;
import wang.liangchen.matrix.framework.ddd.northbound_ohs.ApplicationService;
import wang.liangchen.matrix.iam.authorization.domain.AuthorizationCommandDomainService;
import wang.liangchen.matrix.iam.authorization.domain.aggregate.subject.AuthorizationSubject;
import wang.liangchen.matrix.iam.authorization.message_pl.AuthorizationSubjectCommandRequest;
import wang.liangchen.matrix.iam.authorization.message_pl.AuthorizationSubjectCommandResponse;

import javax.inject.Inject;
import java.time.LocalDateTime;

/**
 * @author Liangchen.Wang 2022-07-06 17:16
 */
@Service
@ApplicationService
public class AuthorizationCommandApplicationService {
    private final AuthorizationCommandDomainService domainService;

    @Inject
    public AuthorizationCommandApplicationService(AuthorizationCommandDomainService domainService) {
        this.domainService = domainService;
    }

    public void addAuthorizationSubject(AuthorizationSubjectCommandRequest authorizationSubjectCommandRequest) {
        AuthorizationSubject entity = AuthorizationSubject.valueOf(authorizationSubjectCommandRequest);

        entity.setCreateDatetime(LocalDateTime.now());
        entity.setModifyDatetime(LocalDateTime.now());
        domainService.addAuthorizationSubject(entity);
    }

    public void query() {
        AuthorizationSubject entity = null;
        entity.to(AuthorizationSubjectCommandResponse.class);

    }
}
