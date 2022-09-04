/*==============================================================*/
/* Table: account                                               */
/*==============================================================*/
create table account (
   account_id           INT8                 not null,
   account_code         VARCHAR(60)          not null,
   account_name         VARCHAR(60)          not null,
   account_nickname     VARCHAR(60)          not null,
   account_avatar       VARCHAR(500)         not null,
   account_gender       VARCHAR(6)           not null,
   account_birthday     timestamp without time zone                 not null,
   account_country      VARCHAR(36)          not null,
   account_province     VARCHAR(36)          not null,
   account_city         VARCHAR(36)          not null,
   account_county       VARCHAR(36)          not null,
   account_expire       timestamp without time zone                 not null,
   extended_columus     VARCHAR(500)         not null,
   version              INT4                 not null default 0,
   owner                VARCHAR(60)          not null default '',
   creator              VARCHAR(60)          not null default '',
   create_datetime      timestamp without time zone                 not null,
   modifier             VARCHAR(60)          not null default '',
   modify_datetime      timestamp without time zone                 not null,
   summary              VARCHAR(200)         not null default '',
   state                VARCHAR(36)          not null,
   constraint PK_ACCOUNT primary key (account_id)
);

comment on table account is
'账户';

comment on column account.account_id is
'PrimaryKey';

comment on column account.account_code is
'账户标识 登录名';

comment on column account.account_name is
'名称';

comment on column account.account_nickname is
'昵称';

comment on column account.account_avatar is
'账户头像';

comment on column account.account_gender is
'性别male-男性;female-女性;none-未知;';

comment on column account.account_country is
'国家';

comment on column account.account_province is
'省';

comment on column account.account_city is
'市';

comment on column account.account_county is
'县';

comment on column account.account_expire is
'过期时间';

comment on column account.extended_columus is
'JSON格式扩展列';

comment on column account.version is
'版本号,可用于乐观锁';

comment on column account.owner is
'属主标识';

comment on column account.creator is
'创建者标识';

comment on column account.create_datetime is
'创建时间,长度6';

comment on column account.modifier is
'最后修改者标识';

comment on column account.modify_datetime is
'最后修改时间,长度6';

comment on column account.summary is
'简述说明';

comment on column account.state is
'状态';

/*==============================================================*/
/* Index: account_PK                                            */
/*==============================================================*/
create unique index account_PK on account (
account_id
);

/*==============================================================*/
/* Table: account_authentication                                */
/*==============================================================*/
create table account_authentication (
   account_id           INT8                 not null,
   account_code         VARCHAR(60)          not null,
   password             VARCHAR(100)         not null,
   password_salt        VARCHAR(100)         not null,
   password_algorithm   VARCHAR(10)          not null,
   password_expire      timestamp without time zone                 not null,
   mobile               VARCHAR(36)          not null,
   email                VARCHAR(100)         not null,
   version              INT4                 not null default 0,
   owner                VARCHAR(60)          not null default '',
   creator              VARCHAR(60)          not null default '',
   create_datetime      timestamp without time zone                 not null,
   modifier             VARCHAR(60)          not null default '',
   modify_datetime      timestamp without time zone                 not null,
   summary              VARCHAR(200)         not null default '',
   state                VARCHAR(36)          not null,
   constraint PK_ACCOUNT_AUTHENTICATION primary key (account_id)
);

comment on column account_authentication.account_id is
'PrimaryKey';

comment on column account_authentication.account_code is
'账户标识登录名';

comment on column account_authentication.password is
'密码方式登录密码';

comment on column account_authentication.password_salt is
'密码盐值或HMAC的key';

comment on column account_authentication.password_algorithm is
'密码算法';

comment on column account_authentication.password_expire is
'密码过期时间';

comment on column account_authentication.mobile is
'绑定手机号';

comment on column account_authentication.email is
'绑定邮箱';

comment on column account_authentication.version is
'版本号,可用于乐观锁';

comment on column account_authentication.owner is
'属主标识';

comment on column account_authentication.creator is
'创建者标识';

comment on column account_authentication.create_datetime is
'创建时间,长度6';

comment on column account_authentication.modifier is
'最后修改者标识';

comment on column account_authentication.modify_datetime is
'最后修改时间,长度6';

comment on column account_authentication.summary is
'简述说明';

comment on column account_authentication.state is
'状态';

