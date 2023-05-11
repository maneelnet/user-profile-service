DO
$do$
BEGIN
   IF NOT EXISTS (SELECT FROM pg_roles WHERE  rolname = 'user_profile_db_admin') THEN
      CREATE USER user_profile_db_admin NOCREATEDB CREATEROLE NOSUPERUSER PASSWORD 'user_profile_db_admin';
END IF;
END
$do$;

DO
$do$
BEGIN
   IF NOT EXISTS ( SELECT FROM pg_roles WHERE  rolname = 'user_profile_db_client') THEN
      CREATE USER user_profile_db_client NOCREATEDB NOCREATEROLE NOSUPERUSER PASSWORD 'user_profile_db_client';
END IF;
END
$do$;

CREATE DATABASE user_profile OWNER user_profile_db_admin ENCODING 'UTF8' TEMPLATE='template0' CONNECTION LIMIT 1000;

\connect user_profile
CREATE SCHEMA liquibase AUTHORIZATION user_profile_db_admin;
CREATE SCHEMA user_profile AUTHORIZATION user_profile_db_admin;

ALTER DEFAULT PRIVILEGES FOR USER user_profile_db_admin IN SCHEMA user_profile GRANT SELECT, INSERT, UPDATE, DELETE ON TABLES TO user_profile_db_client;
ALTER DEFAULT PRIVILEGES FOR ROLE user_profile_db_admin GRANT SELECT,INSERT,UPDATE,DELETE ON TABLES TO user_profile_db_client;
ALTER DEFAULT PRIVILEGES FOR ROLE user_profile_db_admin GRANT USAGE ON SCHEMAS TO user_profile_db_client;
GRANT USAGE ON SCHEMA user_profile TO user_profile_db_client;

ALTER DATABASE user_profile SET search_path TO user_profile;
ALTER USER user_profile_db_client SET search_path TO 'user_profile';