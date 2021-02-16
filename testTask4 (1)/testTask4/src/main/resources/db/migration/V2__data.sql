insert into clients (id, email, name, passport, phone) values (X'533a4559e55c18b38456555563322003', '123456@mail.ru',   'Иванов Иван Иванович',       '12 34 567890', '+7(927)123-45-67');
insert into clients (id, email, name, passport, phone) values (X'533a4559e55c18b38456555563322013', 'ytrewq@gmail.com', 'Петров Петр Петрович',       '09 98 765432', '+7(927)654-47-37');
insert into clients (id, email, name, passport, phone) values (X'533a4559e55c18b38456555563322023', 'qwerty@gmail.com', 'Сидоров Сидор Сидорович',    '67 76 098765', '+7(927)983-63-67');
insert into clients (id, email, name, passport, phone) values (X'533a4559e55c18b38456555563322033', 'asdfgh@gmail.com', 'Николаев Николай Николаевич','45 90 567909', '+7(927)156-45-54');
insert into clients (id, email, name, passport, phone) values (X'533a4559e55c18b38456555563322043', 'nbvcxz@gmail.com', 'Сергеев Сергей Сергеевич',   '56 78 453214', '+7(927)123-98-87');

insert into credits (id, limit, percent) values (X'533a4559e55c18b38456555563322004', 1000000, 7.3);
insert into credits (id, limit, percent) values (X'533a4559e55c18b38456555563322014', 1000000, 3.3);
insert into credits (id, limit, percent) values (X'533a4559e55c18b38456555563322024', 2000000, 5.0);
insert into credits (id, limit, percent) values (X'533a4559e55c18b38456555563322034', 500000, 10);
insert into credits (id, limit, percent) values (X'533a4559e55c18b38456555563322044', 100000, 12.3);

insert into bank (id, id_client, id_credit) values (X'533a4559e55c18b38456555563322002', X'533a4559e55c18b38456555563322003', X'533a4559e55c18b38456555563322004');
insert into bank (id, id_client, id_credit) values (X'533a4559e55c18b38456555563322003', X'533a4559e55c18b38456555563322013', X'533a4559e55c18b38456555563322014');
insert into bank (id, id_client, id_credit) values (X'533a4559e55c18b38456555563322004', X'533a4559e55c18b38456555563322023', X'533a4559e55c18b38456555563322024');
insert into bank (id, id_client, id_credit) values (X'533a4559e55c18b38456555563322005', X'533a4559e55c18b38456555563322033', X'533a4559e55c18b38456555563322034');
insert into bank (id, id_client, id_credit) values (X'533a4559e55c18b38456555563322006', X'533a4559e55c18b38456555563322043', X'533a4559e55c18b38456555563322044');

insert into credit_offers (id, credit_sum, id_client, id_credit) values (X'033a4559e55c18b38456555563322002', 800000,  X'533a4559e55c18b38456555563322003', X'533a4559e55c18b38456555563322004');
insert into credit_offers (id, credit_sum, id_client, id_credit) values (X'133a4559e55c18b38456555563322002', 1000000,  X'533a4559e55c18b38456555563322013', X'533a4559e55c18b38456555563322014');
insert into credit_offers (id, credit_sum, id_client, id_credit) values (X'233a4559e55c18b38456555563322002', 1500000,  X'533a4559e55c18b38456555563322023', X'533a4559e55c18b38456555563322024');
insert into credit_offers (id, credit_sum, id_client, id_credit) values (X'333a4559e55c18b38456555563322002', 500000,  X'533a4559e55c18b38456555563322033', X'533a4559e55c18b38456555563322034');
insert into credit_offers (id, credit_sum, id_client, id_credit) values (X'433a4559e55c18b38456555563322002', 80000,  X'533a4559e55c18b38456555563322043', X'533a4559e55c18b38456555563322044');

