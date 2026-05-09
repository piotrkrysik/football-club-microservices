-- 1. Tworzenie tabel (Struktura)
CREATE TABLE `team` (
                        `id`   int NOT NULL AUTO_INCREMENT,
                        `logo` varchar(255) NOT NULL,
                        `name` varchar(255) NOT NULL,
                        PRIMARY KEY (`id`)
);

CREATE TABLE `coach` (
                         `id`        int NOT NULL AUTO_INCREMENT,
                         `first_name` varchar(255) NOT NULL,
                         `last_name`  varchar(255) NOT NULL,
                         PRIMARY KEY (`id`)
);

CREATE TABLE `player` (
                          `id`          int NOT NULL AUTO_INCREMENT,
                          `photo_url`    varchar(255) NOT NULL,
                          `market_value` float DEFAULT NULL,
                          `name`        varchar(255) NOT NULL,
                          `coach_id` int DEFAULT NULL,
                          PRIMARY KEY (`id`)
);

CREATE TABLE `player_team` (
                               `player_id` int DEFAULT NULL,
                               `team_id`   int DEFAULT NULL
);

-- 2. Dane dla Trenerów (Coach)
INSERT INTO `coach` (`id`, `first_name`, `last_name`)
VALUES (1, 'Carlo', 'Ancelotti'),
       (2, 'Pep', 'Guardiola'),
       (3, 'Jurgen', 'Klopp'),
       (4, 'Hansi', 'Flick');

-- 3. Dane dla Drużyn (Team)
INSERT INTO `team` (`id`, `name`, `logo`)
VALUES (1, 'Real Madrid', 'https://tmssl.akamaized.net//images/wappen/head/418.png?lm=1729684474'),
       (2, 'Manchester City', 'https://tmssl.akamaized.net//images/wappen/head/281.png?lm=1467356331'),
       (3, 'Liverpool FC', 'https://tmssl.akamaized.net//images/wappen/big/31.png?lm=1727873452'),
       (4, 'FC Barcelona', 'https://tmssl.akamaized.net//images/wappen/head/131.png?lm=1406739548');

-- 4. Dane dla Piłkarzy (Player)
-- director_id wskazuje na ID trenera z tabeli coach
INSERT INTO `player` (`id`, `name`, `photo_url`, `market_value`, `coach_id`)
VALUES (1, 'Vinicius Jr', 'https://img.a.transfermarkt.technology/portrait/big/371998-1761575144.jpg?lm=1', 180.5, 1),
       (2, 'Kylian Mbappe', 'https://img.a.transfermarkt.technology/portrait/big/342229-1682683695.jpg?lm=1', 190.0, 1),
       (3, 'Erling Haaland', 'https://img.a.transfermarkt.technology/portrait/big/418560-1709108116.png?lm=1', 200.0, 2),
       (4, 'Rodri', 'https://img.a.transfermarkt.technology/portrait/big/357565-1682587890.jpg?lm=1', 130.0, 2),
       (5, 'Mohamed Salah', 'https://img.a.transfermarkt.technology/portrait/big/148455-1727337594.jpg?lm=1', 65.0, 3),
       (6, 'Virgil van Dijk', 'https://img.a.transfermarkt.technology/portrait/big/139208-1702049837.jpg?lm=1', 30.0, 3),
       (7, 'Robert Lewandowski', 'https://img.a.transfermarkt.technology/portrait/big/38253-1760445524.jpg?lm=1', 15.0, 4),
       (8, 'Lamine Yamal', 'https://img.a.transfermarkt.technology/portrait/big/937958-1746563945.jpg?lm=1', 120.0, 4);

-- 5. Relacja Piłkarz - Drużyna (Player_Team)
INSERT INTO `player_team` (`player_id`, `team_id`)
VALUES (1, 1), (2, 1), -- Real Madrid
       (3, 2), (4, 2), -- Man City
       (5, 3), (6, 3), -- Liverpool
       (7, 4), (8, 4); -- Barcelona

-- 6. Użytkownicy i Role (Bez zmian w strukturze)
CREATE TABLE user (
                      id       int primary key auto_increment,
                      username VARCHAR(255),
                      password VARCHAR(255)
);

CREATE TABLE role (
                      id       int primary key auto_increment,
                      username VARCHAR(255),
                      role     VARCHAR(255)
);

INSERT INTO user(username, password)
VALUES ('dbuser1', 'dbuser1'),
       ('dbuser2', 'dbuser2'),
       ('dbuser3', 'dbuser3');

INSERT INTO role(username, role)
VALUES ('dbuser1', 'ROLE_ADMIN'),
       ('dbuser2', 'ROLE_AUTHOR_ADMIN'),
       ('dbuser3', 'ROLE_BOOK_ADMIN');