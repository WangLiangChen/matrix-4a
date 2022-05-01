package wang.liangchen.matrix.iam.account.southbound_acl.port.publisher;


import wang.liangchen.matrix.framework.ddd.southbound_acl.Port;
import wang.liangchen.matrix.framework.ddd.southbound_acl.PortType;
import wang.liangchen.matrix.iam.account.message_pl.AccountRegisteredEvent;

@Port(PortType.Publisher)
public interface AccountRegisteredEventPublisher {
    void publish(AccountRegisteredEvent accountRegisteredEvent);
}
