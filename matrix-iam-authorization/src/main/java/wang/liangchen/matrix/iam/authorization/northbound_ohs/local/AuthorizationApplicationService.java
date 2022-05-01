package wang.liangchen.matrix.iam.authorization.northbound_ohs.local;

import org.springframework.stereotype.Service;
import wang.liangchen.matrix.framework.commons.validation.ValidationUtil;
import wang.liangchen.matrix.framework.data.enumeration.DataMode;
import wang.liangchen.matrix.framework.ddd.northbound_ohs.Local;
import wang.liangchen.matrix.iam.authorization.domain.AuthorizationDomainService;
import wang.liangchen.matrix.iam.authorization.domain.AuthorizationSubject;
import wang.liangchen.matrix.iam.authorization.message_pl.AuthorizationSubjectRequest;
import wang.liangchen.matrix.iam.authorization.southbound_acl.port.repository.AuthorizationRepository;

import javax.inject.Inject;
import java.time.LocalDateTime;

/**
 * @author Liangchen.Wang 2022-04-24 14:15
 * 事务等横切关注点在这一层
 */
@Local
@Service
public class AuthorizationApplicationService {
    private final AuthorizationDomainService domainService;
    private final AuthorizationRepository repository;

    @Inject
    public AuthorizationApplicationService(AuthorizationDomainService domainService, AuthorizationRepository repository) {
        this.domainService = domainService;
        this.repository = repository;
    }

    public int addAuthorizationSubject(AuthorizationSubjectRequest authorizationSubjectRequest) {
        ValidationUtil.INSTANCE.validate(authorizationSubjectRequest);
        AuthorizationSubject authorizationSubject = authorizationSubjectRequest.to()
                .setSubjectId(0L)
                .setDataMode(DataMode.A.getValue())
                .setVersion(0)
                .setSort(0)
                .setOwner("")
                .setCreator("")
                .setCreateDatetime(LocalDateTime.now())
                .setModifier("")
                .setModifyDatetime(LocalDateTime.now())
                .setSummary("")
                .setState("NORMAL");
        return repository.addAuthorizationSubjects(authorizationSubject);
    }
}