insert into plans (id, date, total_sum, credit_body_sum, percent_body_sum, id_credit_offer) values (X'100a4559e55c18b38456555563322002', '2020-12-27', 71534, 66666.6, 4867.4, X'033a4559e55c18b38456555563322002');
insert into plans (id, date, total_sum, credit_body_sum, percent_body_sum, id_credit_offer) values (X'101a4559e55c18b38456555563322002', '2021-01-27', 71534, 66666.6, 4867.4, X'033a4559e55c18b38456555563322002');
insert into plans (id, date, total_sum, credit_body_sum, percent_body_sum, id_credit_offer) values (X'102a4559e55c18b38456555563322002', '2021-02-27', 71534, 66666.6, 4867.4, X'033a4559e55c18b38456555563322002');
insert into plans (id, date, total_sum, credit_body_sum, percent_body_sum, id_credit_offer) values (X'103a4559e55c18b38456555563322002', '2021-03-27', 71534, 66666.6, 4867.4, X'033a4559e55c18b38456555563322002');
insert into plans (id, date, total_sum, credit_body_sum, percent_body_sum, id_credit_offer) values (X'104a4559e55c18b38456555563322002', '2021-04-27', 71534, 66666.6, 4867.4, X'033a4559e55c18b38456555563322002');
insert into plans (id, date, total_sum, credit_body_sum, percent_body_sum, id_credit_offer) values (X'105a4559e55c18b38456555563322002', '2021-05-27', 71534, 66666.6, 4867.4, X'033a4559e55c18b38456555563322002');
insert into plans (id, date, total_sum, credit_body_sum, percent_body_sum, id_credit_offer) values (X'106a4559e55c18b38456555563322002', '2021-05-27', 71534, 66666.6, 4867.4, X'033a4559e55c18b38456555563322002');
insert into plans (id, date, total_sum, credit_body_sum, percent_body_sum, id_credit_offer) values (X'107a4559e55c18b38456555563322002', '2021-07-27', 71534, 66666.6, 4867.4, X'033a4559e55c18b38456555563322002');
insert into plans (id, date, total_sum, credit_body_sum, percent_body_sum, id_credit_offer) values (X'108a4559e55c18b38456555563322002', '2021-08-27', 71534, 66666.6, 4867.4, X'033a4559e55c18b38456555563322002');
insert into plans (id, date, total_sum, credit_body_sum, percent_body_sum, id_credit_offer) values (X'109a4559e55c18b38456555563322002', '2021-09-27', 71534, 66666.6, 4867.4, X'033a4559e55c18b38456555563322002');
insert into plans (id, date, total_sum, credit_body_sum, percent_body_sum, id_credit_offer) values (X'110a4559e55c18b38456555563322002', '2021-10-27', 71534, 66666.6, 4867.4, X'033a4559e55c18b38456555563322002');
insert into plans (id, date, total_sum, credit_body_sum, percent_body_sum, id_credit_offer) values (X'111a4559e55c18b38456555563322002', '2021-11-27', 71526, 66667.4, 4858.6, X'033a4559e55c18b38456555563322002');

insert into plans (id, date, total_sum, credit_body_sum, percent_body_sum, id_credit_offer) values (X'200a4559e55c18b38456555563322002', '2021-01-20', 202750, 200000, 2750, X'133a4559e55c18b38456555563322002');
insert into plans (id, date, total_sum, credit_body_sum, percent_body_sum, id_credit_offer) values (X'201a4559e55c18b38456555563322002', '2021-02-20', 202750, 200000, 2750, X'133a4559e55c18b38456555563322002');
insert into plans (id, date, total_sum, credit_body_sum, percent_body_sum, id_credit_offer) values (X'202a4559e55c18b38456555563322002', '2021-03-20', 202750, 200000, 2750, X'133a4559e55c18b38456555563322002');
insert into plans (id, date, total_sum, credit_body_sum, percent_body_sum, id_credit_offer) values (X'203a4559e55c18b38456555563322002', '2021-04-20', 202750, 200000, 2750, X'133a4559e55c18b38456555563322002');
insert into plans (id, date, total_sum, credit_body_sum, percent_body_sum, id_credit_offer) values (X'204a4559e55c18b38456555563322002', '2021-05-20', 202750, 200000, 2750, X'133a4559e55c18b38456555563322002');

