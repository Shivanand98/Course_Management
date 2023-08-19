package com.shiv.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

	//"say-hello"=>what we are learning today
	
	//url for this is=http://localhost:8080/say-hello
//	@RequestMapping("say-hello")
//	@ResponseBody//the responsebody annotation returns the method body into the browser
//	public String sayHello() {
//		return "Hello What are you learning today";
//	}
	
	@RequestMapping("say-hello-html")
	@ResponseBody//the responsebody annotation returns the method body into the browser
	public String sayHtml() {
		StringBuffer sb=new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>My first HTML Page</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("My First html page with body");
		sb.append("</body>");
		sb.append("</hrml>");

		return sb.toString();
		//we are hard coding the html page in the java code in this method
	}
	
	//"say-hello-jsp"=>sayhello.jsp
	
	// /src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
//	/src/main/resources/META-INF/resources/WEB-INF/jsp/welcome.jsp
//	/src/main/resources/META-INF/resources/WEB-INF/jsp/login.jsp
//	/src/main/resources/META-INF/resources/WEB-INF/jsp/todos.jsp
	
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp() {
		return "sayHello";
	}
}
