package wang.liangchen.matrix.iam.authorization.domain.resource;

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
@Entity(name = "matrix_authorization_permission")
@Table(name = "matrix_authorization_permission")
public class AuthorizationPermission extends CommonEntity {
    @Id
    @Column(name = "permission_id")
    private Long permissionId;
    @Column(name = "resource_id")
    private Long resourceId;
    @Column(name = "operation_id")
    private Long operationId;
    @Column(name = "role_id")
    private Long roleId;
    @Column(name = "tenant_code")
    private String tenantCode;
    @Column(name = "app_code")
    private String appCode;
    @Column(name = "permission_code")
    private String permissionCode;
    @Column(name = "permission_name")
    private String permissionName;
    @Column(name = "perimission_dependency")
    private String perimissionDependency;
    @Column(name = "permission_uri")
    private String permissionUri;
    @Column(name = "permission_label")
    private String permissionLabel;
    @Column(name = "permission_rule")
    private String permissionRule;
    @ColumnMarkDelete("deleted")
    @Column(name = "state")
    private String state;

    public static AuthorizationPermission valueOf(Object source) {
        return ObjectUtil.INSTANCE.copyProperties(source, AuthorizationPermission.class);
    }

    public static AuthorizationPermission newInstance() {
        return ClassUtil.INSTANCE.instantiate(AuthorizationPermission.class);
    }

    public Long getPermissionId() {
        return this.permissionId;
    }
    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
    public Long getResourceId() {
        return this.resourceId;
    }
    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }
    public Long getOperationId() {
        return this.operationId;
    }
    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }
    public Long getRoleId() {
        return this.roleId;
    }
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
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
    public String getPermissionCode() {
        return this.permissionCode;
    }
    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }
    public String getPermissionName() {
        return this.permissionName;
    }
    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }
    public String getPerimissionDependency() {
        return this.perimissionDependency;
    }
    public void setPerimissionDependency(String perimissionDependency) {
        this.perimissionDependency = perimissionDependency;
    }
    public String getPermissionUri() {
        return this.permissionUri;
    }
    public void setPermissionUri(String permissionUri) {
        this.permissionUri = permissionUri;
    }
    public String getPermissionLabel() {
        return this.permissionLabel;
    }
    public void setPermissionLabel(String permissionLabel) {
        this.permissionLabel = permissionLabel;
    }
    public String getPermissionRule() {
        return this.permissionRule;
    }
    public void setPermissionRule(String permissionRule) {
        this.permissionRule = permissionRule;
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
        builder.append("AuthorizationPermission{");
        builder.append("permissionId = ").append(permissionId).append(", ");
        builder.append("resourceId = ").append(resourceId).append(", ");
        builder.append("operationId = ").append(operationId).append(", ");
        builder.append("roleId = ").append(roleId).append(", ");
        builder.append("tenantCode = ").append(tenantCode).append(", ");
        builder.append("appCode = ").append(appCode).append(", ");
        builder.append("permissionCode = ").append(permissionCode).append(", ");
        builder.append("permissionName = ").append(permissionName).append(", ");
        builder.append("perimissionDependency = ").append(perimissionDependency).append(", ");
        builder.append("permissionUri = ").append(permissionUri).append(", ");
        builder.append("permissionLabel = ").append(permissionLabel).append(", ");
        builder.append("permissionRule = ").append(permissionRule).append(", ");
        builder.append("state = ").append(state).append(", ");
        builder.deleteCharAt(builder.length() - 1);
        builder.append("}");
        return builder.toString();
    }
}