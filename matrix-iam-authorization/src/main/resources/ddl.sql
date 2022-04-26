/*==============================================================*/
/* Authorization
/*==============================================================*/

/*==============================================================*/
/* Table: matrix_authorization_subject,授权主体
/*==============================================================*/
create table if not exists matrix_authorization_subject
(
    subject_id           bigint not null  comment '授权主体主键',
    tenant_code          varchar(36) not null  comment '所属租户标识代码',
    app_code             varchar(36) not null  comment '所属租户应用标识代码',

    subject_origin       varchar(36) not null  comment '授权主体来源，标识来源于哪个认证系统',
    subject_code         varchar(36) not null  comment '授权主体代号，在来源认证系统的登录名',

    data_mode            tinyint not null  comment '数据本身的权限模式',
    version              int not null  comment '用于乐观锁的版本号',
    sort                 int not null  comment '默认排序',
    owner                varchar(36) not null  comment '数据属主',
    creator              varchar(36) not null  comment '创建人',
    create_datetime      datetime(6) not null  comment '创建时间',
    modifier             varchar(36) not null  comment '修改人',
    modify_datetime      datetime(6) not null  comment '修改时间',
    summary              varchar(200) not null  comment '数据简述',
    state                varchar(20) not null  comment '数据状态',
    primary key (subject_id)
) comment '授权主体信息';