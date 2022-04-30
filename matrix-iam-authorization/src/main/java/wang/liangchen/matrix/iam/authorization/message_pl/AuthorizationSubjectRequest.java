package wang.liangchen.matrix.iam.authorization.message_pl;

import jakarta.validation.constraints.NotBlank;
import wang.liangchen.matrix.framework.ddd.message_pl.Direction;
import wang.liangchen.matrix.framework.ddd.message_pl.MessageContract;


/**
 * @author Liangchen.Wang 2022-04-29 15:14
 */
@MessageContract(Direction.North)
public class AuthorizationSubjectRequest {
    @NotBlank(message = "can't be blank")
    private String tenantCode;
    @NotBlank(message = "can't be blank")
    private String appCode;
    @NotBlank(message = "can't be blank")
    private String subjectOrigin;
    @NotBlank(message = "can't be blank")
    private String subjectCode;

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

    public String getSubjectOrigin() {
        return subjectOrigin;
    }

    public void setSubjectOrigin(String subjectOrigin) {
        this.subjectOrigin = subjectOrigin;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }
}
