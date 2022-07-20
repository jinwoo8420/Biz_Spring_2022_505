# tiles를 사용한 JSP Layout
* view page(JSP)의 header, side, footer 등을 include 처리하여 Layout을 구성하는 도구
* JSP page ```<%@ inclue file="..."%>``` 형식으로 JSP 파일을 서로 연결하여 Layout을 구성하는데 성능 상의 이슈 등이 있고 JSP 파일들이 많아지면 관리가 다소 불편해지는 단점이 있다
* 이러한 단점을 극복하고자 사용하는 Layout 도구

```
<!-- https://mvnrepository.com/artifact/org.apache.tiles/tiles-core -->
<dependency>
	<groupId>org.apache.tiles</groupId>
	<artifactId>tiles-core</artifactId>
	<version>${org.tiles-version}</version>
</dependency>

<!-- https://mvnrepository.com/artifact/org.apache.tiles/tiles-extras -->
<dependency>
	<groupId>org.apache.tiles</groupId>
	<artifactId>tiles-extras</artifactId>
	<version>${org.tiles-version}</version>
</dependency>
```