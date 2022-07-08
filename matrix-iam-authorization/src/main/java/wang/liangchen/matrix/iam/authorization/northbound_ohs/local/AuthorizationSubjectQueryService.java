package wang.liangchen.matrix.iam.authorization.northbound_ohs.local;

import org.springframework.stereotype.Service;
import wang.liangchen.matrix.framework.ddd.northbound_ohs.ApplicationService;
import wang.liangchen.matrix.iam.authorization.domain.subject.AuthorizationSubject;
import wang.liangchen.matrix.iam.authorization.domain.subject.AuthorizationSubjectManager;
import wang.liangchen.matrix.iam.authorization.message_pl.AuthorizationSubjectResponse;

import javax.inject.Inject;

/**
 * @author Liangchen.Wang 2022-07-08 10:53
 */
@Service
@ApplicationService
public class AuthorizationSubjectQueryService {
    private final AuthorizationSubjectManager manager;

    @Inject
    public AuthorizationSubjectQueryService(AuthorizationSubjectManager manager) {
        this.manager = manager;
    }

    public AuthorizationSubjectResponse find(Long subjectId) {
        AuthorizationSubject entity = manager.find(subjectId);
        return entity.to(AuthorizationSubjectResponse.class);
    }
}
