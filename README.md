# ToDoAPi

## 기술스택

- Spring Boot
- JPA
- Mustache
- BootStrap5
- MySql
- H2
- AWS EC2
- RDS
- ~~Cafe24 [중지]~~

## 요구사항 정의

```markup
1. 사용자는 할 일을 등록/수정/삭제 할 수 있다.
2. 사용자는 할 일의 완료 여부 확인 및 변경, 검색을 할 수 있다.
3. 사용자는 소요시간을 조회할 수 있다. 
```

## 추가 목표

- 스프링 부트의 RestMapping을 통해 CRUD기능을 만들어 본다.
- JPA을 토대로 H2 인메모리 데이터베이스의 테이블에 데이터를 insert/delete/update/select할 수 있도록 테스팅 한 후, mysql로 구현한다.
- 동적으로 날짜계산을 통해 사용자의 소요시간을 조회할 수 있도록 한다.
- Bootstrap의 기능을 다방면으로 활용하여 웹페이지를 가시적으로 구현한다.

## 기능명세

## APi

## ERD

![Untitled Diagram.drawio.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/bcca9b66-f4e7-48b7-be50-319b93876733/Untitled_Diagram.drawio.png)

![스크린샷 2022-04-11 13.15.33.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/05ef21fa-9503-43da-a9ec-99f64a3ad592/스크린샷_2022-04-11_13.15.33.png)

## API Doc.(swagger2)

![스크린샷 2022-04-16 16.10.50.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/092a9bd0-c8d9-43c4-844d-7037a72a3ff5/스크린샷_2022-04-16_16.10.50.png)

## 기능 시연

1. 등록
    
    ![등록.gif](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/c262ae92-f109-4244-b0fc-dfb7d23ee3df/등록.gif)
    

1. 수정
    
    ![수정.gif](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/01cff94d-7e0a-4fe8-8b90-394ae5e70697/수정.gif)
    
2. 완료여부 수정
    
    ![완료여부.gif](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/ef522237-6a15-4f48-8ac7-30803d971d94/완료여부.gif)
    
3. 조회
    
    ![조회.gif](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/74257706-fdc4-484b-8354-4136c080f204/조회.gif)
    
4. 검색
    
    ![검색.gif](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/14f2b1f5-c7a2-452b-8615-27caf2249f8e/검색.gif)
    
5. 삭제
    
    ![삭제.gif](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/b0d2e0ea-2f9d-4fe1-9cbe-d7123772dec8/삭제.gif)
    

## 개발노트

- ‘22.03.23. 깃 리파지토리 생성
- ‘22.03.26. 부트스트랩을 활용하여 웹사이트 구현 ⇒ Bootstrap3로 전박전인 가시적 효과 구현.
- ‘22.03.27. Create/Read api 구현, H2 데이터베이스 연동 ⇒ Dto, Service, Controller, JPA 리파지토리 패키지 생성
- ‘22.03.28. Create/Read ajax 연동 및 웹사이트 등록/조회 게시판 구현 ⇒ jpa auditing 기능으로 최초등록 및 수정시간 DB에 저장.
- ‘22.03.29 Update/Delete api 구현 및 완성여부 구현, 검색기능 및 완료 및 비완료 항목 리스트 구현
- ‘22.03.30 jpa pageable로 페이지네이션 구현.
- ***‘22.04.01 코로나 바이러스 확진(?)***
- ‘22.04.02. 예상종료시간 필드 추가.
- ‘22.04.04.  bootstrap3 → bootstrap5 마이그레이션. 유효성 검사 기능 추가, 툴팁 점목.
- ‘22.04.05 모달 적용
- ~~‘22.04.06 모달 내, 내용 표시 및 스크립트 버그 수정. (모달 이벤트가 2번이나 발생하는 것을 1번으로 줄임) ⇒ 프로젝트 1 종료~~
- ’22.04.07 ~ 09 : 버그 발견 및 수정
- 1. 모달 버그 발견(항목 선택시 처음 눌렀던 항목이 유지된채 변경안됨) ⇒ removeEventListner 삭제후, 모달 이벤트를 shown.bs.Modal에서 show.bs.Modal로 변경하여 사용자가 모달 버튼을 눌렀을 때 표시하도록 변경(이벤트 2번 중복으로 발생하는 것은 불가피하다고 판단.
- 2. 모달 내 수정 버튼 또한 2번 응답하는 버그가 발생. ⇒ 이벤트를 분리하여 동작하도록 변경.
- 3. 모달 셀렉터 역시 1에서 24까지의 옵션이 계속해서 추가되는 버그가 발생 ⇒ html에서 정적으로 생성 후, 이벤트에 따라 동적으로 selected되도록 설정
- ‘22.04.09 : H2데이터베이스에서 mysql로 변경. ~~패키징 방식 jar에서 war로 설정하여 외부 톰캣환경에서 직접 빌드할 수 있도록 설정, jdk11에서 jdk1.8로 다운그레이드(카페24 호스팅을 위함);~~
- - 프로젝트1 종료.
- ~~배포 중 카페24 응답안하는 문제 발생.~~
- ‘22.04.10 : 다시 원점 복귀. jdk 11로 업그레이드, war → jar. aws 배포완료, api 기능 추가.
- ‘22.04.13 : JUnit5을 통해 PostsRepository/Controller 테스팅
- ‘22.04.14 : Swagger 3 → 스프링 부트 2.6.2 호환성 문제 → 스프링부트 2.5.2 마이그레이션, Swagger2 접목.
