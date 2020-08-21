create database if not exists zhixuan_db;

use zhixuan_db;

create table t_post
(
	postid integer not null auto_increment primary key,
	openid varchar(32),
	image text,
	nickname varchar(32),
	title varchar(64),
	content text
);

create table t_review
(
	reviewid integer not null auto_increment primary key,
    postid integer,
    reopenid varchar(32),
    renickname varchar(32),
    content text,
    retype varchar(4),
    prinickname varchar(32)
);

create table t_userinfo
(
	openid varchar(32) not null primary key,
    nickname varchar(32),
    image text
);

create table t_cv
(
	cvid integer not null auto_increment primary key,
    openid varchar(32),
    uname varchar(32),
    gender varchar(2),
    edubg varchar(8),
    major varchar(16),
    internship integer,
    grade varchar(8),
    practime varchar(8),
    worktime varchar(8),
    fsttarget varchar(8),
    sndtarget varchar(8)
);

create table t_favjob
(
	favjobid integer not null auto_increment primary key,
    positionid integer,
    openid varchar(32),
    time datetime,
    positiontype varchar(8)
);

create table t_favpost
(
	favpostid integer not null auto_increment primary key,
    postid integer,
    openid varchar(32),
    time datetime,
    posttitle varchar(64)
);

create table t_positioninfo
(
    listid integer not null auto_increment primary key,
	time varchar(16),
	academic varchar(16),
	position varchar(16),
	officehour varchar(16),
	company varchar(16),
	salary integer,
	introduction text,
	major varchar(32),
	location varchar(32),
	starttime date,
	duty text,
	command text,
	email text
);

create table t_advice
(
    adviceid integer not null auto_increment primary key,
	nickname varchar(32),
	content text,
	time datetime
);