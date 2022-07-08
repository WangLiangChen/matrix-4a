package wang.liangchen.matrix.iam.authorization.domain.role;

import wang.liangchen.matrix.framework.commons.object.ObjectUtil;
import wang.liangchen.matrix.framework.commons.type.ClassUtil;
import wang.liangchen.matrix.framework.data.annotation.ColumnMarkDelete;
import wang.liangchen.matrix.framework.data.dao.entity.CommonEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Liangchen.Wang
 */
@Entity(name = "matrix_authorization_roleset")
@Table(name = "matrix_authorization_roleset")
public class AuthorizationRoleset extends CommonEntity {
    @Id
    @Column(name = "roleset_id")
    private Long rolesetId;
    @Column(name = "tenant_code")
    private String tenantCode;
    @Column(name = "app_code")
    private String appCode;
    @Column(name = "roleset_name")
    private String rolesetName;
    @ColumnMarkDelete("deleted")
    @Column(name = "state")
    private String state;

    public static AuthorizationRoleset valueOf(Object source) {
        return ObjectUtil.INSTANCE.copyProperties(source, AuthorizationRoleset.class);
    }

    public static AuthorizationRoleset newInstance() {
        return ClassUtil.INSTANCE.instantiate(AuthorizationRoleset.class);
    }

    public Long getRolesetId() {
        return this.rolesetId;
    }
    public void setRolesetId(Long rolesetId) {
        this.rolesetId = rolesetId;
    }
    public String getTenantCode() {
        return this.tenantCode;
    }
    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }
    public String getAppCode() {
        return this.appCode;
    }
    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }
    public String getRolesetName() {
        return this.rolesetName;
    }
    public void setRolesetName(String rolesetName) {
        this.rolesetName = rolesetName;
    }
    public String getState() {
        return this.state;
    }
    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("AuthorizationRoleset{");
        builder.append("rolesetId = ").append(rolesetId).append(", ");
        builder.append("tenantCode = ").append(tenantCode).append(", ");
        builder.append("appCode = ").append(appCode).append(", ");
        builder.append("rolesetName = ").append(rolesetName).append(", ");
        builder.append("state = ").append(state).append(", ");
        builder.deleteCharAt(builder.length() - 1);
        builder.append("}");
        return builder.toString();
    }
}