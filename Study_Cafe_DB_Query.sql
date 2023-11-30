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

CREATE TABLE Ticket (--id : a�� �¼� �ð��̿��, b�� �Ⱓ �̿�� , c�� �繰�� �̿��
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

--Members Table ��������
alter table Members add constraint DF_seat_time default '0 0 0 0 0' for seat_time --seat_time�� ����Ʈ���� ����
alter table Members add constraint DF_lock_time default '0 0 0 0 0' for lock_time --seat_time�� ����Ʈ���� ����
alter table Members add constraint DF_qr_number default 'NULL' for qr_number --qr_number�� ����Ʈ���� ����

--Seat Table ��������
alter table Seat add constraint FK_Seat_phone foreign key (phone) references Members (phone) --�������� ���߿� �߰��ϱ�

--Lock Table ��������
alter table Lock add constraint FK_Lock_phone foreign key (phone) references Members (phone) --�������� ���߿� �߰��ϱ�

--Payment Table ��������
alter table Payment add constraint FK_Payment_phone foreign key(phone) references Members (phone) --�������� ���߿� �߰��ϱ�


drop table Ticket
update Seat set phone = 'NULL' where seat_number = 's12'
update Seat set activations = '1' where seat_number = 's12'
update Members set seat_time = '2023 08 21 00 03' where phone = '01033333333'
update Members set lock_time = '0 0 0 0 0' where phone = '01044444444'
update Members set room_time = '0 0 0 0 0'
update FAQ set keyword = '�̿��' where keyword = '�̿�� ����'
update Lock set phone = 'NULL' where lock_number = 'l5'
update Lock set activations = '1' where lock_number = 'l5'
delete from Payment where dates = '2023-09-09 21:43' 
SELECT lock_time FROM Members WHERE phone =  '01037713894'
update FAQ set keyword = 'ȸ������' where keyword = 'ȸ������' 
delete from Ticket where id = 'd' 
insert into FAQ (keyword,question,answer) values('ȸ������','��й�ȣ ã��� ��� �ϳ���?','Ű����ũ �ʱ� ȭ�� > ��й�ȣ ã�� ���� > ���� �Է� �� ��й�ȣ ã�Ⱑ �����մϴ� ')

DELETE FROM Ticket WHERE id = 'd' and t_money = '2700' AND t_name = '1 �ð�'

select * from Members
select * from Ticket
select * from Seat
select * from Lock
select * from Manager
select * from Payment
select * from FAQ
select * from QNA
