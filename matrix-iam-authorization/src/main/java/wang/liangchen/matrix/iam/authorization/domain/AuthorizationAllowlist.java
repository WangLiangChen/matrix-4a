package wang.liangchen.matrix.iam.authorization.domain;

import wang.liangchen.matrix.framework.commons.object.ObjectUtil;
import wang.liangchen.matrix.framework.commons.type.ClassUtil;
import wang.liangchen.matrix.framework.data.annotation.ColumnMarkDelete;
import wang.liangchen.matrix.framework.data.dao.entity.CommonEntity;
import wang.liangchen.matrix.framework.ddd.domain.AggregateRoot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Liangchen.Wang
 */
@Entity(name = "matrix_authorization_allowlist")
@Table(name = "matrix_authorization_allowlist")
@AggregateRoot
public class AuthorizationAllowlist extends CommonEntity {
    @Id
    @Column(name = "allowlist_id")
    private Long allowlistId;
    @Column(name = "tenant_code")
    private String tenantCode;
    @Column(name = "app_code")
    private String appCode;
    @Column(name = "permission_uri")
    private String permissionUri;
    @ColumnMarkDelete("deleted")
    @Column(name = "state")
    private String state;

    public static AuthorizationAllowlist valueOf(Object source) {
        return ObjectUtil.INSTANCE.copyProperties(source, AuthorizationAllowlist.class);
    }

    public static AuthorizationAllowlist newInstance() {
        return ClassUtil.INSTANCE.instantiate(AuthorizationAllowlist.class);
    }

    public Long getAllowlistId() {
        return this.allowlistId;
    }
    public void setAllowlistId(Long allowlistId) {
        this.allowlistId = allowlistId;
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
    public String getPermissionUri() {
        return this.permissionUri;
    }
    public void setPermissionUri(String permissionUri) {
        this.permissionUri = permissionUri;
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
        builder.append("AuthorizationAllowlist{");
        builder.append("allowlistId = ").append(allowlistId).append(", ");
        builder.append("tenantCode = ").append(tenantCode).append(", ");
        builder.append("appCode = ").append(appCode).append(", ");
        builder.append("permissionUri = ").append(permissionUri).append(", ");
        builder.append("state = ").append(state).append(", ");
        builder.deleteCharAt(builder.length() - 1);
        builder.append("}");
        return builder.toString();
    }
}