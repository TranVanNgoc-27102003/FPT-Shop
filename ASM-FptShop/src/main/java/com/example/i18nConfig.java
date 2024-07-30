package com.example;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


public class i18nConfig implements WebMvcConfigurer{
@Bean("messageSource")
	public MessageSource getMessageSource()
	{
	ReloadableResourceBundleMessageSource ms=new ReloadableResourceBundleMessageSource();
	ms.setDefaultEncoding("utf-8");
	ms.setBasename("classpath:i18n/messages");
	return ms;
	}
}

