package wang.liangchen.matrix.iam.authorization.message_pl;

import jakarta.validation.constraints.NotBlank;
import wang.liangchen.matrix.framework.commons.object.ObjectUtil;
import wang.liangchen.matrix.framework.ddd.message_pl.Direction;
import wang.liangchen.matrix.framework.ddd.message_pl.MessageContract;
import wang.liangchen.matrix.iam.authorization.domain.AuthorizationSubject;

import javax.persistence.Column;


/**
 * @author Liangchen.Wang 2022-04-29 15:14
 */
@MessageContract(Direction.North)
public class AuthorizationSubjectRequest {
    @NotBlank(message = "can't be blank")
    @Column
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

    public AuthorizationSubjectRequest setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
        return this;
    }

    public String getAppCode() {
        return appCode;
    }

    public AuthorizationSubjectRequest setAppCode(String appCode) {
        this.appCode = appCode;
        return this;
    }

    public String getSubjectOrigin() {
        return subjectOrigin;
    }

    public AuthorizationSubjectRequest setSubjectOrigin(String subjectOrigin) {
        this.subjectOrigin = subjectOrigin;
        return this;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public AuthorizationSubjectRequest setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
        return this;
    }

    public AuthorizationSubject to() {
        return ObjectUtil.INSTANCE.copyProperties(this, AuthorizationSubject.class);
    }
}
