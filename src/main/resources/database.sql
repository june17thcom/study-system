CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    nickname VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO users (username, password, nickname, email) VALUES
('alice', 'password123', 'Alice', 'alice@example.com'),
('bob', 'password123', 'Bob', 'bob@example.com'),
('charlie', 'password123', 'Charlie', 'charlie@example.com');

CREATE TABLE roles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    role_name VARCHAR(50) NOT NULL UNIQUE
);

INSERT INTO roles (role_name) VALUES
('USER'),
('ADMIN');

CREATE TABLE user_roles (
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY(user_id, role_id),
    FOREIGN KEY(user_id) REFERENCES users(id),
    FOREIGN KEY(role_id) REFERENCES roles(id)
);

-- alice: USER
-- bob: USER, ADMIN
-- charlie: USER
INSERT INTO user_roles (user_id, role_id) VALUES
(1, 1),
(2, 1),
(2, 2),
(3, 1);

CREATE TABLE studies (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description TEXT,
    max_participants INT NOT NULL,
    deadline DATE NOT NULL,
    creator_id BIGINT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (creator_id) REFERENCES users(id)
);

INSERT INTO studies (title, description, max_participants, deadline, creator_id) VALUES
('Java Spring 스터디', '스프링 부트로 API 만들기', 5, '2025-08-15', 1),
('알고리즘 정복', '백준/프로그래머스 같이 풀기', 6, '2025-08-10', 2),
('웹 풀스택 스터디', 'React + Node.js 프로젝트 진행', 4, '2025-08-20', 3);

CREATE TABLE study_applications (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    study_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    applied_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE (study_id, user_id),
    FOREIGN KEY (study_id) REFERENCES studies(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- alice가 2번 스터디 신청
-- bob이 1, 3번 스터디 신청
-- charlie가 1, 2번 스터디 신청
INSERT INTO study_applications (study_id, user_id) VALUES
(2, 1),
(1, 2),
(3, 2),
(1, 3),
(2, 3);
