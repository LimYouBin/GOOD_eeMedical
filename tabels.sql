-- 회원 테이블
create table members
(
	member_no int primary key auto_increment,
    email varchar(23) not null unique,
    member_pwd varchar(45) not null,
    member_name varchar(45) not null,
    nickname varchar(18) not null unique,
    phone varchar(13) not null unique,
    addr varchar(105) not null,
    birth varchar(10),
    gender char check(gender in('M', 'F')),
    img varchar(70) default 'uploads/user.png',
    grd char(2)  default 'i',
    money int default 0,
    point int default 0,
    member_join date default now(),
    isdrop char check(isdrop in('T', 'F'))
);

-- 게시판 테이블
create table board
(
	board_no int primary key auto_increment,
    member_no int references members(member_no),
    board_title varchar(90) not null,
    board_pwd varchar(15) not null,
    postdate date default now(),
    modifydate date,
    writer varchar(18) not null,
    content varchar(5000) not null,
    contentimg varchar(70),
    viewcnt int default 0,
    likecnt int default 0,
    unlikecnt int default 0
);