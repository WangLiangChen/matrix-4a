package wang.liangchen.matrix.iam.authorization.northbound_ohs.local;

import org.springframework.stereotype.Service;
import wang.liangchen.matrix.framework.commons.object.ObjectUtil;
import wang.liangchen.matrix.framework.data.dao.criteria.Criteria;
import wang.liangchen.matrix.framework.data.pagination.PaginationResult;
import wang.liangchen.matrix.framework.ddd.northbound_ohs.ApplicationService;
import wang.liangchen.matrix.iam.authorization.domain.subject.AuthorizationSubject;
import wang.liangchen.matrix.iam.authorization.domain.subject.AuthorizationSubjectManager;
import wang.liangchen.matrix.iam.authorization.message_pl.AuthorizationSubjectQueryRequest;
import wang.liangchen.matrix.iam.authorization.message_pl.AuthorizationSubjectQueryResponse;

import javax.inject.Inject;
import java.util.Collection;
import java.util.List;

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

    public AuthorizationSubjectQueryResponse detail(Long subjectId) {
        AuthorizationSubject entity = manager.detail(subjectId);
        return entity.to(AuthorizationSubjectQueryResponse.class);
    }

    public PaginationResult<AuthorizationSubjectQueryResponse> pagination(AuthorizationSubjectQueryRequest queryRequest) {
        Criteria<AuthorizationSubject> criteria = Criteria.of(AuthorizationSubject.class);
        // 构造查询条件Criteria
        PaginationResult<AuthorizationSubject> pagination = manager.pagination(criteria);
        return pagination.to(AuthorizationSubjectQueryResponse.class);
    }

    public List<AuthorizationSubjectQueryResponse> queryByStates(Collection<String> states) {
        List<AuthorizationSubject> entities = manager.queryByStates(states);
        return ObjectUtil.INSTANCE.copyProperties(entities, AuthorizationSubjectQueryResponse.class);
    }
}
