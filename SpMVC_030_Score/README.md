# 성적처리 프로젝트
* SpMVC_030_Score
* base-package : com.callor.score

## DB
* MySQL - schoolDB

## DB table
* tbl_student / tbl_score / tbl_subject

## DB 연결 도구
* spring-jdbc
* commons-dbcp2
* mybatis
* mybatis-spring
* mysql-connector/J
* spring-framework : 5.2.22.REL
* lombok
* logback-classic

## package
* model / persistance 

## mapper folder 생성
* /WEB-INF/spring/mapper

## VO 클래스
* tbl_student / tbl_score / tbl_subject 참조하여 model package => StudentVO / ScoreVO / SubjectVO 생성

## Dao 인터페이스
* persistance.GenericDao interface => selectAll() / findById() / insert() / update() / delete() method 선언

## Student 정보 요청
* http://localhost:8080/score/student => 학생데이터 전체를 JSON 웹 화면에 보여주는 코드 작성
* StudentController => @ResponseBody 부착된 home() method 선언
* StudentService.selectAll()
* StudentDao.selectAll()
* student-mapper.xml.selectAll