show databases;
CREATE DATABASE student_management_sys DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
use student_management_sys;

CREATE TABLE student (
    id int PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(10) NOT NULL,
    gender CHAR(2) NOT NULL,
    class_number VARCHAR(5) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO student (name,gender,class_number)
VALUES ("阿苏","女","1-1"),("小赞","男","1-2"),("耶博","男","1-2"),("洲洲","男","1-3"),("鲸鱼","男","1-3");