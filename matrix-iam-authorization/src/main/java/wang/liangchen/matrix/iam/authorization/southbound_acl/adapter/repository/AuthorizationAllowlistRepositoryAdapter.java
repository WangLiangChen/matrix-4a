package wang.liangchen.matrix.iam.authorization.southbound_acl.adapter.repository;

import org.springframework.stereotype.Repository;
import wang.liangchen.matrix.framework.data.dao.StandaloneDao;
import wang.liangchen.matrix.iam.authorization.southbound_acl.port.repository.AuthorizationAllowlistRepositoryPort;

import javax.inject.Inject;

@Repository
public class AuthorizationAllowlistRepositoryAdapter implements AuthorizationAllowlistRepositoryPort {
    private final StandaloneDao standaloneDao;

    @Inject
    public AuthorizationAllowlistRepositoryAdapter(StandaloneDao standaloneDao) {
        this.standaloneDao = standaloneDao;
    }
}
