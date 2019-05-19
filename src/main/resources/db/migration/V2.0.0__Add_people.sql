alter table PERSON modify ID int(12) not null comment '用户ID';

alter table PERSON
	add constraint PERSON_pk
		primary key (ID);

insert into PERSON (ID, NAME) values (1, 'Axel');
insert into PERSON (ID, NAME) values (2, 'Mr. Foo');
insert into PERSON (ID, NAME) values (3, 'Ms. Bar');
