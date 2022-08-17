package wang.liangchen.matrix.iam.authorization.message_pl;

import wang.liangchen.matrix.framework.commons.type.ClassUtil;
import wang.liangchen.matrix.framework.ddd.message_pl.Direction;
import wang.liangchen.matrix.framework.ddd.message_pl.IResult;
import wang.liangchen.matrix.framework.ddd.message_pl.MessageContract;

/**
 * @author Liangchen.Wang 2022-07-07 12:13
 */
@MessageContract(Direction.North)
public class AuthorizationSubjectResult implements IResult {
    private String tenantCode;
    private String consumerCode;
    private String subjectCode;
    private String subjectName;

    public static AuthorizationSubjectResult newInstance() {
        return ClassUtil.INSTANCE.instantiate(AuthorizationSubjectResult.class);
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public String getConsumerCode() {
        return consumerCode;
    }

    public void setConsumerCode(String consumerCode) {
        this.consumerCode = consumerCode;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
