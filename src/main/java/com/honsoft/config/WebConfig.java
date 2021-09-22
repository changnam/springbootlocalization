package com.honsoft.config;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
	@Bean(name = "localeResolver")
	public LocaleResolver localeResolver(){
		CookieLocaleResolver clr = new CookieLocaleResolver();
		clr.setDefaultLocale(Locale.ENGLISH);
		clr.setCookieName("cookie_lang");
		return clr;
	}

//	@Bean
//	public LocaleResolver fixedLocalResolver() {
//		FixedLocaleResolver flr = new FixedLocaleResolver();
//		flr.setDefaultLocale(Locale.US);
//		
//		return flr;
//	}
	
//	@Bean
//	public LocaleResolver sessionLocaleResolver() {
//		SessionLocaleResolver slr = new SessionLocaleResolver();
//		slr.setDefaultLocale(Locale.ENGLISH);
//		
//		return slr;
//	}
//	
	@Bean
	public LocaleChangeInterceptor lcaleChangeInterceptor() {
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		lci.setParamName("localeData");
		
		return lci;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(lcaleChangeInterceptor());
		
		//WebMvcConfigurer.super.addInterceptors(registry);
	}
	
	@Bean
	public MessageSourceAccessor messageSourceAccessor(@Qualifier("messageSource") MessageSource messageSource) {
		
	    return new MessageSourceAccessor(messageSource);
	}

}
