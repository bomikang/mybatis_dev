-- 학사관리
DROP SCHEMA IF EXISTS mybatis_dev;

-- 학사관리
CREATE SCHEMA mybatis_dev;

-- 주소
CREATE TABLE mybatis_dev.address (
	addr_id INTEGER     NOT NULL COMMENT '번호', -- 번호
	street  VARCHAR(50) NOT NULL COMMENT '거리', -- 거리
	city    VARCHAR(50) NOT NULL COMMENT '시도', -- 시도
	state   VARCHAR(50) NOT NULL COMMENT '시군구', -- 시군구
	zip     CHAR(5)     NOT NULL COMMENT '우편번호', -- 우편번호
	country VARCHAR(20) NOT NULL COMMENT '동' -- 동
)
COMMENT '주소';

-- 주소
ALTER TABLE mybatis_dev.address
	ADD CONSTRAINT PK_address -- 주소 기본키
		PRIMARY KEY (
			addr_id -- 번호
		);

-- 학생
CREATE TABLE mybatis_dev.students (
	stud_id INTEGER     NOT NULL COMMENT '학번', -- 학번
	name    VARCHAR(50) NOT NULL COMMENT '성명', -- 성명
	email   VARCHAR(50) NOT NULL COMMENT '이메일', -- 이메일
	phone   VARCHAR(15) NULL     COMMENT '연락처', -- 연락처
	dob     DATE        NULL     COMMENT '생년월일', -- 생년월일
	bio     LONGTEXT    NULL     COMMENT '자기소개서', -- 자기소개서
	pic     BLOB        NULL     COMMENT '증명사진', -- 증명사진
	addr_id INTEGER     NULL     COMMENT '주소' -- 주소
)
COMMENT '학생';

-- 학생
ALTER TABLE mybatis_dev.students
	ADD CONSTRAINT PK_students -- 학생 기본키
		PRIMARY KEY (
			stud_id -- 학번
		);

ALTER TABLE mybatis_dev.students
	MODIFY COLUMN stud_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '학번';

-- 강사
CREATE TABLE mybatis_dev.tutors (
	tutor_id INTEGER     NOT NULL COMMENT '강사번호', -- 강사번호
	name     VARCHAR(50) NOT NULL COMMENT '성명', -- 성명
	email    VARCHAR(50) NOT NULL COMMENT '이메일', -- 이메일
	phone    VARCHAR(15) NULL     COMMENT '연락처', -- 연락처
	dob      DATE        NULL     COMMENT '생년월일', -- 생년월일
	bio      LONGTEXT    NULL     COMMENT '자기소개서', -- 자기소개서
	pic      BLOB        NULL     COMMENT '증명사진', -- 증명사진
	addr_id  INTEGER     NULL     COMMENT '주소' -- 주소
)
COMMENT '강사';

-- 강사
ALTER TABLE mybatis_dev.tutors
	ADD CONSTRAINT PK_tutors -- 강사 기본키
		PRIMARY KEY (
			tutor_id -- 강사번호
		);

ALTER TABLE mybatis_dev.tutors
	MODIFY COLUMN tutor_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '강사번호';

-- 강좌번호
CREATE TABLE mybatis_dev.courses (
	course_id   INTEGER      NOT NULL COMMENT '강좌번호', -- 강좌번호
	name        VARCHAR(100) NOT NULL COMMENT '강좌명', -- 강좌명
	description VARCHAR(512) NULL     COMMENT '강좌내용', -- 강좌내용
	start_date  DATE         NULL     COMMENT '시작일', -- 시작일
	end_date    DATE         NULL     COMMENT '종료일', -- 종료일
	tutor_id    INTEGER      NOT NULL COMMENT '담당강사' -- 담당강사
)
COMMENT '강좌번호';

-- 강좌번호
ALTER TABLE mybatis_dev.courses
	ADD CONSTRAINT PK_courses -- 강좌번호 기본키
		PRIMARY KEY (
			course_id -- 강좌번호
		);

ALTER TABLE mybatis_dev.courses
	MODIFY COLUMN course_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '강좌번호';

-- 수강
CREATE TABLE mybatis_dev.course_enrollment (
	course_id INTEGER NOT NULL COMMENT '강좌', -- 강좌
	stud_id   INTEGER NOT NULL COMMENT '학생' -- 학생
)
COMMENT '수강';

-- 수강
ALTER TABLE mybatis_dev.course_enrollment
	ADD CONSTRAINT PK_course_enrollment -- 수강 기본키
		PRIMARY KEY (
			course_id, -- 강좌
			stud_id    -- 학생
		);

-- 학생
ALTER TABLE mybatis_dev.students
	ADD CONSTRAINT FK_address_TO_students -- 주소 -> 학생
		FOREIGN KEY (
			addr_id -- 주소
		)
		REFERENCES mybatis_dev.address ( -- 주소
			addr_id -- 번호
		);

