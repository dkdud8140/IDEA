# Java COnfig type Spring Project
* Java 3.x에서 사용하기 시작한 Annotation이 보편화 되면서 Spring framework에서  
    상당부분 context.xml을 사용하지 않고 @Component, @Controller, @Service, @Repository 등등의 Annotation으로 bean 생성을 대신하게 된다
* 하지만 web.xml, applicationContext.xml, dispatcher-servlet.xml 등은 여전히 프로젝트에서 사용을 계속해왔다,
* .xml 방식의 설정에서 사소한 type 오류 (스펠링 오류), tag오류 등으로 프로젝트가 전체적으로 문제를 일으키는 경우가 매우 많다
* ,xml을 사용하지 않는 프로젝트를 만드록자 하여 새롭고 구현된 프로젝트 구조

* java의 class를 사용하여 .xml 파일을 대신하는  프로젝트