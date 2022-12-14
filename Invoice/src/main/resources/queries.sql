DROP TABLE invoices;
DROP TABLE references;
DROP TABLE individual;
DROP TABLE companies;

CREATE TABLE companies (
                           companyId number GENERATED BY DEFAULT AS IDENTITY primary KEY,
                           name VARCHAR2(150) NOT NULL
);

CREATE TABLE individual  (
                             indivId number GENERATED BY DEFAULT AS IDENTITY primary KEY,
                             name VARCHAR2(150) NOT NULL,
                             type VARCHAR2(150) NOT NULL,
                             companyId number references companies(companyId) on delete cascade
);

create table references
(
    ext_ref number primary KEY,
    indivId number references individual(indivId) on delete cascade
);

CREATE TABLE invoices (
                          invoiceId number GENERATED BY DEFAULT AS IDENTITY primary KEY,
                          indivId number references individual(indivId) on delete cascade,
                          amount NUMBER(14,2),
                          issue_date date
);

INSERT INTO IVAN_BANCHEV.COMPANIES (NAME)
VALUES ('Pepsi-cola');

INSERT INTO IVAN_BANCHEV.COMPANIES (NAME)
VALUES ('Mercedes');

INSERT INTO IVAN_BANCHEV.COMPANIES (NAME)
VALUES ('AEG');

INSERT INTO IVAN_BANCHEV.COMPANIES (NAME)
VALUES ('Sony');

INSERT INTO IVAN_BANCHEV.COMPANIES (NAME)
VALUES ('Opel');

INSERT INTO IVAN_BANCHEV.COMPANIES (NAME)
VALUES ('VW');

INSERT INTO IVAN_BANCHEV.COMPANIES (NAME)
VALUES ('T-MARKET');

INSERT INTO IVAN_BANCHEV.COMPANIES (NAME)
VALUES ('A1');

INSERT INTO IVAN_BANCHEV.COMPANIES (NAME)
VALUES ('AIBO');

INSERT INTO IVAN_BANCHEV.COMPANIES (NAME)
VALUES ('Force');

INSERT INTO IVAN_BANCHEV.INDIVIDUAL (NAME, TYPE, COMPANYID)
VALUES ('Ivan Banchev', 'legal', 3);

INSERT INTO IVAN_BANCHEV.INDIVIDUAL (NAME, TYPE, COMPANYID)
VALUES ('Toncho Tokmachiev', 'legal', 3);

INSERT INTO IVAN_BANCHEV.INDIVIDUAL (NAME, TYPE, COMPANYID)
VALUES ('Georgi Georgiev', 'legal', 3);

INSERT INTO IVAN_BANCHEV.INDIVIDUAL (NAME, TYPE, COMPANYID)
VALUES ('Georgi Vasilev', 'legal', 3);

INSERT INTO IVAN_BANCHEV.INDIVIDUAL (NAME, TYPE, COMPANYID)
VALUES ('Tsanko Tsankov', 'natural', 3);

INSERT INTO IVAN_BANCHEV.INDIVIDUAL (NAME, TYPE, COMPANYID)
VALUES ('Asen Asenov', 'natural', 3);

INSERT INTO IVAN_BANCHEV.INDIVIDUAL (NAME, TYPE, COMPANYID)
VALUES ('Ivan Konev', 'natural', 3);

INSERT INTO IVAN_BANCHEV.INDIVIDUAL (NAME, TYPE, COMPANYID)
VALUES ('Daniel Danailov', 'natural', 43);

INSERT INTO IVAN_BANCHEV.INDIVIDUAL (NAME, TYPE, COMPANYID)
VALUES ('Dimitar Dimitrov', 'legal', 43);

INSERT INTO IVAN_BANCHEV.INDIVIDUAL (NAME, TYPE, COMPANYID)
VALUES ('Georgi Dimitrov', 'natural', 43);

INSERT INTO IVAN_BANCHEV.INDIVIDUAL (NAME, TYPE, COMPANYID)
VALUES ('Fani Nakova', 'legal', 43);

INSERT INTO IVAN_BANCHEV.INDIVIDUAL (NAME, TYPE, COMPANYID)
VALUES ('Yanka Takeva', 'legal', 43);

INSERT INTO IVAN_BANCHEV.INDIVIDUAL (NAME, TYPE, COMPANYID)
VALUES ('Stefka Ibrishimova', 'natural', 41);