/*==============================================================*/
/* Index: account_authentication_PK                             */
/*==============================================================*/
create unique index account_authentication_PK on account_authentication (
account_id
);
/*==============================================================*/
/* Table: authentication_subject                                */
/*==============================================================*/
create table authentication_subject (
   subject_id           INT8                 not null,
   account_id           INT8                 null,
   subject_code         VARCHAR(36)          not null,
   subject_source       VARCHAR(36)          not null,
   source_settings      VARCHAR(500)         not null,
   subject_datas        VARCHAR(500)         not null,
   version              INT4                 not null default 0,
   owner                VARCHAR(60)          not null default '',
   creator              VARCHAR(60)          not null default '',
   create_datetime      timestamp without time zone                 not null,
   modifier             VARCHAR(60)          not null default '',
   modify_datetime      timestamp without time zone                 not null,
   summary              VARCHAR(200)         not null default '',
   state                VARCHAR(36)          not null,
   constraint PK_AUTHENTICATION_SUBJECT primary key (subject_id)
);

comment on column authentication_subject.account_id is
'PrimaryKey';

comment on column authentication_subject.subject_code is
'认证主体标识';

comment on column authentication_subject.subject_source is
'认证主体来源';

comment on column authentication_subject.source_settings is
'认证主体来源配置快照';

comment on column authentication_subject.subject_datas is
'认证主体信息JSON格式';

comment on column authentication_subject.version is
'版本号,可用于乐观锁';

comment on column authentication_subject.owner is
'属主标识';

comment on column authentication_subject.creator is
'创建者标识';

comment on column authentication_subject.create_datetime is
'创建时间,长度6';

comment on column authentication_subject.modifier is
'最后修改者标识';

comment on column authentication_subject.modify_datetime is
'最后修改时间,长度6';

comment on column authentication_subject.summary is
'简述说明';

comment on column authentication_subject.state is
'状态';

/*==============================================================*/
/* Index: authentication_subject_PK                             */
/*==============================================================*/
create unique index authentication_subject_PK on authentication_subject (
subject_id
);

/*==============================================================*/
/* Index: accout_subjejct_FK                                    */
/*==============================================================*/
create  index accout_subjejct_FK on authentication_subject (
account_id
);
/*==============================================================*/
/* Table: authentication_consumer                               */
/*==============================================================*/
create table authentication_consumer (
   consumer_id          INT8                 not null,
   tenant_code          VARCHAR(36)          not null,
   consumer_code        VARCHAR(36)          not null,
   consumer_name        VARCHAR(36)          not null,
   consumer_secret      VARCHAR(36)          not null,
   authentication_methods VARCHAR(36)          not null,
   authorization_types  VARCHAR(36)          not null,
   authorization_scopes VARCHAR(100)         not null,
   redirect_uris        VARCHAR(500)         not null,
   token_algorithm      VARCHAR(10)          not null,
   token_secret         VARCHAR(36)          not null,
   token_private        VARCHAR(1000)        not null,
   token_public         VARCHAR(1000)        not null,
   authorization_code_duration INT4                 not null,
   oidc_token_duration  INT4                 not null,
   access_token_duration INT4                 not null,
   refresh_token_duration INT4                 not null,
   consumer_settings    VARCHAR(1000)        not null,
   version              INT4                 not null default 0,
   owner                VARCHAR(60)          not null default '',
   creator              VARCHAR(60)          not null default '',
   create_datetime      timestamp without time zone                 not null,
   modifier             VARCHAR(60)          not null default '',
   modify_datetime      timestamp without time zone                 not null,
   summary              VARCHAR(200)         not null default '',
   state                VARCHAR(36)          not null,
   constraint PK_AUTHENTICATION_CONSUMER primary key (consumer_id)
);

comment on table authentication_consumer is
'认证服务消费者及配置';

comment on column authentication_consumer.consumer_id is
'Primarykey';

comment on column authentication_consumer.consumer_name is
'名称';

comment on column authentication_consumer.consumer_secret is
'用于consumer认证的密钥';

comment on column authentication_consumer.authentication_methods is
'用于consumer认证的方法如client_secret_basic';

comment on column authentication_consumer.authorization_types is
'授权类型authorization_code;refresh_token;client_credentials等';

comment on column authentication_consumer.authorization_scopes is
'授权范围';

comment on column authentication_consumer.redirect_uris is
'授权后的回调地址';

comment on column authentication_consumer.token_algorithm is
'jwt签名验签算法';

comment on column authentication_consumer.token_secret is
'jwt签名验签密钥（对称加密）';

comment on column authentication_consumer.token_private is
'jwt签名私钥(非对称加密)';

comment on column authentication_consumer.token_public is
'jwt验签公钥(非对称加密)';

comment on column authentication_consumer.authorization_code_duration is
'授权码有效期,单位s';

comment on column authentication_consumer.oidc_token_duration is
'oidc id-token有效期';

comment on column authentication_consumer.access_token_duration is
'access-token有效期';

comment on column authentication_consumer.refresh_token_duration is
'refresh-token有效期';

comment on column authentication_consumer.consumer_settings is
'Json字符串，使用@class来标识对应的类';

comment on column authentication_consumer.version is
'版本号,可用于乐观锁';

