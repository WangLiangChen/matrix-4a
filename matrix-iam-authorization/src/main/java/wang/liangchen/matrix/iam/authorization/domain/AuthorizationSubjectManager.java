package wang.liangchen.matrix.iam.authorization.domain;

import org.springframework.stereotype.Component;
import wang.liangchen.matrix.framework.data.dao.criteria.Criteria;
import wang.liangchen.matrix.framework.data.dao.criteria.SqlValue;
import wang.liangchen.matrix.framework.data.dao.criteria.SubCriteria;
import wang.liangchen.matrix.framework.data.dao.criteria.UpdateCriteria;
import wang.liangchen.matrix.framework.data.pagination.PaginationResult;
import wang.liangchen.matrix.framework.ddd.domain.DomainService;
import wang.liangchen.matrix.iam.authorization.domain.subject.AuthorizationSubject;
import wang.liangchen.matrix.iam.authorization.southbound_acl.port.repository.AuthorizationSubjectRepository;

import javax.inject.Inject;

/**
 * @author Liangchen.Wang 2022-08-17 11:08
 */
@Component
@DomainService
public class AuthorizationSubjectManager {
    private final AuthorizationSubjectRepository repository;

    @Inject
    public AuthorizationSubjectManager(AuthorizationSubjectRepository repository) {
        this.repository = repository;
    }

    public AuthorizationSubject detail(Long subjectId) {
        return repository.select(Criteria.of(AuthorizationSubject.class)._equals(AuthorizationSubject::getSubjectId, SqlValue.of(subjectId)));
    }

    public PaginationResult<AuthorizationSubject> pagination(Criteria<AuthorizationSubject> criteria) {
        return repository.pagination(criteria);
    }

    public void add(AuthorizationSubject entity) {
        repository.add(entity);
    }

    public int delete(Long subjectId) {
        return repository.delete(SubCriteria.of(AuthorizationSubject.class)._equals(AuthorizationSubject::getSubjectId, SqlValue.of(subjectId)));
    }

    public int update(AuthorizationSubject entity) {
        return repository.update(entity);
    }

    public int changeState(Long subjectId, String from, String to) {
        AuthorizationSubject entity = AuthorizationSubject.newInstance();
        entity.setState(to);
        UpdateCriteria<AuthorizationSubject> criteria = UpdateCriteria.of(entity)
                ._equals(AuthorizationSubject::getSubjectId, SqlValue.of(subjectId))
                ._equals(AuthorizationSubject::getState, SqlValue.of(from));
        return repository.update(criteria);
    }
}
