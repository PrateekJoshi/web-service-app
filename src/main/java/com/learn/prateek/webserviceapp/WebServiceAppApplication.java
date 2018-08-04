package com.learn.prateek.webserviceapp;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.LocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class WebServiceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebServiceAppApplication.class, args);
	}
	
	/*** Set SessionLocaleResolver for i18n configuration ***/
	@Bean
	public AcceptHeaderLocaleResolver localeResolver(){
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
	
	/*** We need to read messages.properites and messages_hindi.properties and customize 
	 * them according to accept-language header in request. 
	 ***/
	@Bean
	public ResourceBundleMessageSource bundleMessageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}
	
	
	
}
