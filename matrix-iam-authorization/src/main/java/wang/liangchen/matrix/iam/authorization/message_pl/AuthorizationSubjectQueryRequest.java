package wang.liangchen.matrix.iam.authorization.message_pl;

import wang.liangchen.matrix.framework.commons.type.ClassUtil;
import wang.liangchen.matrix.framework.ddd.message_pl.Direction;
import wang.liangchen.matrix.framework.ddd.message_pl.MessageContract;

/**
 * @author Liangchen.Wang 2022-07-07 12:13
 */
@MessageContract(Direction.North)
public class AuthorizationSubjectQueryRequest {
    private String tenantCode;
    private String appCode;
    private String subjectCode;
    private String subjectName;

    public static AuthorizationSubjectQueryRequest newInstance() {
        return ClassUtil.INSTANCE.instantiate(AuthorizationSubjectQueryRequest.class);
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
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
