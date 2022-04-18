/**
 * (c) Copyright 1998-2021, ANS. All rights reserved.
 */
package ${package}.service;


import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Optional;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ${package}.config.WebAppConfigurationAware;
import ${package}.dto.PersonneDto;
import ${package}.service.PersonneQuery;

@lombok.extern.slf4j.Slf4j
public class PersonneQueryTest extends WebAppConfigurationAware {
	
	@Autowired
	private PersonneQuery personneQuery;
	
	@BeforeEach
	public void setUp() throws Exception {
				
	}

	@Test
	public void findOneByNumeroCarteTest() throws Exception {
		
		Optional<PersonneDto> optional = personneQuery.getByName("VANKENHOVE");
		assertTrue(optional.isPresent(), "personne cannot be empty at this point");
		optional.ifPresent(dto -> {
			log.info(ToStringBuilder.reflectionToString(dto, ToStringStyle.MULTI_LINE_STYLE));
			assertTrue(dto.getNomPatronymique() != null, "name in personne must be filled");
			
		});
	}

}