insert into plans (id, date, total_sum, credit_body_sum, percent_body_sum, id_credit_offer) values (X'300a4559e55c18b38456555563322002', '2021-02-15', 256250, 250000, 6250, X'233a4559e55c18b38456555563322002');
insert into plans (id, date, total_sum, credit_body_sum, percent_body_sum, id_credit_offer) values (X'310a4559e55c18b38456555563322002', '2021-03-15', 256250, 250000, 6250, X'233a4559e55c18b38456555563322002');
insert into plans (id, date, total_sum, credit_body_sum, percent_body_sum, id_credit_offer) values (X'320a4559e55c18b38456555563322002', '2021-04-15', 256250, 250000, 6250, X'233a4559e55c18b38456555563322002');
insert into plans (id, date, total_sum, credit_body_sum, percent_body_sum, id_credit_offer) values (X'330a4559e55c18b38456555563322002', '2021-05-15', 256250, 250000, 6250, X'233a4559e55c18b38456555563322002');
insert into plans (id, date, total_sum, credit_body_sum, percent_body_sum, id_credit_offer) values (X'340a4559e55c18b38456555563322002', '2021-06-15', 256250, 250000, 6250, X'233a4559e55c18b38456555563322002');
insert into plans (id, date, total_sum, credit_body_sum, percent_body_sum, id_credit_offer) values (X'350a4559e55c18b38456555563322002', '2021-07-15', 256250, 250000, 6250, X'233a4559e55c18b38456555563322002');

insert into plans (id, date, total_sum, credit_body_sum, percent_body_sum, id_credit_offer) values (X'400a4559e55c18b38456555563322002', '2021-03-10', 87500, 83334, 4166, X'333a4559e55c18b38456555563322002');
insert into plans (id, date, total_sum, credit_body_sum, percent_body_sum, id_credit_offer) values (X'410a4559e55c18b38456555563322002', '2021-04-10', 87500, 83334, 4166, X'333a4559e55c18b38456555563322002');
insert into plans (id, date, total_sum, credit_body_sum, percent_body_sum, id_credit_offer) values (X'420a4559e55c18b38456555563322002', '2021-05-10', 87500, 83334, 4166, X'333a4559e55c18b38456555563322002');
insert into plans (id, date, total_sum, credit_body_sum, percent_body_sum, id_credit_offer) values (X'430a4559e55c18b38456555563322002', '2021-06-10', 87500, 83334, 4166, X'333a4559e55c18b38456555563322002');
insert into plans (id, date, total_sum, credit_body_sum, percent_body_sum, id_credit_offer) values (X'440a4559e55c18b38456555563322002', '2021-07-10', 87500, 83334, 4166, X'333a4559e55c18b38456555563322002');
insert into plans (id, date, total_sum, credit_body_sum, percent_body_sum, id_credit_offer) values (X'450a4559e55c18b38456555563322002', '2021-08-10', 87500, 83330, 4170, X'333a4559e55c18b38456555563322002');

insert into plans (id, date, total_sum, credit_body_sum, percent_body_sum, id_credit_offer) values (X'500a4559e55c18b38456555563322002', '2021-04-05', 27760, 26667, 1093, X'433a4559e55c18b38456555563322002');
insert into plans (id, date, total_sum, credit_body_sum, percent_body_sum, id_credit_offer) values (X'510a4559e55c18b38456555563322002', '2021-05-05', 27760, 26667, 1093, X'433a4559e55c18b38456555563322002');
insert into plans (id, date, total_sum, credit_body_sum, percent_body_sum, id_credit_offer) values (X'520a4559e55c18b38456555563322002', '2021-06-05', 27760, 26666, 1094, X'433a4559e55c18b38456555563322002');
