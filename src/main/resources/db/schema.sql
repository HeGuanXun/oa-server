
DROP TABLE IF EXISTS `book`;
CREATE TABLE book
(
    bid INT AUTO_INCREMENT NOT NULL ,
    bookName VARCHAR(255) NOT NULL,
    author VARCHAR(50) NOT NULL,
    type VARCHAR(255) NOT NULL,
    publisher VARCHAR(255) NOT NULL,
    publicationDate VARCHAR(255) NOT NULL,
    price INT(11) NOT NULL,
    status INT(11) NOT NULL,
    remark VARCHAR(255),
    PRIMARY KEY (`bid`)
);

DROP TABLE IF EXISTS `user`;
CREATE TABLE user
(
    userId INT AUTO_INCREMENT NOT NULL ,
    userName VARCHAR(255) NOT NULL,
    passWord VARCHAR(50) NOT NULL,
    type INT(11) NOT NULL,
    PRIMARY KEY (`userId`)
);

DROP TABLE IF EXISTS `role`;
CREATE TABLE  role (
  id   INT AUTO_INCREMENT NOT NULL,
  name VARCHAR(10),
  PRIMARY KEY (`id`)
);

DROP TABLE `role_user`;
CREATE TABLE  role_user (
  user_id INT,
  role_id INT
)