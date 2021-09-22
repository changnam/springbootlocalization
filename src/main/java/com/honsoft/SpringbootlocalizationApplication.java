package com.honsoft;

import java.util.Locale;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication
public class SpringbootlocalizationApplication {
	private static Logger logger = LoggerFactory.getLogger(SpringbootlocalizationApplication.class);
	
	@Autowired
	private MessageSource messageSource;

	public SpringbootlocalizationApplication(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	public static void main(String[] args) {
		
		SpringApplication.run(SpringbootlocalizationApplication.class, args);
	}

	@PostConstruct
	public void init() {
	    //String city=zipCodeLookupService.retriveCityForZip(args[0]);
	    //System.out.println("city for zipcode " + args[0] + " is " +city); 
	    logger.info(messageSource.getMessage("hello", null, Locale.KOREAN));
	}

}
