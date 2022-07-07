package wang.liangchen.matrix.iam.authorization.domain;

import org.springframework.stereotype.Service;
import wang.liangchen.matrix.framework.ddd.domain.DomainService;
import wang.liangchen.matrix.iam.authorization.domain.aggregate.subject.AuthorizationSubject;
import wang.liangchen.matrix.iam.authorization.southbound_acl.port.repository.AuthorizationSubjectRepository;

import javax.inject.Inject;

/**
 * @author Liangchen.Wang 2022-07-07 12:01
 */
@Service
@DomainService
public class AuthorizationCommandDomainService {
    private final AuthorizationSubjectRepository authorizationSubjectRepository;

    @Inject
    public AuthorizationCommandDomainService(AuthorizationSubjectRepository authorizationSubjectRepository) {
        this.authorizationSubjectRepository = authorizationSubjectRepository;
    }
    public void addAuthorizationSubject(AuthorizationSubject entity){
        authorizationSubjectRepository.insert(entity);
    }
}
