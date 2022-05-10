# Spring CRUD 구현

## VO 클래스 디자인(추상화, 클래스 선언)

## 입력 Form 화면을 디자인
## Form에서 데이터를 입력하고 전송 데이터 유효성 검사
* Form에서 입력한 데이터를 유효성 검사를 수행하는 것은 서버로 데이터 보내기 전에 입력한 사용자에게 데이터가 잘 입력되었나 확인시키는 절차
* Client Side Validation 라고 하는데 보통 이때 JS코드로 수행한다
* 데이터를 입력하고 저장(전송) button click하면 Form에 담긴 데이터는 무조건 서버로 전송이 된다
* 이러한 상황이 되면 JS 코드를 사용하여 Client Size Validation을 수행 할 수 없다
* Form에 포함된 모든 버튼의 기본 속성을 무력화하여 무조건 데이터가 서버로 전송되는 것을 방지시켜야한다
* Form에 포함된 버튼의 기본 속성이란 버튼을 클릭 했을 때 submit event가 자동으로 수행되는 것을 말한다
* 아래와 같이 form tag로 감싸진 button은 클릭했을 때 무조건 form tag의 action 주소로 서버에 요청하도록 사전에 정의되어 있다
* form tag 내의 button에는 submit이라는 default event가 자동으로 설정된다
* 이러한 상황에서는 JS 코드를 사용하여 데이터 유효성 검사를 할 수 없다
* 때문에 button submit event를 무력화 시켜야 한다
```
<form action="/school/score">
		<button class="btn_red">서버로 보내기</button>
</form>
```
* form tag 내의 button은 ```기본 type이 submit```이다
* button을 클릭하면 서버로 무조건 달려가는 event가 실행된다
* 이 button type을 ```type = button```으로 설정하면 submit event가 무력화된다
```
<form action="/school/score">
		<button type="button">서버로 보내기</button>
</form>
```
* 또 다른 방법으로는 form의 submit() event를 가로채는 방법도 있다

## Controller에 데이터 수신 할 method 처리
## Service로 데이터 전송
## Dao를 통해서 DBMS insert 요청

## Dao를 통해서 DBMS에게 Select 요청
## Service에 받고
## Controller로 return
## JSP에 View Rendering 수행