INSERT INTO IVAN_BANCHEV.INDIVIDUAL (NAME, TYPE, COMPANYID)
VALUES ('Ivan Vasilev', 'legal', 41);

INSERT INTO IVAN_BANCHEV.INDIVIDUAL (NAME, TYPE, COMPANYID)
VALUES ('Tancho Georgiev', 'legal', 41);

INSERT INTO IVAN_BANCHEV.INDIVIDUAL (NAME, TYPE, COMPANYID)
VALUES ('Dani Georgiev', 'legal', 41);

INSERT INTO IVAN_BANCHEV.INDIVIDUAL (NAME, TYPE, COMPANYID)
VALUES ('Katia Vasileva', 'legal', 41);

INSERT INTO IVAN_BANCHEV.INDIVIDUAL (NAME, TYPE, COMPANYID)
VALUES ('Tsvetomira Tsankova', 'natural', 41);

INSERT INTO IVAN_BANCHEV.INDIVIDUAL (NAME, TYPE, COMPANYID)
VALUES ('Asq Asenova', 'natural', 46);

INSERT INTO IVAN_BANCHEV.INDIVIDUAL (NAME, TYPE, COMPANYID)
VALUES ('Ivanka Koleva', 'natural', 48);

INSERT INTO IVAN_BANCHEV.INDIVIDUAL (NAME, TYPE, COMPANYID)
VALUES ('Sofia Ibrishimova', 'natural', 42);

INSERT INTO IVAN_BANCHEV.INDIVIDUAL (NAME, TYPE, COMPANYID)
VALUES ('Ivanka Vasileva', 'legal', 42);

INSERT INTO IVAN_BANCHEV.INDIVIDUAL (NAME, TYPE, COMPANYID)
VALUES ('Tania Georgieva', 'natural', 44);

INSERT INTO IVAN_BANCHEV.INDIVIDUAL (NAME, TYPE, COMPANYID)
VALUES ('Daniela Georgieva', 'legal', 44);

INSERT INTO IVAN_BANCHEV.INDIVIDUAL (NAME, TYPE, COMPANYID)
VALUES ('Katia Velikova', 'legal', 45);

INSERT INTO IVAN_BANCHEV.INDIVIDUAL (NAME, TYPE, COMPANYID)
VALUES ('Sonya Ibrishimova', 'natural', 45);

INSERT INTO IVAN_BANCHEV.INDIVIDUAL (NAME, TYPE, COMPANYID)
VALUES ('Fani Vasileva', 'legal', 46);

INSERT INTO IVAN_BANCHEV.INDIVIDUAL (NAME, TYPE, COMPANYID)
VALUES ('Pepa Georgieva', 'legal', 47);

INSERT INTO IVAN_BANCHEV.INDIVIDUAL (NAME, TYPE, COMPANYID)
VALUES ('Yoana Georgieva', 'natural', 47);

