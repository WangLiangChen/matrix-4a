package wang.liangchen.matrix.iam.authorization.northbound_ohs.local;

import org.springframework.stereotype.Service;
import wang.liangchen.matrix.framework.data.dao.criteria.Criteria;
import wang.liangchen.matrix.framework.data.pagination.PaginationResult;
import wang.liangchen.matrix.framework.ddd.northbound_ohs.ApplicationService;
import wang.liangchen.matrix.iam.authorization.domain.AuthorizationSubjectManager;
import wang.liangchen.matrix.iam.authorization.domain.subject.AuthorizationSubject;
import wang.liangchen.matrix.iam.authorization.message_pl.AuthorizationSubjectQueryRequest;
import wang.liangchen.matrix.iam.authorization.message_pl.AuthorizationSubjectView;

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

    public AuthorizationSubjectView detail(Long subjectId) {
        AuthorizationSubject entity = manager.detail(subjectId);
        return entity.to(AuthorizationSubjectView.class);
    }

    public PaginationResult<AuthorizationSubjectView> pagination(AuthorizationSubjectQueryRequest queryRequest) {
        Criteria<AuthorizationSubject> criteria = Criteria.of(AuthorizationSubject.class);
        // 构造查询条件Criteria
        PaginationResult<AuthorizationSubject> pagination = manager.pagination(criteria);
        return pagination.to(AuthorizationSubjectView.class);
    }

}
