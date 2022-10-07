/*==============================================================*/
/* Table: platform_service                                      */
/*==============================================================*/
create table platform_service
(
    service_id       INT8          not null,
    tenant_id        INT8 null,
    category_id      INT8 null,
    tenant_code      VARCHAR(36)   not null,
    service_code     VARCHAR(36)   not null,
    service_name     VARCHAR(36)   not null,
    service_type     VARCHAR(20)   not null,
    frontend_uri     VARCHAR(100)  not null,
    backend_uri      VARCHAR(100)  not null,
    service_uri      VARCHAR(100)  not null,
    service_logo     VARCHAR(1000) not null,
    service_theme    VARCHAR(36)   not null,
    service_lang     VARCHAR(100)  not null,
    service_document VARCHAR(100)  not null,
    version          INT4          not null default 0,
    owner            VARCHAR(60)   not null default '',
    creator          VARCHAR(60)   not null default '',
    create_datetime  TIMESTAMP     not null,
    modifier         VARCHAR(60)   not null default '',
    modify_datetime  TIMESTAMP     not null,
    summary          VARCHAR(200)  not null default '',
    state            VARCHAR(36)   not null,
    constraint PK_PLATFORM_SERVICE primary key (service_id)
);

comment
on table platform_service is
'服务';

comment
on column platform_service.service_id is
'service_id';

comment
on column platform_service.tenant_id is
'tenant_id';

comment
on column platform_service.tenant_code is
'tenant_code';

comment
on column platform_service.service_code is
'service_code';

comment
on column platform_service.service_name is
'service_name';

comment
on column platform_service.service_type is
'PaaS;SaaS;App';

comment
on column platform_service.frontend_uri is
'管理前端URI';

comment
on column platform_service.backend_uri is
'管理后端URI';

comment
on column platform_service.service_uri is
'服务URI';

comment
on column platform_service.service_theme is
'服务支持的主题标识';

comment
on column platform_service.service_lang is
'服务支持的语言zh_CN;en_US';

comment
on column platform_service.service_document is
'服务帮助文档URI';

comment
on column platform_service.version is
'版本号,可用于乐观锁';

comment
on column platform_service.owner is
'属主标识';

comment
on column platform_service.creator is
'创建者标识';

comment
on column platform_service.create_datetime is
'创建时间,长度6';

comment
on column platform_service.modifier is
'最后修改者标识';

comment
on column platform_service.modify_datetime is
'最后修改时间,长度6';

comment
on column platform_service.summary is
'简述说明';

comment
on column platform_service.state is
'状态';

/*==============================================================*/
/* Index: platform_service_PK                                   */
/*==============================================================*/
create unique index platform_service_PK on platform_service (
                                                             service_id
    );

/*==============================================================*/
/* Index: category_service_FK                                   */
/*==============================================================*/
create index category_service_FK on platform_service (
                                                      category_id
    );

/*==============================================================*/
/* Index: tenant_service_FK                                     */
/*==============================================================*/
create index tenant_service_FK on platform_service (
                                                    tenant_id
    );

/*==============================================================*/
/* Table: platform_service_category                             */
/*==============================================================*/
create table platform_service_category
(
    category_id     INT8         not null,
    parent_id       INT8 null,
    category_name   VARCHAR(36)  not null,
    version         INT4         not null default 0,
    owner           VARCHAR(60)  not null default '',
    creator         VARCHAR(60)  not null default '',
    create_datetime TIMESTAMP    not null,
    modifier        VARCHAR(60)  not null default '',
    modify_datetime TIMESTAMP    not null,
    summary         VARCHAR(200) not null default '',
    state           VARCHAR(36)  not null,
    constraint PK_PLATFORM_SERVICE_CATEGORY primary key (category_id)
);

comment
on table platform_service_category is
'服务分类';

comment
on column platform_service_category.version is
'版本号,可用于乐观锁';

comment
on column platform_service_category.owner is
'属主标识';

comment
on column platform_service_category.creator is
'创建者标识';

comment
on column platform_service_category.create_datetime is
'创建时间,长度6';

comment
on column platform_service_category.modifier is
'最后修改者标识';

comment
on column platform_service_category.modify_datetime is
'最后修改时间,长度6';

comment
on column platform_service_category.summary is
'简述说明';

comment
on column platform_service_category.state is
'状态';

/*==============================================================*/
/* Index: platform_service_category_PK                          */
/*==============================================================*/
create unique index platform_service_category_PK on platform_service_category (
                                                                               category_id
    );

/*==============================================================*/
/* Index: service_category_self_FK                              */
/*==============================================================*/
create index service_category_self_FK on platform_service_category (
                                                                    parent_id
    );

