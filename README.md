# **💻** Shiftworks (2022)

***KOSTA FINAL PROJECT - 1차 / [포트폴리오](https://docs.google.com/presentation/d/1mwzoWcrF-YmYtobXlks01ZUQAqpD0xYfLgqcOwehdrc/edit?usp=sharing)***

- 참여인원: 6명
- 프로젝트 기간: 221024 - 221110(3주)
- 프로젝트 주제: 교대근무 협업을 위한 그룹웨어 웹 애플리케이션 개발
- 프로젝트 개요: 팀원들의 교대근무 경험을 바탕으로 유동적인 근무 시간으로 인한 일정 관리 및 협업의 어려움이라는 개선점을 도출, 이를 해결할 수 있는 그룹웨어 시스템 개발을 목표로 함

## 담당역할

✔ 각 팀원의 이름을 클릭하면 개인 리포지토리로 이동합니다. (팀원 이름 ㄱ-ㅎ 순)

### [👸 권해림](https://github.com/podo9264/shiftworks)

- Project Master: 프로젝트 총괄, 프로젝트 일정 관리
- 메신저(채팅) 기능 구현
    - [Controller](https://github.com/cocobini/shiftworks/blob/master/src/main/java/org/shiftworks/controller/ChatRoomController.java)
    - [SQL Mapper](https://github.com/cocobini/shiftworks/blob/master/src/main/resources/org/shiftworks/mapper/ChatMapper.xml)
    - [View](https://github.com/cocobini/shiftworks/blob/master/src/main/webapp/WEB-INF/views/messenger/MSG_main.jsp)

### [👱‍♀️ 김수진](https://github.com/sooosujin/shiftworks)

- 애자일 스크럼 담당: 애자일 방식의 스크럼 회의 진행 및 Jira 관리
- 전자결재 기능 구현
    - [Controller](https://github.com/cocobini/shiftworks/blob/master/src/main/java/org/shiftworks/controller/ApprovalController.java)
    - [SQL Mapper](https://github.com/cocobini/shiftworks/blob/master/src/main/resources/org/shiftworks/mapper/ApprovalMapper.xml)
    - [View](https://github.com/cocobini/shiftworks/blob/master/src/main/webapp/WEB-INF/views/approval/APR_list.jsp)

### [👱‍♀️ 유지영](https://github.com/jyjyu1204/shiftworks)

- 문서 담당: 회의와 프로젝트 진행 내용 기록 및 문서화, 보관 작업
- 로그인 및 계정관리 기능 구현
    - [Controller](https://github.com/cocobini/shiftworks/blob/master/src/main/java/org/shiftworks/controller/EmployeeController.java)
    - [SQL Mapper](https://github.com/cocobini/shiftworks/blob/master/src/main/resources/org/shiftworks/mapper/EmployeeMapper.xml)
    - [View(Login)](https://github.com/cocobini/shiftworks/blob/master/src/main/webapp/WEB-INF/views/customLogin.jsp)
    - [View(Account)](https://github.com/cocobini/shiftworks/blob/master/src/main/webapp/WEB-INF/views/manager/MGR_list.jsp)

### [👱‍♀️ 이지현](https://github.com/jh1359753/shiftworks)

- UI 담당: 메인페이지 및 전체 UI 템플릿 설계 및 구현
- 메인페이지 및 UI 구현
    - [View(Main Page)](https://github.com/cocobini/shiftworks/blob/master/src/main/webapp/WEB-INF/views/home.jsp)
    - [View(UI)](https://github.com/cocobini/shiftworks/blob/master/src/main/webapp/WEB-INF/views/includes/header.jsp)
- 자원관리 기능 구현
    - [Controller](https://github.com/cocobini/shiftworks/blob/master/src/main/java/org/shiftworks/controller/BookingController.java)
    - [SQL Mapper](https://github.com/cocobini/shiftworks/blob/master/src/main/resources/org/shiftworks/mapper/BookingMapper.xml)
    - [View](https://github.com/cocobini/shiftworks/blob/master/src/main/webapp/WEB-INF/views/booking/BOK_myList.jsp)

### [👱‍♀️ 이채빈](https://github.com/chaebini/shiftworks)

- Git 담당: Github을 통한 형상관리 총괄
- 로그인 기능 구현
    - [Controller](https://github.com/cocobini/shiftworks/blob/master/src/main/java/org/shiftworks/controller/EmployeeController.java)
    - [SQL Mapper](https://github.com/cocobini/shiftworks/blob/master/src/main/resources/org/shiftworks/mapper/EmployeeMapper.xml)
- 업무관리 기능 구현
    - [Controller](https://github.com/cocobini/shiftworks/blob/master/src/main/java/org/shiftworks/controller/TaskController.java)
    - [SQL Mapper](https://github.com/cocobini/shiftworks/blob/master/src/main/resources/org/shiftworks/mapper/TaskMapper.xml)
    - [View](https://github.com/cocobini/shiftworks/blob/master/src/main/webapp/WEB-INF/views/task/TSK_list.jsp)
- 일정관리 기능 구현
    - [Controller](https://github.com/cocobini/shiftworks/blob/master/src/main/java/org/shiftworks/controller/ScheduleController.java)
    - [SQL Mapper](https://github.com/cocobini/shiftworks/blob/master/src/main/resources/org/shiftworks/mapper/ScheduleMapper.xml)
    - [View](https://github.com/cocobini/shiftworks/blob/master/src/main/webapp/WEB-INF/views/schedule/SCH_list.jsp)
- 알림 기능 구현
    - [SQL Mapper](https://github.com/cocobini/shiftworks/blob/master/src/main/resources/org/shiftworks/mapper/AlarmMapper.xml)

### [👱‍♀️ 조현수](https://github.com/brightvvater/shiftworks)

- DB 담당: 관계형 데이터베이스 설계 및 구축, 관리
- 게시판 기능 구현
    - [Controller](https://github.com/cocobini/shiftworks/blob/master/src/main/java/org/shiftworks/controller/PostController.java)
    - [SQL Mapper](https://github.com/cocobini/shiftworks/blob/master/src/main/resources/org/shiftworks/mapper/PostMapper.xml)
    - [View](https://github.com/cocobini/shiftworks/blob/master/src/main/webapp/WEB-INF/views/board/BOA_list.jsp)
- 문서함 기능 구현
    - [Controller](https://github.com/cocobini/shiftworks/blob/master/src/main/java/org/shiftworks/controller/DocumentController.java)
    - [SQL Mapper](https://github.com/cocobini/shiftworks/blob/master/src/main/resources/org/shiftworks/mapper/DocumentMapper.xml)
    - [View](https://github.com/cocobini/shiftworks/blob/master/src/main/webapp/WEB-INF/views/document/DOC_mydoclist.jsp)
- 첨부파일 - DB CRD 구현
    - [SQL Mapper](https://github.com/cocobini/shiftworks/blob/master/src/main/resources/org/shiftworks/mapper/FileMapper.xml)

---

## 개발환경

![개발환경1](/img/readme1.png)

![개발환경2](/img/readme2.png)

![REST API](/img/readme3.png)

![MVC 아키텍처](/img/readme4.png)

---

## 프로젝트 진행 방식

### 🕐 애자일 스크럼 활용

👉 매일 개발을 시작하기에 앞서 스크럼보드 앞에서 15분간 회의를 진행<br>
👉 모든 팀원이 참석해야 하며 한 사람씩 전일 한 일, 오늘 진행할 일, 이슈에 대해 공유<br>
👉 Jira를 통해 Issue, Task 관리<br>

![애자일 - Jira 칸반보드](/img/readme5.png)

### 🕑 Git-Flow, Upstream Repository를 활용한 형상관리(Git/Github 사용)

![Git Repository](/img/readme6.png)

---

## Sample

![Sample1](/img/readme8.png)

![Sample2](/img/readme7.png)

![Sample3](/img/swagger.png)

🎞더 자세한 내용은 [포트폴리오](https://docs.google.com/presentation/d/1mwzoWcrF-YmYtobXlks01ZUQAqpD0xYfLgqcOwehdrc/edit?usp=sharing)에서 확인하실 수 있습니다.
