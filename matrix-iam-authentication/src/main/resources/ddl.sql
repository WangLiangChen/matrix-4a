/*==============================================================*/
/* Authentication
/*==============================================================*/

/*==============================================================*/
/* Table: matrix_authentication_subject,认证主体
/*==============================================================*/
create table if not exists matrix_authentication_subject
(
    subject_id           bigint not null  comment '认证主体主键',
    tenant_code          varchar(36) not null  comment '所属租户标识代码',
    app_code             varchar(36) not null  comment '所属租户应用标识代码',

    login_name           varchar(36) not null  comment '登录名全局唯一',
    login_mobile         varchar(16) not null  comment '登录手机号全局唯一',
    login_email          varchar(36) not null  comment '登录邮箱全局唯一',

    password_algorithm   varchar(10) not null  comment '加密密码的算法',
    password_salt        varchar(36) not null  comment '加密密码的盐',
    password             varchar(100) not null  comment '登录密码',

    jwt_algorithm        varchar(10) not null  comment 'jwt签名算法',
    public_key           varchar(100) not null  comment 'jwt验签公钥',
    private_key          varchar(100) not null  comment 'jwt签名私钥',

    subject_expired      datetime(6) not null  comment '认证主体失效时间',
    password_expired     datetime(6) not null  comment '密码失效时间',

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
) comment '帐户基本信息及帐户密码登录配置信息';