/* スキーマ（DB）作成 */
CREATE SCHEMA IF NOT EXISTS `eg_members` DEFAULT CHARACTER SET utf8 ;

/* ユーザー作成 */
CREATE USER 'eg_user'@'localhost' IDENTIFIED BY 'eg_pass';

/* ユーザー権限設定 */
GRANT ALL PRIVILEGES ON eg_members.* TO 'eg_user'@'localhost';
FLUSH PRIVILEGES;

/* ユーザー削除（※為念、消す方法。コメントを外して使用する。） */
-- DROP USER 'eg_user'@'localhost';
