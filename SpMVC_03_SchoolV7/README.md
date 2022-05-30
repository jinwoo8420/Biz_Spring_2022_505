# form / button 관계

```
<form>
	<input>
	<button type = "submit">
</form>
```

* 위와 같이 form tag에 포함 된 button은 기본적으로 type이 ```submit```이다
* button type이 ```submit```인 경우 form tag에 포함된 input의 값을 무조건 서버로 전송하는 event가 실행된다
* 만약 button을 클릭했을 때 JS코드를 사용하여 상황을 제어하고 싶으면 button type을 ```button```으로 설정한다
* button type을 ```button```으로 설정하면 모양만 button이고 아무런 역할을 수행하지 못한다
* button type에는 ```reset```도 있는데 이 type은 form tag에 포함된 input box 데이터를 모두 제거한다

## password 암호화 하기
* spring-security-core 가져오기
```
<!-- https://mvnrepository.com/artifact/org.springframework.security/spring-security-core -->
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-core</artifactId>
			<version>5.3.13.RELEASE</version>
		</dependency>
```
* spring/appServlet/security-context.xml 파일 생성
```
	<bean id="passwordEncoder"
		class="org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder">
		<constructor-arg index="0" value="4" />
	</bean>
```
* PasswordEncoder를 상속받은 BCryptPasswordEncoder 클래스를 사용하여 bean 선언
* 이때 생성자에 설정한 value 값에 따라 내부에서 암호화 반복이 수행된다
* value 값은 4 이상의 정수로 설정한다
* 기본값은 4이며 값이 커지면 암호화에서 시간이 많이 소요된다