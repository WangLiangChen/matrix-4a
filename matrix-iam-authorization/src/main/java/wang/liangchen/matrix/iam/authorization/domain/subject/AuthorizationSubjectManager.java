package wang.liangchen.matrix.iam.authorization.domain.subject;

import org.springframework.stereotype.Service;
import wang.liangchen.matrix.framework.commons.uid.NumbericUid;
import wang.liangchen.matrix.framework.data.dao.StandaloneDao;
import wang.liangchen.matrix.framework.data.dao.criteria.*;
import wang.liangchen.matrix.framework.data.enumeration.StateEnum;
import wang.liangchen.matrix.framework.data.pagination.PaginationResult;
import wang.liangchen.matrix.framework.ddd.domain.DomainService;

import javax.inject.Inject;
import java.util.Collection;
import java.util.List;

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
        standaloneDao.delete(SubCriteria.of(AuthorizationSubject.class)
                ._equals(AuthorizationSubject::getSubjectId, SqlValue.of(subjectId)));
    }

    public void update(AuthorizationSubject entity) {
        standaloneDao.update(entity);
    }

    public AuthorizationSubject detail(Long subjectId, EntityGetter<AuthorizationSubject>... resultFields) {
        return standaloneDao.select(Criteria.of(AuthorizationSubject.class)
                .resultFields(resultFields)
                ._equals(AuthorizationSubject::getSubjectId, SqlValue.of(subjectId)));
    }

    public PaginationResult<AuthorizationSubject> pagination(Criteria<AuthorizationSubject> criteria) {
        return standaloneDao.pagination(criteria);
    }

    /**
     * 改变状态
     * 从若干个状态迁移到一个状态
     *
     * @param subjectId
     * @param stateTo
     * @param stateFrom
     */
    public void changeState(Long subjectId, String stateTo, String... stateFrom) {
        SqlValue[] sqlValues = new SqlValue[stateFrom.length];
        for (int i = 0; i < stateFrom.length; i++) {
            sqlValues[i] = SqlValue.of(stateFrom[i]);
        }
        standaloneDao.update(UpdateCriteria.of(AuthorizationSubject.newInstance())
                // 强制更新状态
                .forceUpdate(AuthorizationSubject::getState, stateTo)
                ._equals(AuthorizationSubject::getSubjectId, SqlValue.of(subjectId))
                ._in(AuthorizationSubject::getState, sqlValues));
    }


    public List<AuthorizationSubject> queryByStates(Collection<String> states, EntityGetter<AuthorizationSubject>... resultFields) {
        int size = states.size();
        SqlValue[] sqlValues = new SqlValue[size];
        for (String state : states) {
            sqlValues[size--] = SqlValue.of(state);
        }
        return standaloneDao.list(Criteria.of(AuthorizationSubject.class)
                .resultFields(resultFields)
                ._in(AuthorizationSubject::getState, sqlValues));
    }
}
