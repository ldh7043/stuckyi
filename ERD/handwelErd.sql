
/* Drop Tables */

DROP TABLE admin_auth CASCADE CONSTRAINTS;
DROP TABLE board_comment CASCADE CONSTRAINTS;
DROP TABLE c_reserve CASCADE CONSTRAINTS;
DROP TABLE main_board CASCADE CONSTRAINTS;
DROP TABLE t_reserve CASCADE CONSTRAINTS;
DROP TABLE join CASCADE CONSTRAINTS;

DROP SEQUENCE join_seq;
DROP SEQUENCE main_board_seq;
DROP SEQUENCE t_res_uid_seq;
DROP SEQUENCE h_res_uid_seq;
DROP SEQUENCE board_comment_seq;

CREATE SEQUENCE board_comment_seq;
CREATE SEQUENCE main_board_seq;
CREATE SEQUENCE h_res_uid_seq;
CREATE SEQUENCE t_res_uid_seq;
CREATE SEQUENCE join_seq;


/* Create Tables */

CREATE TABLE admin_auth
(
	user_auth varchar2(50) NOT NULL,
	user_id varchar2(20) NOT NULL
);

INSERT INTO admin_auth VALUES ('ROLE_ADMIN', 'stuckyi');
INSERT INTO admin_auth VALUES ('ROLE_MEMBER', 'kimgim');
SELECT 

SELECT * FROM ADMIN_AUTH ;
SELECT * FROM "JOIN" j ;
SELECT j.user_id, j.user_pw, j.enabled, a.USER_AUTH 
FROM "JOIN" j, ADMIN_AUTH a
WHERE j.USER_ID = a.USER_ID ;

SELECT user_auth FROM ADMIN_AUTH WHERE USER_ID = 'temp1';


CREATE TABLE board_comment
(
	cmt_uid number NOT NULL,
	cmt_content clob,
	cmt_regdate date DEFAULT SYSDATE,
	brd_uid number NOT NULL,
	user_id varchar2(20) NOT NULL,
	PRIMARY KEY (cmt_uid)
);

INSERT INTO BOARD_COMMENT(CMT_UID, CMT_CONTENT, BRD_UID, USER_ID) VALUES (board_comment_seq.nextval, 'comment content', 41, 'member80');
SELECT * FROM BOARD_COMMENT WHERE BRD_UID = 64;
CREATE TABLE c_reserve
(
	h_res_uid number NOT NULL,
	h_res_date varchar2(10) NOT NULL,
	h_res_time varchar2(20) NOT NULL,
	h_res_type varchar2(20) NOT NULL,
	h_res_title varchar2(40) NOT NULL,
	h_res_name varchar2(40) NOT NULL,
	h_res_ph varchar2(10),
	h_res_hdate date DEFAULT SYSDATE,
	user_id varchar2(20) NOT NULL,
	PRIMARY KEY (h_res_uid)
);

INSERT INTO c_reserve(h_res_uid, h_res_date, h_res_time, h_res_type, h_res_title, h_res_name, h_res_ph, user_id)
VALUES (h_res_uid_seq.nextval, '날짜', '09:20', '내과', 'ㅇㅇ병원', '이름', '010-1234-5678', 'id');
INSERT INTO c_reserve(h_res_uid, h_res_date, h_res_time, h_res_type, h_res_title, h_res_name, h_res_ph, user_id)
VALUES (h_res_uid_seq.nextval, '날짜', '09:20', '내과', 'ㅇㅇ병원', '이름', '010-1234-5678', 'id');

SELECT * FROM c_reserve ORDER BY h_res_uid DESC ;

CREATE SEQUENCE h_res_uid_seq;
CREATE TABLE join
(
	user_id varchar2(20) NOT NULL,
	user_pw varchar2(80) NOT NULL,
	user_ph varchar2(20),
	user_email varchar2(30) NOT NULL,
	user_name varchar2(30) NOT NULL,
	user_gender varchar2(20),
	enabled char(1) DEFAULT '1',
	PRIMARY KEY (user_id)
);

SELECT * FROM join;

INSERT INTO JOIN(user_id, user_pw, user_ph, user_email, user_name, user_gender, enabled)
values ('stuckyi', 'handwel', '01012344321', 'stuckyi@gmail.com', 'stuckyi', 'male', '1');
INSERT INTO JOIN(user_id, user_pw, user_ph, user_email, user_name, user_gender, enabled)
values ('kimgim', 'handwel', '0109999999', 'kimgim@gmail.com', 'kimgim1', 'female', '1');

SELECT
	         user_id "id", 
	         user_pw "pw",
	         user_ph "ph",
	         user_email "email",
	         user_name "name",
	         user_gender "gender"       
	      FROM 
	         join ORDER BY user_id DESC;


CREATE TABLE main_board
(
	brd_uid number NOT NULL,
	brd_title varchar2(100) NOT NULL,
	brd_content clob,
	brd_viewcnt number DEFAULT 0,
	brd_regdate date DEFAULT SYSDATE,
	brd_type varchar2(30) NOT NULL,
	user_id varchar2(20) NOT NULL,
	PRIMARY KEY (brd_uid)
);

INSERT INTO MAIN_BOARD(BRD_UID, BRD_TITLE, BRD_CONTENT, BRD_TYPE, USER_ID) 
VALUES (main_board_seq.nextval, 'longgggggggggggggggggggggggggggggggg', 'test content', '복지', 'member80');

SELECT * FROM MAIN_BOARD ORDER BY BRD_UID DESC ;

CREATE TABLE t_reserve
(
   t_res_uid number NOT NULL,
   t_res_addr varchar2(50) NOT NULL,
   t_res_date varchar2(20) NOT NULL,
   t_res_time varchar2(30) NOT NULL,
   t_res_cmt varchar2(100),
   t_res_name varchar2(30) NOT NULL,
   t_res_wdate date DEFAULT SYSDATE,
   user_id varchar2(20) NOT NULL,
   PRIMARY KEY (t_res_uid)
);
INSERT INTO T_RESERVE (T_RES_UID, T_RES_ADDR, T_RES_DATE, T_RES_TIME, T_RES_NAME, USER_ID) VALUES (t_res_uid_seq.nextval, '주소', '2021-4-18', '09:20', '이름', 'member80');



/* Create Foreign Keys */

ALTER TABLE admin_auth
	ADD FOREIGN KEY (user_id)
	REFERENCES join (user_id)
;


ALTER TABLE board_comment
	ADD FOREIGN KEY (user_id)
	REFERENCES join (user_id)
;


ALTER TABLE c_reserve
	ADD FOREIGN KEY (user_id)
	REFERENCES join (user_id)
;


ALTER TABLE main_board
	ADD FOREIGN KEY (user_id)
	REFERENCES join (user_id)
;


ALTER TABLE t_reserve
	ADD FOREIGN KEY (user_id)
	REFERENCES join (user_id)
;


ALTER TABLE board_comment
	ADD FOREIGN KEY (brd_uid)
	REFERENCES main_board (brd_uid)
;



