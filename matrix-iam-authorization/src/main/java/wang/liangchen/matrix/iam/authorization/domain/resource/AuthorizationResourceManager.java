package wang.liangchen.matrix.iam.authorization.domain.resource;

import org.springframework.stereotype.Service;
import wang.liangchen.matrix.framework.commons.uid.NumbericUid;
import wang.liangchen.matrix.framework.data.dao.StandaloneDao;
import wang.liangchen.matrix.framework.data.dao.criteria.Criteria;
import wang.liangchen.matrix.framework.data.dao.criteria.EntityGetter;
import wang.liangchen.matrix.framework.data.dao.criteria.SqlValue;
import wang.liangchen.matrix.framework.data.dao.criteria.UpdateCriteria;
import wang.liangchen.matrix.framework.data.enumeration.StateEnum;
import wang.liangchen.matrix.framework.data.pagination.PaginationResult;
import wang.liangchen.matrix.framework.ddd.domain.DomainService;
import wang.liangchen.matrix.iam.authorization.domain.subject.AuthorizationSubject;

import javax.inject.Inject;
import java.util.Collection;
import java.util.List;

/**
 * @author Liangchen.Wang 2022-07-08 10:49
 */
@Service
@DomainService
public class AuthorizationResourceManager {
    private final StandaloneDao standaloneDao;

    @Inject
    public AuthorizationResourceManager(StandaloneDao standaloneDao) {
        this.standaloneDao = standaloneDao;
    }

}
