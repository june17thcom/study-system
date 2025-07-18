# study-system
스터디 연결 시스템 시험문제

전체 프로젝트 구성  
├── README.md  
├── .gitignore  
├── database.sql  
├── build.gradle (or pom.xml)  
├── src  
│   ├── main  
│   │   ├── java  
│   │   │   └── com.example.studyplatform  
│   │   │       ├── StudyPlatformApplication.java  
│   │   │       ├── config  
│   │   │       │   └── SecurityConfig.java  
│   │   │       ├── controller  
│   │   │       │   ├── AuthController.java  
│   │   │       │   ├── StudyController.java  
│   │   │       │   └── MyPageController.java  
│   │   │       ├── domain  
│   │   │       │   ├── User.java  
│   │   │       │   ├── Role.java  
│   │   │       │   ├── Study.java  
│   │   │       │   └── StudyApplication.java  
│   │   │       ├── mapper  
│   │   │       │   ├── UserMapper.java  
│   │   │       │   ├── StudyMapper.java  
│   │   │       │   └── ApplicationMapper.java  
│   │   │       ├── repository  
│   │   │       │   └── 각 Mapper의 구현은 MyBatis 매핑파일로 대체  
│   │   │       ├── service  
│   │   │       │   ├── UserService.java  
│   │   │       │   ├── StudyService.java  
│   │   │       │   └── ApplicationService.java  
│   │   ├── resources  
│   │   │   ├── application.properties (또는 .yml)  
│   │   │   ├── mapper  
│   │   │   │   ├── user-mapper.xml  
│   │   │   │   ├── study-mapper.xml  
│   │   │   │   └── application-mapper.xml  
│   │   │   └── templates / static (HTML or SPA 포함)  
│   └── test  
│       └── java  
│           └── 테스트 코드  

# Study Platform

스터디를 개설하고 신청할 수 있는 웹 애플리케이션입니다.

## 기술 스택
- Spring Boot
- Spring Security (세션 기반 인증)
- MyBatis
- MySQL
- HTML (또는 SPA)

## 실행 방법
1. `database.sql`로 데이터베이스 테이블 생성
2. `application.properties`에 DB 정보 입력
3. `./gradlew bootRun` 또는 `mvn spring-boot:run`

## 기능 요약
- 회원가입 / 로그인 / 로그아웃
- 스터디 개설 / 목록 / 상세 / 검색 / 신청
- 마이페이지: 내가 만든 스터디 / 신청한 스터디
- 로그인한 사용자만 접근 가능한 기능 접근 제한

// database.sql: 앞서 제공된 스키마 그대로 사용
