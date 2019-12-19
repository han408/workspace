1. 설치 및 버전

☞ 이클립스 설치
Version: 2019-09 R (4.13.0)

☞ H2 데이터베이스 설치
h2-1.3.176
jdbc:h2:tcp://localhost/~/test
bin/h2.bat 실행

☞ spring tool suite 설치
Version : 3.9.11

2. 소스파일 설명
 - Spring Boot로 프로젝트 구성하여 진행 함
 - 테이블 DDL 파일 (HOUFINCINST.sql / HOUFINCSUPLLIST.sql)
 - 데이터파일 (sample.csv)


 3. 테스트 URL
 - 저장API : http://localhost:8080/InstituteRegist
 - 금융기관 목록 조회 API : http://localhost:8080/InstituteList
 - 년도별 금융기관 합계 출력 API : http://localhost:8080/InstituteSum
 - 년도별 가장 큰 금액 기관명 출력 API : http://localhost:8080/InstituteMax
 - 전체년도 기관별 평균 금액 중 MIN/MAX 출력 API : http://localhost:8080/InstituteMinMax