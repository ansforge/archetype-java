/**
 * (c) Copyright 1998-2021, ANS. All rights reserved.
 */
#set( $dollar = '$' )
#set( $pound = '#' )
#set( $escape = '\' )
package ${package}.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;

@Configuration
@Profile("test")
public class TestConfig {

	@Bean
	Jackson2ObjectMapperFactoryBean objectMapperFactoryBean() {
		Jackson2ObjectMapperFactoryBean bean = new Jackson2ObjectMapperFactoryBean();
		bean.setAutoDetectFields(true);
		return bean;
	}
}
