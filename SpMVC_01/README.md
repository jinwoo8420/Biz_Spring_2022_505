# @Controller에서 JSP로 데이터 보내기
* @Controller에서 model에 담아서 보내는 Attribute들은 JSP를 rendering 할 때 값을 변수로 변환되어 ${변수명} 형식으로 표시 할 수 있다
* @Controller의 method에서 model.addAttribute() method를 사용하여 변수를 선언하고 JSP로 전달 할 값을 저장 할 수 있다
* @Controller의 method를 선언 할 때 argument로 Model type의 변수를 선언한다
* 선언 된 변수의 addAttribute() method를 사용하여 JSP로 전달 할 값을 설정한다

```
	@RequestMapping()
	public String method(Model model) {
		model.addAttribute("Value", 30);

		return "home";
	}
```

* 위 코드에서 method()의 매개변수로 선언 된 model 변수에 value라는 이름으로 Attribute를 추가하고 value Attribute에 30이라는 값을 설정하였다
* home.jsp 파일이 rendering 될 때 파일의 코드 중에 ```${value}``` 라는 부분이 있으면 30이라는 값으로 대체되어 html 코드가 생성된다

## EL(Expression Lang) tag
* @Controller에서 전달 된 Attribute에 담긴 데이터를 표시하는 용도 : ${변수명}
* 순수 JSP포인트에서는 ```<%=request.getParameter("변수명"); %>``` 처럼 사용하던 코드를 ```${변수명}``` 과 같이 간단한 코드로 대체하였다
* EL tag에서는 4칙연산과 간단한 비교연산, 논리연산을 수행 할 수 있다
