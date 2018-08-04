package com.learn.prateek.webserviceapp.hello;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	/* Define MessageSource object to read message source that we have configures in WebServiceApp.java. To automatically 
	 * connect it to the bean that we have defined in WebServiceApp.java , we have used @Autowired
	 */
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping(path="/hello-world")
	public String helloWorld()
	{
		return "Hello World";
	}
	
	@GetMapping( path="/hello-world-bean")
	public HelloWorldBean getHelloWorldBean()
	{
		return new HelloWorldBean("Hello World bean");
	}
	
	@GetMapping( path="/hello-world/{name}" )
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name)
	{
		return new HelloWorldBean(String.format("Hello World, %s ", name));
	}
	
	/*** Hello world service according to locale that we have configures in WebServiceApp.java ***/
	@GetMapping( path="/hello-world-i18n" )
	public String helloWorldInternationalized()
	{
		return messageSource.getMessage("greeting.message.hello", null, LocaleContextHolder.getLocale());
	}
}
 