# 부산광역시_부산맛집정보 서비스 OpenAPI 연동
* JSON type으로 데이터 받기

## 부산광역시_부산맛집정보 서비스 API 문제점
* JSON type으로 데이터를 요청하고 RestTemplate를 사용하여 데이터를 변환을 시도했는데 데이터는 분명 JSON type인데 MIME type의 text/plain으로 수신되고 있다
* RestTemplate는 application/json MIME type으로 데이터가 수신되어야 VO, List<VO> type으로 자동 변환을 할 수 있는데 text/plain의 실제 데이터는 JSON 모양이지만 일반 String type의 문자열과 같기 때문에 변환을 할 수 없다
* JS를 사용한다면 JSON.parse("JSON type의 문자열") 함수를 사용하여 쉽게 JSON 객체로 변환 할 수 있지만 JAVA에서는 불가능하다
* RestTemplate 클래스에는 수신된 데이터를 중간에 가로채서 사용자가 임의로 데이터를 변환 할 수 있도록 통로를 만들어놨다
* RestTemplate.intercepter 기능을 활용하면 수신된 데이터를 임의로 조작이 가능하다

## RestTemplate의 interceptor 설정하기

### 클래스 선언 후 실행하기
* ```ClientHttpRequestInterceptor``` 인터페이스를 implements하여 클래스를 선언하고 intercept() method를 재정의하여 강제로 APPLICATION_JSON 형태로 ContentType을 변환하기
* ```HttpInterceptorV1``` 클래스를 정의하고 ```intercept``` method 재정의하기
* 한개의 method를 간단하게 정의하기 위해 굳이 새로운 클래스를 만드는 것은 낭비

### 인터페이스를 사용하여 객체 생성하기
```
ClientHttpRequestInterceptor httpIntercept = new ClientHttpRequestInterceptor() {

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
		throws IOException {
			return null;
		}
	};
```

### 익명 클래스를 사용하여 객체 생성하기
* 일회용 객체를 인터페이스를 직접 사용하여 만들고 직접 주입
* 인스턴스 변수를 생성하지 않음
* 한번만 사용하고 더 이상 사용 할 필요가 없을 경우 활용 방법
* 안드로이드 APP 제작에서 이벤트 핸들러를 만드는 대표적인 방법
```
restTemp.getInterceptors().add(new ClientHttpRequestInterceptor() {

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
		throws IOException {
			ClientHttpResponse response = execution.execute(request, body);
			response.getHeaders().setContentType(MediaType.APPLICATION_JSON);

			return response;
		}
	});
```

### Lambda 코드를 사용하는 객체 주입
* java 1.8 이상에서 사용하는 Lambda 코드
* 인터페이스를 사용하여 Lambda 코드로 주입하기
* 무명 클래스 / 무명 method 방식
* Lambda 코드를 사용하여 무명 클래스 방식으로 주입하면 클래스, 객체, method 이름 생략 가능
```
restTemp.getInterceptors().add((request, body, execution) -> {
	ClientHttpResponse response = execution.execute(request, body);
	response.getHeaders().setContentType(MediaType.APPLICATION_JSON);

	return response;
});
```