package com.lntellimed.config;

 import com.lntellimed.examplebeans.FakeDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;
 import org.springframework.context.annotation.PropertySource;
 import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

 @Configuration
 @PropertySource("classpath:datasource.properties")
 public class PropertyConfig {
	 
	 @Autowired
	 Environment env;

     @Value("${db.username}")
     String user;

     @Value("${db.password}")
     String password;

     @Value("${db.url}")
     String url;

     @Bean
     public FakeDataSource fakeDataSource(){
         FakeDataSource fakeDataSource = new FakeDataSource();
         fakeDataSource.setUser(user);
         if (env.getProperty("DB_PASSWORD") == null) {
        	 fakeDataSource.setPassword(password);
         } else {
        	 fakeDataSource.setPassword(env.getProperty("DB_PASSWORD"));
         }
         
         fakeDataSource.setUrl(url);
         return fakeDataSource;
     }

     @Bean
     public static PropertySourcesPlaceholderConfigurer properties(){
         PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
         return  propertySourcesPlaceholderConfigurer;
     }
 }