comment on column authentication_consumer.owner is
'属主标识';

comment on column authentication_consumer.creator is
'创建者标识';

comment on column authentication_consumer.create_datetime is
'创建时间,长度6';

comment on column authentication_consumer.modifier is
'最后修改者标识';

comment on column authentication_consumer.modify_datetime is
'最后修改时间,长度6';

comment on column authentication_consumer.summary is
'简述说明';

comment on column authentication_consumer.state is
'状态';

/*==============================================================*/
/* Index: authentication_consumer_PK                            */
/*==============================================================*/
create unique index authentication_consumer_PK on authentication_consumer (
consumer_id
);
/*==============================================================*/
/* Table: authentication_oauth2                                 */
/*==============================================================*/
create table authentication_oauth2 (
   oauth2_id            INT8                 not null,
   consumer_id          INT8                 null,
   account_id           INT8                 null,
   principal_name       VARCHAR(36)          not null,
   authorization_types  VARCHAR(36)          not null,
   authorization_scopes VARCHAR(100)         not null,
   original_state       VARCHAR(500)         not null,
   authorization_code   VARCHAR(500)         not null,
   authorization_code_issue timestamp without time zone                 not null,
   authorization_code_expire timestamp without time zone                 not null,
   oidc_token           VARCHAR(500)         not null,
   oidc_token_issue     timestamp without time zone                 not null,
   oidc_token_expire    timestamp without time zone                 not null,
   access_token         VARCHAR(500)         not null,
   access_token_issue   timestamp without time zone                 not null,
   access_token_expire  timestamp without time zone                 not null,
   refresh_token        VARCHAR(500)         not null,
   refresh_token_issue  timestamp without time zone                 not null,
   refresh_token_expire timestamp without time zone                 not null,
   version              INT4                 not null default 0,
   owner                VARCHAR(60)          not null default '',
   creator              VARCHAR(60)          not null default '',
   create_datetime      timestamp without time zone                 not null,
   modifier             VARCHAR(60)          not null default '',
   modify_datetime      timestamp without time zone                 not null,
   summary              VARCHAR(200)         not null default '',
   state                VARCHAR(36)          not null,
   constraint PK_AUTHENTICATION_OAUTH2 primary key (oauth2_id)
);

comment on table authentication_oauth2 is
'oidc认证授权';

comment on column authentication_oauth2.consumer_id is
'Primarykey';

comment on column authentication_oauth2.account_id is
'PrimaryKey';

comment on column authentication_oauth2.principal_name is
'授权主体全名称';

comment on column authentication_oauth2.authorization_types is
'授权类型authorization_code;refresh_token;client_credentials等';

comment on column authentication_oauth2.authorization_scopes is
'授权范围';

comment on column authentication_oauth2.original_state is
'通过URI传递的state,原样返回';

comment on column authentication_oauth2.authorization_code is
'authorization_code';

comment on column authentication_oauth2.authorization_code_issue is
'颁发时间';

comment on column authentication_oauth2.authorization_code_expire is
'过期时间';

comment on column authentication_oauth2.oidc_token is
'oidc_token id_token';

comment on column authentication_oauth2.oidc_token_issue is
'颁发时间';

comment on column authentication_oauth2.oidc_token_expire is
'过期时间';

comment on column authentication_oauth2.access_token is
'access_token';

comment on column authentication_oauth2.access_token_issue is
'颁发时间';

comment on column authentication_oauth2.access_token_expire is
'过期时间';

comment on column authentication_oauth2.refresh_token is
'refresh_token';

comment on column authentication_oauth2.refresh_token_issue is
'颁发时间';

comment on column authentication_oauth2.refresh_token_expire is
'过期时间';

comment on column authentication_oauth2.version is
'版本号,可用于乐观锁';

comment on column authentication_oauth2.owner is
'属主标识';

comment on column authentication_oauth2.creator is
'创建者标识';

comment on column authentication_oauth2.create_datetime is
'创建时间,长度6';

comment on column authentication_oauth2.modifier is
'最后修改者标识';

comment on column authentication_oauth2.modify_datetime is
'最后修改时间,长度6';

comment on column authentication_oauth2.summary is
'简述说明';

comment on column authentication_oauth2.state is
'状态';

/*==============================================================*/
/* Index: authentication_oauth2_PK                              */
/*==============================================================*/
create unique index authentication_oauth2_PK on authentication_oauth2 (
oauth2_id
);

/*==============================================================*/
/* Index: consumer_oauth2_FK                                    */
/*==============================================================*/
create  index consumer_oauth2_FK on authentication_oauth2 (
consumer_id
);

/*==============================================================*/
/* Index: account_oauth2_FK                                     */
/*==============================================================*/
create  index account_oauth2_FK on authentication_oauth2 (
account_id
);