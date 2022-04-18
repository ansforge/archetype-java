/**
 * (c) Copyright 1998-2021, ANS. All rights reserved.
 */
#set( $dollar = '$' )
#set( $pound = '#' )
#set( $escape = '\' )
package ${package}.web.rest;

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

import com.fasterxml.jackson.core.JsonProcessingException;

import ${package}.config.WebAppConfigurationAware;

/**
 * @author lcharrier
 *
 */
class PersonneQueryResourceTest extends WebAppConfigurationAware {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * Test method for {@link ${package}.web.rest.PersonneQueryResource${pound}getPersonne(${package}.web.rest.PersonneQueryResource.IdDto)}.
	 * @throws Exception 
	 * @throws JsonProcessingException 
	 */
	@Test
	void testGetPersonne() throws JsonProcessingException, Exception {
		String name = "VANKENHOVE";
		this.mockMvc
		.perform(get("/api/personne/{id}", name)
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.data", notNullValue()))
		.andExpect(jsonPath("$.data.nomPatronymique").value(name))
		.andExpect(jsonPath("$.data.idPersonne").value(226))
		;
	}

}
