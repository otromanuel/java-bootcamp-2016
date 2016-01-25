-- DROP DATABASE highschool;
-- CREATE DATABASE highschool;
USE highschool;

DROP TABLE IF EXISTS schedule;
DROP TABLE IF EXISTS course_inscription;
DROP TABLE IF EXISTS course;
DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS teacher;


-- `teacher` table
CREATE TABLE IF NOT EXISTS `teacher` (
  `teacher_id` int(11) NOT NULL AUTO_INCREMENT, 
  `firstname` varchar(50), 
  `lastname` varchar(50),
  `birthdate` date DEFAULT NULL,
  PRIMARY KEY(teacher_id)
);

-- `student` table
CREATE TABLE IF NOT EXISTS `student` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(50) DEFAULT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `regnum` int(11) NOT NULL,
  `birthdate` date DEFAULT NULL,
  PRIMARY KEY (`student_id`)
);

-- `course` table
CREATE TABLE IF NOT EXISTS `course` (
  `course_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  `hoursbyweek` int(3) DEFAULT 0,
  PRIMARY KEY(`course_id`),
  FOREIGN KEY (teacher_id) 
        REFERENCES teacher(teacher_id)
        ON DELETE SET NULL  
);

-- `course_inscription` table
CREATE TABLE IF NOT EXISTS `course_inscription` (
  `student_id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  `partialnote1` int(2) DEFAULT NULL,
  `partialnote2` int(2) DEFAULT NULL,
  `partialnote3` int(2) DEFAULT NULL,
  `finalnote` int(2) DEFAULT NULL,
  PRIMARY KEY (`student_id`, `course_id`),
  FOREIGN KEY (student_id)
  	REFERENCES student(student_id)
  	ON DELETE CASCADE,
  FOREIGN KEY (course_id)
    REFERENCES course(course_id)
    ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS `schedule` (
  `schedule_id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11), 
  `dayofweek` varchar(15),
  `starttime` TIME,
  `endtime` TIME,
  PRIMARY KEY (schedule_id),
  FOREIGN KEY (course_id)
  	REFERENCES course(course_id)
  	ON DELETE CASCADE
);
