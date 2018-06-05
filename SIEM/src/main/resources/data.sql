insert into alarm (id, name, description, seconds,number, prival, version, timestamp, hostname, appname , procid, msgid, sd, msg, can_delete) 
values (1000,'status40..', 'status 40..', 60, 3, 0, 0, '','','Server','','','status=\"40', '', false); 
insert into alarm (id, name, description, seconds,number, prival, version, timestamp, hostname, appname , procid, msgid, sd, msg, can_delete) 
values (1001,'status50..', 'status 50..', 60, 3, 0, 0, '','','Server','','','status=\"50', '', false); 
insert into alarm (id, name, description, seconds,number, prival, version, timestamp, hostname, appname , procid, msgid, sd, msg, can_delete) 
values (1002,'Login in application', 'Invalid login', 300, 5, 0, 0, '','','Firewall','','','UserID', 'Invalid username or password', false); 
insert into alarm (id, name, description, seconds,number, prival, version, timestamp, hostname, appname , procid, msgid, sd, msg, can_delete) 
values (1003,'Registration in application', 'Invalid registration', 300, 5, 0, 0, '','','Firewall','','','UserID', 'Username already exists', false);
insert into alarm (id, name, description, seconds,number, prival, version, timestamp, hostname, appname , procid, msgid, sd, msg, can_delete) 
values (1004,'Firewall error', 'Drop action in firewall', 60, 2, 0, 0, '','','Firewall','','','', 'DROP', false);
insert into alarm (id, name, description, seconds,number, prival, version, timestamp, hostname, appname , procid, msgid, sd, msg, can_delete) 
values (1005,'Firewall lost', 'Info-events-losst action in firewall', 60, 1, 0, 0, '','','Firewall','','','', 'INFO-EVENTS-LOST', false);
insert into alarm (id, name, description, seconds,number, prival, version, timestamp, hostname, appname , procid, msgid, sd, msg, can_delete) 
values (1006,'Message error', 'Message field is error', 60, 3, 0, 0, '','','','','','', 'error', false);
insert into alarm (id, name, description, seconds,number, prival, version, timestamp, hostname, appname , procid, msgid, sd, msg, can_delete) 
values (1007,'Stuctured data error', 'Sd contains the word error', 60, 3, 0, 0, '','','','','','error', '', false);
