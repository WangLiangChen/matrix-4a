package wang.liangchen.matrix.iam.account.southbound_acl.adapter.repository;

import org.springframework.stereotype.Repository;
import wang.liangchen.matrix.framework.ddd.southbound_acl.Adapter;
import wang.liangchen.matrix.framework.ddd.southbound_acl.PortType;
import wang.liangchen.matrix.iam.account.southbound_acl.port.repository.AccountRepository;

/**
 * @author Liangchen.Wang 2022-04-24 14:38
 */
@Adapter(PortType.Repository)
@Repository
public class AccountRepositoryAdapter implements AccountRepository {
}
