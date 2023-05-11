--liquibase formatted sql

--changeset krasilovaa:create_table_userprofile rollbackSplitStatements:true
--comment: Создание таблицы профилей пользователей

CREATE TABLE USER_PROFILE
(
    ID          VARCHAR(36) PRIMARY KEY,
    FIRST_NAME   VARCHAR(128) NOT NULL,
    LAST_NAME    VARCHAR(128) NOT NULL,
    EMAIL       VARCHAR(128),
    PHONE       VARCHAR(36),
    TELEGRAM_ID VARCHAR(36)
);

COMMENT
ON TABLE USER_PROFILE IS 'Профили пользователей';
COMMENT ON COLUMN USER_PROFILE.ID IS 'Id пользователя';
COMMENT ON COLUMN USER_PROFILE.FIRST_NAME IS 'Имя пользователя';
COMMENT ON COLUMN USER_PROFILE.LAST_NAME IS 'Фамилия пользователя';
COMMENT ON COLUMN USER_PROFILE.EMAIL IS 'Email пользователя';
COMMENT ON COLUMN USER_PROFILE.PHONE IS 'Телефон пользователя';
COMMENT ON COLUMN USER_PROFILE.TELEGRAM_ID IS 'Телеграм id пользователя';

--rollback DROP TABLE USER_PROFILE;