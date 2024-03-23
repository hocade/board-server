create table USER
(
    ID                    bigint auto_increment
        primary key,
    EMAIL                 varchar(50) not null,
    NICK_NAME             varchar(50) not null,
    PASSWORD              varchar(50) not null,
    PHONE_COUNTRY_CODE    varchar(50) null,
    PHONE_NATIONAL_NUMBER varchar(50) null,
    UNIQUE_CODE           varchar(50) null
);

create table ROLE
(
    ID   bigint auto_increment
        primary key,
    NAME varchar(50) not null,
    TYPE varchar(50) not null
);

create table USER_ROLES
(
    USER_ID bigint null,
    ROLE_ID bigint null,
    constraint USER_ROLES_ROLE_ID_fk
        foreign key (ROLE_ID) references ROLE (ID),
    constraint USER_ROLES_USER_ID_fk
        foreign key (USER_ID) references USER (ID)
);

