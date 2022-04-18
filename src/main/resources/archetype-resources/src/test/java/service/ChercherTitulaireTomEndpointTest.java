/**
 * (c) Copyright 1998-2021, ANS. All rights reserved.
 */
package ${package}.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ${package}.config.WebAppConfigurationAware;
import fr.gipcps.serge.metier.tom.ws.personnes.cherchertitulairetomws.ChercherTitulaireTomWS;

@lombok.extern.slf4j.Slf4j
public class ChercherTitulaireTomEndpointTest extends WebAppConfigurationAware {
	
	@Autowired
	private ChercherTitulaireTomWS chercherTitulaireEndpointService;
	
	@BeforeEach
	public void setUp() throws Exception {
				
	}

	@Test
	public void findOneByNumeroCarteTest() throws Exception {
		
		Integer id = chercherTitulaireEndpointService.obtenirIdPersonne("VANKENHOVE", null);
		assertTrue(id != null, "personne cannot be null at this point");
		assertEquals(226, id);
		
	}
	
	public static final String SERVICE_URL = "http://localhost:8080/smh-gestioncartes/WebServices/chercherTitulaireTomWS";
	
}
