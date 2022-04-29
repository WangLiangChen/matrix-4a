package wang.liangchen.matrix.iam.authorization.domain;

import org.springframework.stereotype.Service;
import wang.liangchen.matrix.framework.ddd.domain.DomainService;
import wang.liangchen.matrix.framework.ddd.domain.RootDomainService;
import wang.liangchen.matrix.iam.authorization.message_pl.AuthorizationSubjectRequest;
import wang.liangchen.matrix.iam.authorization.southbound_acl.port.repository.AuthorizationRepository;

import javax.inject.Inject;
import java.util.List;

/**
 * @author Liangchen.Wang
 */
@Service
@DomainService
public class AuthorizationDomainService extends RootDomainService<AuthorizationSubject> {
    private final AuthorizationRepository repository;

    @Inject
    public AuthorizationDomainService(AuthorizationRepository repository) {
        this.repository = repository;
    }

    public int addAuthorizationSubjects(AuthorizationSubject... authorizationSubjects) {
        // 处理通用部分数据
        for (AuthorizationSubject authorizationSubject : authorizationSubjects) {
            
        }

        return this.repository.addAuthorizationSubjects(authorizationSubjects);
    }

    public int addAuthorizationSubjects(List<AuthorizationSubject> authorizationSubjects) {
        return this.repository.addAuthorizationSubjects(authorizationSubjects);
    }
}