/*==============================================================*/
/* Table: platform_subscription                                 */
/*==============================================================*/
create table platform_subscription
(
    subscription_id INT8         not null,
    provider_id     INT8 null,
    consumer_id     INT8 null,
    provider_tenant VARCHAR(36)  not null,
    provider_code   VARCHAR(36)  not null,
    consumer_tenant VARCHAR(36)  not null,
    consumer_code   VARCHAR(36)  not null,
    algorithm       VARCHAR(36)  not null,
    secret          VARCHAR(64)  not null,
    version         INT4         not null default 0,
    owner           VARCHAR(60)  not null default '',
    creator         VARCHAR(60)  not null default '',
    create_datetime TIMESTAMP    not null,
    modifier        VARCHAR(60)  not null default '',
    modify_datetime TIMESTAMP    not null,
    summary         VARCHAR(200) not null default '',
    state           VARCHAR(36)  not null,
    constraint PK_PLATFORM_SUBSCRIPTION primary key (subscription_id)
);

comment
on table platform_subscription is
'服务订阅关系';

comment
on column platform_subscription.provider_id is
'service_id';

comment
on column platform_subscription.consumer_id is
'service_id';

comment
on column platform_subscription.provider_tenant is
'提供方tenant_code';

comment
on column platform_subscription.provider_code is
'提供方code';

comment
on column platform_subscription.consumer_tenant is
'消费方tenant_code';

comment
on column platform_subscription.consumer_code is
'消费方code,当provider为SaaS时,此列为空串';

comment
on column platform_subscription.algorithm is
'签名验签算法,当provider为SaaS时,此列为空串';

comment
on column platform_subscription.secret is
'HMAC的key,当provider为SaaS时,此列为空串';

comment
on column platform_subscription.version is
'版本号,可用于乐观锁';

comment
on column platform_subscription.owner is
'属主标识';

comment
on column platform_subscription.creator is
'创建者标识';

comment
on column platform_subscription.create_datetime is
'创建时间,长度6';

comment
on column platform_subscription.modifier is
'最后修改者标识';

comment
on column platform_subscription.modify_datetime is
'最后修改时间,长度6';

comment
on column platform_subscription.summary is
'简述说明';

comment
on column platform_subscription.state is
'状态';

/*==============================================================*/
/* Index: platform_subscription_PK                              */
/*==============================================================*/
create unique index platform_subscription_PK on platform_subscription (
                                                                       subscription_id
    );

/*==============================================================*/
/* Index: provider_id_FK                                        */
/*==============================================================*/
create index provider_id_FK on platform_subscription (
                                                      provider_id
    );

/*==============================================================*/
/* Index: consumer_id_FK                                        */
/*==============================================================*/
create index consumer_id_FK on platform_subscription (
                                                      consumer_id
    );

/*==============================================================*/
/* Table: platform_tenant                                       */
/*==============================================================*/
create table platform_tenant
(
    tenant_id       INT8         not null,
    service_id      INT8 null,
    tenant_code     VARCHAR(36)  not null,
    tenant_name     VARCHAR(36)  not null,
    tenant_type     VARCHAR(20)  not null,
    version         INT4         not null default 0,
    owner           VARCHAR(60)  not null default '',
    creator         VARCHAR(60)  not null default '',
    create_datetime TIMESTAMP    not null,
    modifier        VARCHAR(60)  not null default '',
    modify_datetime TIMESTAMP    not null,
    summary         VARCHAR(200) not null default '',
    state           VARCHAR(36)  not null,
    constraint PK_PLATFORM_TENANT primary key (tenant_id),
    constraint AK_TENANT_CODE_PLATFORM unique (tenant_code)
);

comment
on table platform_tenant is
'租户';

comment
on column platform_tenant.tenant_id is
'tenant_id';

comment
on column platform_tenant.service_id is
'service_id';

comment
on column platform_tenant.tenant_code is
'tenant_code';

comment
on column platform_tenant.tenant_name is
'tenant_name';

comment
on column platform_tenant.tenant_type is
'PLATFORM("平台租户");SERVICE(“服务租户”)';

comment
on column platform_tenant.version is
'版本号,可用于乐观锁';

comment
on column platform_tenant.owner is
'属主标识';

comment
on column platform_tenant.creator is
'创建者标识';

comment
on column platform_tenant.create_datetime is
'创建时间,长度6';

comment
on column platform_tenant.modifier is
'最后修改者标识';

comment
on column platform_tenant.modify_datetime is
'最后修改时间,长度6';

comment
on column platform_tenant.summary is
'简述说明';

comment
on column platform_tenant.state is
'状态';

/*==============================================================*/
/* Index: platform_tenant_PK                                    */
/*==============================================================*/
create unique index platform_tenant_PK on platform_tenant (
                                                           tenant_id
    );

/*==============================================================*/
/* Index: service_tenant_FK                                     */
/*==============================================================*/
create index service_tenant_FK on platform_tenant (
                                                   service_id
    );
