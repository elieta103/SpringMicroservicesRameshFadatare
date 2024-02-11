CREATE DATABASE IF NOT EXISTS `employee_db`;
CREATE DATABASE IF NOT EXISTS `organization_db`;

# create root user and grant rights
CREATE USER 'root'@'localhost' IDENTIFIED BY 'local';
GRANT ALL PRIVILEGES ON *.* TO 'root'@'%';