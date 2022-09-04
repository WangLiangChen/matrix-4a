package wang.liangchen.matrix.iam.authorization.domain.subject;

import org.springframework.stereotype.Service;
import wang.liangchen.matrix.framework.commons.uid.NumbericUid;
import wang.liangchen.matrix.framework.data.dao.StandaloneDao;
import wang.liangchen.matrix.framework.data.dao.criteria.Criteria;
import wang.liangchen.matrix.framework.data.dao.criteria.EntityGetter;
import wang.liangchen.matrix.framework.data.enumeration.StateEnum;
import wang.liangchen.matrix.framework.data.pagination.PaginationResult;
import wang.liangchen.matrix.framework.ddd.domain.DomainService;

import javax.inject.Inject;

/**
 * @author Liangchen.Wang 2022-07-08 10:49
 */
@Service
@DomainService
public class AuthorizationSubjectManager {
    private final StandaloneDao standaloneDao;

    @Inject
    public AuthorizationSubjectManager(StandaloneDao standaloneDao) {
        this.standaloneDao = standaloneDao;
    }

    public void add(AuthorizationSubject entity) {
        entity.setSubjectId(NumbericUid.INSTANCE.nextId());
        entity.setState(StateEnum.NORMAL.name());
        standaloneDao.insert(entity);
    }

    public void delete(Long subjectId) {
        AuthorizationSubject entity = AuthorizationSubject.newInstance();
        entity.setSubjectId(subjectId);
        standaloneDao.delete(entity);
    }

    public void update(AuthorizationSubject entity) {
        standaloneDao.update(entity);
    }

    public AuthorizationSubject detail(Long subjectId, EntityGetter<AuthorizationSubject>... resultFields) {
        return standaloneDao.select(Criteria.of(AuthorizationSubject.class)
                .resultFields(resultFields)
                ._equals(AuthorizationSubject::getSubjectId, subjectId));
    }

    public PaginationResult<AuthorizationSubject> pagination(Criteria<AuthorizationSubject> criteria) {
        return standaloneDao.pagination(criteria);
    }
}
