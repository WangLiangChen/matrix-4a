package wang.liangchen.matrix.iam.authorization.southbound_acl.adapter.repository;

import wang.liangchen.matrix.framework.data.dao.AbstractParameterizedDao;
import wang.liangchen.matrix.iam.authorization.domain.aggregate.subject.AuthorizationSubject;
import wang.liangchen.matrix.iam.authorization.southbound_acl.port.repository.AuthorizationSubjectRepository;


/**
 * @author Liangchen.Wang 2022-07-07 12:05
 */
public class AuthorizationSubjectRepositoryDefaultAdapter extends AbstractParameterizedDao<AuthorizationSubject> implements AuthorizationSubjectRepository {
}
