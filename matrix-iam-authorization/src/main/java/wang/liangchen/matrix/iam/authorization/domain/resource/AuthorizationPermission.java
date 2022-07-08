package wang.liangchen.matrix.iam.authorization.domain.resource;

import wang.liangchen.matrix.framework.commons.object.ObjectUtil;
import wang.liangchen.matrix.framework.commons.type.ClassUtil;
import wang.liangchen.matrix.framework.data.annotation.ColumnMarkDelete;
import wang.liangchen.matrix.framework.data.dao.entity.RootEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Liangchen.Wang
 */
@Entity(name = "matrix_authorization_permission")
@Table(name = "matrix_authorization_permission")
public class AuthorizationPermission extends RootEntity {
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
    @Column(name = "data_mode")
    private Short dataMode;
    @Version
    @Column(name = "version")
    private Integer version;
    @Column(name = "sort")
    private Integer sort;
    @Column(name = "owner")
    private String owner;
    @Column(name = "creator")
    private String creator;
    @Column(name = "create_datetime")
    private LocalDateTime createDatetime;
    @Column(name = "modifier")
    private String modifier;
    @Column(name = "modify_datetime")
    private LocalDateTime modifyDatetime;
    @Column(name = "summary")
    private String summary;
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
    public Short getDataMode() {
        return this.dataMode;
    }
    public void setDataMode(Short dataMode) {
        this.dataMode = dataMode;
    }
    public Integer getVersion() {
        return this.version;
    }
    public void setVersion(Integer version) {
        this.version = version;
    }
    public Integer getSort() {
        return this.sort;
    }
    public void setSort(Integer sort) {
        this.sort = sort;
    }
    public String getOwner() {
        return this.owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public String getCreator() {
        return this.creator;
    }
    public void setCreator(String creator) {
        this.creator = creator;
    }
    public LocalDateTime getCreateDatetime() {
        return this.createDatetime;
    }
    public void setCreateDatetime(LocalDateTime createDatetime) {
        this.createDatetime = createDatetime;
    }
    public String getModifier() {
        return this.modifier;
    }
    public void setModifier(String modifier) {
        this.modifier = modifier;
    }
    public LocalDateTime getModifyDatetime() {
        return this.modifyDatetime;
    }
    public void setModifyDatetime(LocalDateTime modifyDatetime) {
        this.modifyDatetime = modifyDatetime;
    }
    public String getSummary() {
        return this.summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
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
        builder.append("dataMode = ").append(dataMode).append(", ");
        builder.append("version = ").append(version).append(", ");
        builder.append("sort = ").append(sort).append(", ");
        builder.append("owner = ").append(owner).append(", ");
        builder.append("creator = ").append(creator).append(", ");
        builder.append("createDatetime = ").append(createDatetime).append(", ");
        builder.append("modifier = ").append(modifier).append(", ");
        builder.append("modifyDatetime = ").append(modifyDatetime).append(", ");
        builder.append("summary = ").append(summary).append(", ");
        builder.append("state = ").append(state).append(", ");
        builder.deleteCharAt(builder.length() - 1);
        builder.append("}");
        return builder.toString();
    }
}