package wang.liangchen.matrix.iam.authorization.domain.subject;

import org.springframework.stereotype.Service;
import wang.liangchen.matrix.framework.commons.uid.NumbericUid;
import wang.liangchen.matrix.framework.data.dao.StandaloneDao;
import wang.liangchen.matrix.framework.data.dao.criteria.Criteria;
import wang.liangchen.matrix.framework.data.dao.criteria.SqlValue;
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
        entity.setState("NORMAL");
        standaloneDao.insert(entity);
    }

    public AuthorizationSubject find(Long subjectId) {
        return standaloneDao.select(Criteria.of(AuthorizationSubject.class)._equals(AuthorizationSubject::getSubjectId, SqlValue.of(subjectId)));
    }
}
