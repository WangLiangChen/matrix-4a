package wang.liangchen.matrix.iam.authorization.domain;

import wang.liangchen.matrix.framework.data.annotation.ColumnMarkDelete;
import wang.liangchen.matrix.framework.data.dao.entity.RootEntity;

import javax.persistence.*;

/**
 * @author Liangchen.Wang
 */
@Entity(name = "matrix_authorization_subject")
@Table(name = "matrix_authorization_subject")
public class AuthorizationSubject extends RootEntity {
    @Id
    @Column(name = "subject_id")
    private Long subjectId;

    @Column(name = "tenant_code")
    private String tenantCode;

    @Column(name = "app_code")
    private String appCode;

    @Column(name = "subject_origin")
    private String subjectOrigin;

    @Column(name = "subject_code")
    private String subjectCode;

    @Column(name = "data_mode")
    private Byte dataMode;

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
    private java.time.LocalDateTime createDatetime;

    @Column(name = "modifier")
    private String modifier;

    @Column(name = "modify_datetime")
    private java.time.LocalDateTime modifyDatetime;

    @Column(name = "summary")
    private String summary;

    @ColumnMarkDelete("deleted")
    @Column(name = "state")
    private String state;


    public Long getSubjectId() {
        return this.subjectId;
    }

    public AuthorizationSubject setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
        return this;
    }

    public String getTenantCode() {
        return this.tenantCode;
    }

    public AuthorizationSubject setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
        return this;
    }

    public String getAppCode() {
        return this.appCode;
    }

    public AuthorizationSubject setAppCode(String appCode) {
        this.appCode = appCode;
        return this;
    }

    public String getSubjectOrigin() {
        return this.subjectOrigin;
    }

    public AuthorizationSubject setSubjectOrigin(String subjectOrigin) {
        this.subjectOrigin = subjectOrigin;
        return this;
    }

    public String getSubjectCode() {
        return this.subjectCode;
    }

    public AuthorizationSubject setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
        return this;
    }

    public Byte getDataMode() {
        return this.dataMode;
    }

    public AuthorizationSubject setDataMode(Byte dataMode) {
        this.dataMode = dataMode;
        return this;
    }

    public Integer getVersion() {
        return this.version;
    }

    public AuthorizationSubject setVersion(Integer version) {
        this.version = version;
        return this;
    }

    public Integer getSort() {
        return this.sort;
    }

    public AuthorizationSubject setSort(Integer sort) {
        this.sort = sort;
        return this;
    }

    public String getOwner() {
        return this.owner;
    }

    public AuthorizationSubject setOwner(String owner) {
        this.owner = owner;
        return this;
    }

    public String getCreator() {
        return this.creator;
    }

    public AuthorizationSubject setCreator(String creator) {
        this.creator = creator;
        return this;
    }

    public java.time.LocalDateTime getCreateDatetime() {
        return this.createDatetime;
    }

    public AuthorizationSubject setCreateDatetime(java.time.LocalDateTime createDatetime) {
        this.createDatetime = createDatetime;
        return this;
    }

    public String getModifier() {
        return this.modifier;
    }

    public AuthorizationSubject setModifier(String modifier) {
        this.modifier = modifier;
        return this;
    }

    public java.time.LocalDateTime getModifyDatetime() {
        return this.modifyDatetime;
    }

    public AuthorizationSubject setModifyDatetime(java.time.LocalDateTime modifyDatetime) {
        this.modifyDatetime = modifyDatetime;
        return this;
    }

    public String getSummary() {
        return this.summary;
    }

    public AuthorizationSubject setSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public String getState() {
        return this.state;
    }

    public AuthorizationSubject setState(String state) {
        this.state = state;
        return this;
    }
}