INSERT INTO IVAN_BANCHEV.INDIVIDUAL (NAME, TYPE, COMPANYID)
VALUES ('Nadia Velikova', 'legal', 48);

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (41, 1234.56, TO_DATE('2020-02-11 12:34:00', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (61, 9389.24, TO_DATE('2016-04-07', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (41, 4567.87, TO_DATE('2020-02-13', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (62, 2121.54, TO_DATE('2012-02-17', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (63, 7945.24, TO_DATE('2018-04-11', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (64, 2885.17, TO_DATE('2013-12-27', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (65, 5775.92, TO_DATE('2022-02-23', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (66, 1334.04, TO_DATE('2017-03-25', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (67, 7933.96, TO_DATE('2012-04-13', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (68, 9634.68, TO_DATE('2017-08-14', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (69, 8917.20, TO_DATE('2016-05-10', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (70, 1225.70, TO_DATE('2018-12-03', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (71, 1069.56, TO_DATE('2012-03-29', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (72, 6124.32, TO_DATE('2018-03-30', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (73, 3377.97, TO_DATE('2017-03-02', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (74, 6781.49, TO_DATE('2015-06-02', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (75, 7084.62, TO_DATE('2018-10-25', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (76, 9982.47, TO_DATE('2022-09-19', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (77, 4156.04, TO_DATE('2012-09-17', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (78, 1712.59, TO_DATE('2017-12-23', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (79, 4321.89, TO_DATE('2012-05-25', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (80, 9563.94, TO_DATE('2019-10-27', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (81, 4567.34, TO_DATE('2011-02-16', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (82, 5344.46, TO_DATE('2013-12-16', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (83, 9229.04, TO_DATE('2016-09-16', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (84, 4113.26, TO_DATE('2021-01-04', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (85, 9902.65, TO_DATE('2011-08-23', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (86, 2142.95, TO_DATE('2018-06-19', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (87, 7243.38, TO_DATE('2011-12-15', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (88, 6846.15, TO_DATE('2016-03-05', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (89, 4100.13, TO_DATE('2017-01-11', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (41, 4532.89, TO_DATE('2017-04-11', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (41, 7900.99, TO_DATE('2022-09-08', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (61, 2557.09, TO_DATE('2015-01-28', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (62, 8363.28, TO_DATE('2015-07-15', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (63, 8971.05, TO_DATE('2017-04-14', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (64, 5397.71, TO_DATE('2014-08-15', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (65, 3279.04, TO_DATE('2010-09-23', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (66, 7495.87, TO_DATE('2017-05-24', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (67, 2444.07, TO_DATE('2016-04-13', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (68, 6275.71, TO_DATE('2014-04-28', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (69, 6925.51, TO_DATE('2015-06-15', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (70, 4087.64, TO_DATE('2020-11-08', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (71, 4711.73, TO_DATE('2012-11-30', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (72, 3787.77, TO_DATE('2018-10-14', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (73, 3202.80, TO_DATE('2017-06-20', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (74, 6987.82, TO_DATE('2020-09-21', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (75, 5534.95, TO_DATE('2021-10-12', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (76, 3460.57, TO_DATE('2011-01-22', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (77, 3620.97, TO_DATE('2019-12-09', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (78, 6002.64, TO_DATE('2015-11-02', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (79, 7702.27, TO_DATE('2015-01-04', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (80, 9461.29, TO_DATE('2016-01-27', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (81, 4631.07, TO_DATE('2018-05-23', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (82, 1328.38, TO_DATE('2010-11-14', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (83, 3428.56, TO_DATE('2014-11-10', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (84, 2086.07, TO_DATE('2021-04-25', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (85, 5469.30, TO_DATE('2012-04-09', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (86, 9928.17, TO_DATE('2015-08-11', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (87, 1566.83, TO_DATE('2019-03-02', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (88, 6884.57, TO_DATE('2013-11-27', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (89, 3228.36, TO_DATE('2011-06-10', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (41, 5278.90, TO_DATE('2015-08-11', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (41, 3568.26, TO_DATE('2013-07-23', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (61, 2154.45, TO_DATE('2011-04-15', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (62, 2751.94, TO_DATE('2019-10-24', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (63, 8007.20, TO_DATE('2012-05-14', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (64, 3496.58, TO_DATE('2020-10-12', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (65, 2388.44, TO_DATE('2016-01-31', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (66, 4491.81, TO_DATE('2015-08-09', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (67, 2989.65, TO_DATE('2010-08-19', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (68, 3398.91, TO_DATE('2012-11-21', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (69, 9827.27, TO_DATE('2016-10-07', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (70, 3914.87, TO_DATE('2017-01-03', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (71, 5703.74, TO_DATE('2020-10-21', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (72, 7640.61, TO_DATE('2012-01-21', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (73, 8693.71, TO_DATE('2015-04-23', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (74, 1375.03, TO_DATE('2020-11-25', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (75, 9738.95, TO_DATE('2013-07-02', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (76, 5298.46, TO_DATE('2022-02-18', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (77, 2025.93, TO_DATE('2022-09-11', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (78, 6966.12, TO_DATE('2022-01-05', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (79, 6808.75, TO_DATE('2021-05-10', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (80, 7687.95, TO_DATE('2018-11-03', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (81, 8155.05, TO_DATE('2012-12-31', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (82, 7008.38, TO_DATE('2010-10-26', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (83, 8714.27, TO_DATE('2019-03-15', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (84, 9633.37, TO_DATE('2018-06-16', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (85, 5251.58, TO_DATE('2021-10-19', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (86, 7130.84, TO_DATE('2010-08-28', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (87, 3312.37, TO_DATE('2012-04-18', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (88, 1442.60, TO_DATE('2012-04-30', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (89, 7538.58, TO_DATE('2019-04-13', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (61, 9389.24, TO_DATE('2016-04-07', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (41, 1234.56, TO_DATE('2020-01-10 02:00:00', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (41, 1234.56, TO_DATE('2022-08-10 03:00:00', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (61, 9389.24, TO_DATE('2016-04-07', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (41, 1234.56, TO_DATE('2022-08-10', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (41, 1234.56, TO_DATE('2022-08-10', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (41, 3787.77, TO_DATE('2018-12-14 10:50:00', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.INVOICES (INDIVID, AMOUNT, ISSUE_DATE) VALUES (67, 7933.96, TO_DATE('2012-04-13', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO IVAN_BANCHEV.REFERENCES (EXT_REF, INDIVID)
VALUES (3234, 41);

INSERT INTO IVAN_BANCHEV.REFERENCES (EXT_REF, INDIVID)
VALUES (5678, 67);

INSERT INTO IVAN_BANCHEV.REFERENCES (EXT_REF, INDIVID)
VALUES (7057, 41);

INSERT INTO IVAN_BANCHEV.REFERENCES (EXT_REF, INDIVID)
VALUES (1914, 61);

INSERT INTO IVAN_BANCHEV.REFERENCES (EXT_REF, INDIVID)
VALUES (2635, 62);

INSERT INTO IVAN_BANCHEV.REFERENCES (EXT_REF, INDIVID)
VALUES (5656, 63);

INSERT INTO IVAN_BANCHEV.REFERENCES (EXT_REF, INDIVID)
VALUES (5151, 64);

INSERT INTO IVAN_BANCHEV.REFERENCES (EXT_REF, INDIVID)
VALUES (4278, 65);

INSERT INTO IVAN_BANCHEV.REFERENCES (EXT_REF, INDIVID)
VALUES (6038, 66);

INSERT INTO IVAN_BANCHEV.REFERENCES (EXT_REF, INDIVID)
VALUES (8893, 67);

INSERT INTO IVAN_BANCHEV.REFERENCES (EXT_REF, INDIVID)
VALUES (5088, 68);

INSERT INTO IVAN_BANCHEV.REFERENCES (EXT_REF, INDIVID)
VALUES (9490, 69);

INSERT INTO IVAN_BANCHEV.REFERENCES (EXT_REF, INDIVID)
VALUES (2645, 70);

INSERT INTO IVAN_BANCHEV.REFERENCES (EXT_REF, INDIVID)
VALUES (9351, 71);

INSERT INTO IVAN_BANCHEV.REFERENCES (EXT_REF, INDIVID)
VALUES (3178, 72);

INSERT INTO IVAN_BANCHEV.REFERENCES (EXT_REF, INDIVID)
VALUES (7926, 73);

INSERT INTO IVAN_BANCHEV.REFERENCES (EXT_REF, INDIVID)
VALUES (7308, 74);

INSERT INTO IVAN_BANCHEV.REFERENCES (EXT_REF, INDIVID)
VALUES (3588, 75);

INSERT INTO IVAN_BANCHEV.REFERENCES (EXT_REF, INDIVID)
VALUES (4748, 76);

INSERT INTO IVAN_BANCHEV.REFERENCES (EXT_REF, INDIVID)
VALUES (5890, 77);

INSERT INTO IVAN_BANCHEV.REFERENCES (EXT_REF, INDIVID)
VALUES (6254, 78);

INSERT INTO IVAN_BANCHEV.REFERENCES (EXT_REF, INDIVID)
VALUES (4643, 79);

INSERT INTO IVAN_BANCHEV.REFERENCES (EXT_REF, INDIVID)
VALUES (1224, 80);

INSERT INTO IVAN_BANCHEV.REFERENCES (EXT_REF, INDIVID)
VALUES (4133, 81);

INSERT INTO IVAN_BANCHEV.REFERENCES (EXT_REF, INDIVID)
VALUES (9580, 82);

INSERT INTO IVAN_BANCHEV.REFERENCES (EXT_REF, INDIVID)
VALUES (2970, 83);

INSERT INTO IVAN_BANCHEV.REFERENCES (EXT_REF, INDIVID)
VALUES (2136, 84);

INSERT INTO IVAN_BANCHEV.REFERENCES (EXT_REF, INDIVID)
VALUES (8204, 85);

INSERT INTO IVAN_BANCHEV.REFERENCES (EXT_REF, INDIVID)
VALUES (3229, 86);

INSERT INTO IVAN_BANCHEV.REFERENCES (EXT_REF, INDIVID)
VALUES (4523, 87);

INSERT INTO IVAN_BANCHEV.REFERENCES (EXT_REF, INDIVID)
VALUES (8306, 88);

INSERT INTO IVAN_BANCHEV.REFERENCES (EXT_REF, INDIVID)
VALUES (1302, 89);

