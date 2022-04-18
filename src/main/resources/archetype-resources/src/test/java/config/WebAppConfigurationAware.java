/**
 * (c) Copyright 1998-2021, ANS. All rights reserved.
 */
package ${package}.config;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import ${package}.config.ApplicationConfig;
import ${package}.config.WebServicesConfig;

import javax.xml.xpath.XPathExpressionException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


@ActiveProfiles("test")
@SpringJUnitWebConfig(classes = {
        ApplicationConfig.class,
        EmbeddedDataSourceConfig.class,
        TestConfig.class,
        WebServicesConfig.class
})
@TestPropertySource({"classpath:/application-test.properties"})
public abstract class WebAppConfigurationAware {

    @Autowired
    protected WebApplicationContext wac;
    protected MockMvc mockMvc;

    @Autowired
	protected Jackson2ObjectMapperFactoryBean objectMapperFactoryBean;
    
    @BeforeEach
    public void before() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    /**
     * best way to check or validate xpath on Chrome browser is to use the Development tools JavaScript console and use the command 
     * $x("/html/body//script[@src='/res/jquery/jquery.min.js']")
     * @throws Exception to set
     */
    protected void testElementAvailable(String url, String xpath) throws XPathExpressionException, Exception {
      mockMvc.perform(get(url))
          // .andDo(print())
          .andExpect(xpath(xpath).exists());
    }
}
