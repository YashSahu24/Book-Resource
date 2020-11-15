CREATE USER 'bookresource'@'localhost' IDENTIFIED BY 'bookresource';

GRANT ALL PRIVILEGES ON * . * TO 'bookresource'@'localhost';


ALTER USER 'bookresource'@'localhost' IDENTIFIED WITH mysql_native_password BY 'bookresource';