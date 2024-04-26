package com.prowings.weather.config;
import java.util.Arrays;
import java.util.Properties;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.prowings.weather")
@PropertySource("classpath:Application.properties")
public class WebConfig implements WebMvcConfigurer {
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
		
	}
	
@Bean	
public DozerBeanMapper beanMapper()	{
	
	DozerBeanMapper mapper= new DozerBeanMapper();
	mapper.setMappingFiles(Arrays.asList("dozer_mapping.xml"));
	
	return mapper  ;
	
}
	
	

	public DriverManagerDataSource dataresource() {

		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/Spring_REST_Student");
		ds.setUsername("root");
		ds.setPassword("Pramod@123$");
		return ds;

	}

//	@Bean
//	public LocalSessionFactoryBean Sessionfactory() {
//
//		LocalSessionFactoryBean sessionfactory = new LocalSessionFactoryBean();
//
//		sessionfactory.setDataSource(dataresource());
//		sessionfactory.setPackagesToScan("com.prowings.entity");
//		sessionfactory.setHibernateProperties(readHibernateProp());
//
//		return sessionfactory;
//
//	}

	private Properties readHibernateProp() {

		Properties prop = new Properties();
		prop.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		prop.put("hibernate.show_sql", "true");
		prop.put("hibernate.format_sql", "true");
		prop.put("hibernate.hbm2ddl.auto", "update");

		return prop;

	}


}
