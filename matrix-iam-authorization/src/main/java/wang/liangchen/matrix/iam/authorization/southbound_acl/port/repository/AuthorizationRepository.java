package wang.liangchen.matrix.iam.authorization.southbound_acl.port.repository;

import wang.liangchen.matrix.framework.ddd.southbound_acl.Port;
import wang.liangchen.matrix.framework.ddd.southbound_acl.PortType;
import wang.liangchen.matrix.iam.authorization.domain.AuthorizationSubject;

import java.util.List;

/**
 * @author Liangchen.Wang 2022-04-24 14:37
 */
@Port(PortType.Repository)
public interface AuthorizationRepository {
    int addAuthorizationSubjects(AuthorizationSubject... authorizationSubjects);
    int addAuthorizationSubjects(List<AuthorizationSubject> authorizationSubjects);
}