-- 강사
ALTER TABLE mybatis_dev.tutors
	ADD CONSTRAINT FK_address_TO_tutors -- 주소 -> 강사
		FOREIGN KEY (
			addr_id -- 주소
		)
		REFERENCES mybatis_dev.address ( -- 주소
			addr_id -- 번호
		);

-- 강좌번호
ALTER TABLE mybatis_dev.courses
	ADD CONSTRAINT FK_tutors_TO_courses -- 강사 -> 강좌번호
		FOREIGN KEY (
			tutor_id -- 담당강사
		)
		REFERENCES mybatis_dev.tutors ( -- 강사
			tutor_id -- 강사번호
		);

-- 수강
ALTER TABLE mybatis_dev.course_enrollment
	ADD CONSTRAINT FK_courses_TO_course_enrollment -- 강좌번호 -> 수강
		FOREIGN KEY (
			course_id -- 강좌
		)
		REFERENCES mybatis_dev.courses ( -- 강좌번호
			course_id -- 강좌번호
		);

-- 수강
ALTER TABLE mybatis_dev.course_enrollment
	ADD CONSTRAINT FK_students_TO_course_enrollment -- 학생 -> 수강
		FOREIGN KEY (
			stud_id -- 학생
		)
		REFERENCES mybatis_dev.students ( -- 학생
			stud_id -- 학번
		);
		
		
		

		
INSERT INTO ADDRESSES (ADDR_ID,STREET,CITY,STATE,ZIP,COUNTRY) VALUES 
 (1,'4891 Pacific Hwy','San Diego','CA','92110','San Diego'),
 (2,'2400 N Jefferson St','Perry','FL','32347','Taylor'),
 (3,'710 N Cable Rd','Lima','OH','45825','Allen'),
 (4,'5108 W Gore Blvd','Lawton','OK','32365','Comanche');

INSERT INTO STUDENTS (STUD_ID,NAME,EMAIL,PHONE,DOB,BIO,PIC,ADDR_ID) VALUES 
 (1,'Timothy','timothy@gmail.com','123-123-1234','1988-04-25',NULL,NULL,3),
 (2,'Douglas','douglas@gmail.com','789-456-1234','1990-08-15',NULL,NULL,4);

INSERT INTO TUTORS (TUTOR_ID,NAME,EMAIL,PHONE,DOB,BIO,PIC,ADDR_ID) VALUES 
 (1,'John','john@gmail.com','111-222-3333','1980-05-20',NULL,NULL,1),
 (2,'Ken','ken@gmail.com','111-222-3333','1980-05-20',NULL,NULL,1),
 (3,'Paul','paul@gmail.com','123-321-4444','1981-03-15',NULL,NULL,2),
 (4,'Mike','mike@gmail.com','123-321-4444','1981-03-15',NULL,NULL,2);

INSERT INTO COURSES (COURSE_ID,NAME,DESCRIPTION,START_DATE,END_DATE,TUTOR_ID) VALUES 
 (1,'Quickstart Core Java','Core Java Programming','2013-03-01','2013-04-15',1),
 (2,'Quickstart JavaEE6','Enterprise App Development using JavaEE6','2013-04-01','2013-08-30',1),
 (3,'MyBatis3 Premier','MyBatis 3 framework','2013-06-01','2013-07-15',2);

INSERT INTO COURSE_ENROLLMENT (COURSE_ID,STUD_ID) VALUES 
 (1,1),
 (1,2),
 (2,2);
 
select * from students;
select * from tutors;
select * from addresses;
select * from courses;
select * from course_enrollment;

select stud_id, name, email, dob from students where stud_id = 1;
select stud_id, name, email, dob from students where stud_id = 1;

insert into students(name, email, phone, dob) values('강보미', 'kbm@test.co.kr', '010-1234-1234', '2016-12-12');

update students set name='부부부', email='abc@abc.co.kr', phone='0110-5555-4144', dob='1955-12-12'
where stud_id = 7;

delete from students where stud_id=7;

select stud_id as studId, name, email, phone, dob from students;


-- 1:1일 때는 inner join이 가능하다
select stud_id, name, email, phone, a.addr_id, street, city, state, zip, country
from students s left outer join addresses a on s.addr_id = a.addr_id
where stud_id = 1;

select * from tutors;

select t.tutor_id, t.name as tutor_name, email, c.course_id, c.name, description, start_date, end_date
from tutors t left outer join addresses a on t.addr_id = a.addr_id
				left outer join courses c on t.tutor_id = c.tutor_id
where t.tutor_id = 1;


select * from courses where tutor_id = 1 and name like '%java%';
select * from courses where tutor_id = 1 and start_date >= '2013-03-01';
select * from courses where tutor_id = 1 and start_date >= '2013-03-01' and end_date <='2013-07-01' ;
select * from courses where tutor_id = 1 and start_date >= '2013-03-01' and name like '%java%';

select * from courses where tutor_id = 1;
-- or
select * from courses where name like '%java%';
-- or
select * from courses where end_date >= now();

select * from courses where end_date <= '2014-05-05';

select * from students;