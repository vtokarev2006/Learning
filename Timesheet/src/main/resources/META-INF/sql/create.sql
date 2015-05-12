CREATE VIEW user_securitygroup_view AS SELECT u.USERNAME AS username, u.PASSWORD AS password, sg.NAME AS securitygroup FROM ((user u JOIN user_securitygroup usg ON ((u.ID = usg.USER_ID))) JOIN securitygroup sg ON ((usg.SECURITYGROUP_ID = sg.ID)))

INSERT INTO agency (NAME) VALUES ('ReSources');

INSERT INTO `timesheet`.`securitygroup` (`NAME`) VALUES ('ADMIN');
INSERT INTO `timesheet`.`securitygroup` (`NAME`) VALUES ('USER');

INSERT INTO `timesheet`.`user` (`EMAIL`, `FIRSTNAME`, `HIREDATE`, `LASTNAME`, `PASSWORD`, `USERNAME`, `AGENCY_ID`) VALUES ('vtokarev@re-sources.com.ua', 'Vyacheslav', '2015-01-01', 'Tokarev', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', 'vtokarev', '1');

INSERT INTO `timesheet`.`user_securitygroup` (`SECURITYGROUP_ID`, `USER_ID`) VALUES ('1', '1');
INSERT INTO `timesheet`.`user_securitygroup` (`SECURITYGROUP_ID`, `USER_ID`) VALUES ('2', '1');