use StudyCafe

create table Members
(
	phone nvarchar(30) primary key,
	pw nvarchar(20),
	email nvarchar(50),
	gender nvarchar(10),
	birth nvarchar(20),
	seat_time nvarchar(30),
	lock_time nvarchar(30),
	qr_number nvarchar(30)
)

CREATE TABLE Ticket (--id : a는 좌석 시간이용권, b는 기간 이용권 , c는 사물함 이용권
	id nvarchar(30),
	t_name nvarchar(30),
	t_time nvarchar(30),
	t_money nvarchar(30),
	PRIMARY KEY (id, t_name)
);


create table Seat
(
	id nvarchar(30) not null,
	phone nvarchar(30),
	seat_number nvarchar(20),
	activations nvarchar(5) 
)

create table Lock
(
	phone nvarchar(30),
	seat_number nvarchar(20),
	activations nvarchar(5) 
)

create table Manager
(
	phone nvarchar(30),
	card_number nvarchar(30)
)

create table Payment
(
	order_number nvarchar(30) primary key,
	phone nvarchar(30),
	t_name nvarchar(30),
	t_money nvarchar(30),
	dates nvarchar(30)
)

create table FAQ
(
	keyword nvarchar(30),
	question nvarchar(30),
	answer nvarchar(50)
)

create table QNA
(
	phone nvarchar(30),
	q_type nvarchar(30),
	q_record nvarchar(50),
	answer nvarchar(50),
	q_time nvarchar(20),
	checks nvarchar(50)
)
ALTER TABLE QNA ALTER COLUMN checks VARCHAR(50)
insert into Manager Values('01012341234','0000-0000-0000')

ALTER TABLE QNA
ALTER COLUMN q_record nvarchar(255);

--Members Table 제약조건
alter table Members add constraint DF_seat_time default '0 0 0 0 0' for seat_time --seat_time에 디폴트값을 지정
alter table Members add constraint DF_lock_time default '0 0 0 0 0' for lock_time --seat_time에 디폴트값을 지정
alter table Members add constraint DF_qr_number default 'NULL' for qr_number --qr_number에 디폴트값을 지정

--Seat Table 제약조건
alter table Seat add constraint FK_Seat_phone foreign key (phone) references Members (phone) --제약조건 나중에 추가하기

--Lock Table 제약조건
alter table Lock add constraint FK_Lock_phone foreign key (phone) references Members (phone) --제약조건 나중에 추가하기

--Payment Table 제약조건
alter table Payment add constraint FK_Payment_phone foreign key(phone) references Members (phone) --제약조건 나중에 추가하기


drop table Ticket
update Seat set phone = 'NULL' where seat_number = 's12'
update Seat set activations = '1' where seat_number = 's12'
update Members set seat_time = '2023 08 21 00 03' where phone = '01033333333'
update Members set lock_time = '0 0 0 0 0' where phone = '01044444444'
update Members set room_time = '0 0 0 0 0'
update FAQ set keyword = '이용권' where keyword = '이용권 구매'
update Lock set phone = 'NULL' where lock_number = 'l5'
update Lock set activations = '1' where lock_number = 'l5'
delete from Payment where dates = '2023-09-09 21:43' 
SELECT lock_time FROM Members WHERE phone =  '01037713894'
update FAQ set keyword = '회원정보' where keyword = '회원가입' 
delete from Ticket where id = 'd' 
insert into FAQ (keyword,question,answer) values('회원가입','비밀번호 찾기는 어떻게 하나요?','키오스크 초기 화면 > 비밀번호 찾기 선택 > 정보 입력 후 비밀번호 찾기가 가능합니다 ')

DELETE FROM Ticket WHERE id = 'd' and t_money = '2700' AND t_name = '1 시간'

select * from Members
select * from Ticket
select * from Seat
select * from Lock
select * from Manager
select * from Payment
select * from FAQ
select * from QNA
