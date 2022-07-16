package wang.liangchen.matrix.iam.authorization.domain.group;

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
@Entity(name = "matrix_authorization_group")
@Table(name = "matrix_authorization_group")
@AggregateRoot
public class AuthorizationGroup extends CommonEntity {
    @Id
    @Column(name = "group_id")
    private Long groupId;
    @Column(name = "parent_id")
    private Long parentId;
    @Column(name = "tenant_code")
    private String tenantCode;
    @Column(name = "app_code")
    private String appCode;
    @Column(name = "group_code")
    private String groupCode;
    @Column(name = "group_name")
    private String groupName;
    @ColumnMarkDelete("deleted")
    @Column(name = "state")
    private String state;

    public static AuthorizationGroup valueOf(Object source) {
        return ObjectUtil.INSTANCE.copyProperties(source, AuthorizationGroup.class);
    }

    public static AuthorizationGroup newInstance() {
        return ClassUtil.INSTANCE.instantiate(AuthorizationGroup.class);
    }

    public Long getGroupId() {
        return this.groupId;
    }
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
    public Long getParentId() {
        return this.parentId;
    }
    public void setParentId(Long parentId) {
        this.parentId = parentId;
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
    public String getGroupCode() {
        return this.groupCode;
    }
    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }
    public String getGroupName() {
        return this.groupName;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
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
        builder.append("AuthorizationGroup{");
        builder.append("groupId = ").append(groupId).append(", ");
        builder.append("parentId = ").append(parentId).append(", ");
        builder.append("tenantCode = ").append(tenantCode).append(", ");
        builder.append("appCode = ").append(appCode).append(", ");
        builder.append("groupCode = ").append(groupCode).append(", ");
        builder.append("groupName = ").append(groupName).append(", ");
        builder.append("state = ").append(state).append(", ");
        builder.deleteCharAt(builder.length() - 1);
        builder.append("}");
        return builder.toString();
    }
}