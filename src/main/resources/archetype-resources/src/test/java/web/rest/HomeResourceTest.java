/**
 * (c) Copyright 1998-2021, ANS. All rights reserved.
 */
#set( $dollar = '$' )
#set( $pound = '#' )
#set( $escape = '\' )
package ${package}.web.rest;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;

import com.dbs.lib.dto.NetworkTestRequest;

import ${package}.config.WebAppConfigurationAware;

/**
 * @author lcharrier
 *
 */
class HomeResourceTest extends WebAppConfigurationAware {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * Test method for {@link ${package}.web.rest.HomeResource${pound}home()}.
	 * @throws Exception 
	 */
	@Test
	void testHome() throws Exception {
		this.mockMvc
		.perform(get("/"))
		.andDo(print())
		.andExpect(status().is2xxSuccessful())
		.andExpect(content().string(containsString("BEWARE")))
		;
	}

	/**
	 * Test method for {@link ${package}.web.rest.HomeResource${pound}networkTest(com.dbs.lib.dto.NetworkTestRequest, org.springframework.validation.BindingResult)}.
	 * @throws Exception 
	 */
	@Test
	void testNetworkTest() throws Exception {
		NetworkTestRequest request = new NetworkTestRequest("hello world");
		this.mockMvc
		.perform(post("/api/ping")
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.content(objectMapperFactoryBean.getObject().writeValueAsBytes(request))
				)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.msg", notNullValue()))
		.andExpect(jsonPath("$.msg", containsString(request.getMessage())))
		;
	}

}
