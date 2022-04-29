package wang.liangchen.matrix.iam.authorization.southbound_acl.adapter.repository;

import org.springframework.stereotype.Repository;
import wang.liangchen.matrix.framework.data.dao.StandaloneDao;
import wang.liangchen.matrix.framework.ddd.southbound_acl.Adapter;
import wang.liangchen.matrix.framework.ddd.southbound_acl.PortType;
import wang.liangchen.matrix.iam.authorization.domain.AuthorizationSubject;
import wang.liangchen.matrix.iam.authorization.southbound_acl.port.repository.AuthorizationRepository;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

/**
 * @author Liangchen.Wang 2022-04-24 14:38
 */
@Adapter(PortType.Repository)
@Repository
public class AuthorizationRepositoryAdapter implements AuthorizationRepository {
    private final StandaloneDao standaloneDao;

    @Inject
    public AuthorizationRepositoryAdapter(StandaloneDao standaloneDao) {
        this.standaloneDao = standaloneDao;
    }

    @Override
    public int addAuthorizationSubjects(AuthorizationSubject... authorizationSubjects) {
        return standaloneDao.insert(Arrays.asList(authorizationSubjects));
    }

    @Override
    public int addAuthorizationSubjects(List<AuthorizationSubject> authorizationSubjects) {
        return standaloneDao.insert(authorizationSubjects);
    }
}
