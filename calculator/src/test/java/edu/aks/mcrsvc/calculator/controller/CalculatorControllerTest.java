package edu.aks.mcrsvc.calculator.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class CalculatorControllerTest extends AbstractTest {
    @Override
    @Before
    public void setUp () {
        super.setUp ();
    }

    @Test
    public void getSum () throws Exception {
        String uri = "/sum?values=1,2";
        MvcResult mvcResult = mvc.perform ( MockMvcRequestBuilders.get ( uri )
                .accept ( MediaType.APPLICATION_JSON_VALUE ) ).andReturn ();
        int status = mvcResult.getResponse ().getStatus ();
        assertEquals ( 200, status );
        String content = mvcResult.getResponse ().getContentAsString ();
        Double result = super.mapFromJson ( content, Double.class );
        assertNotNull ( result );
    }

    @Test
    public void getDifference () throws Exception {
        String uri = "/substract?values=4,2";
        MvcResult mvcResult = mvc.perform ( MockMvcRequestBuilders.get ( uri )
                .accept ( MediaType.APPLICATION_JSON_VALUE ) ).andReturn ();
        int status = mvcResult.getResponse ().getStatus ();
        assertEquals ( 200, status );
        String content = mvcResult.getResponse ().getContentAsString ();
        Double result = super.mapFromJson ( content, Double.class );
        assertEquals ( new Double ( 2.0 ), result );
    }


    @Test
    public void getMultiply () throws Exception {
        String uri = "/multiply?values=4,2";
        MvcResult mvcResult = mvc.perform ( MockMvcRequestBuilders.get ( uri )
                .accept ( MediaType.APPLICATION_JSON_VALUE ) ).andReturn ();
        int status = mvcResult.getResponse ().getStatus ();
        assertEquals ( 200, status );
        String content = mvcResult.getResponse ().getContentAsString ();
        Double result = super.mapFromJson ( content, Double.class );
        assertEquals ( new Double ( 8.0 ), result );
    }

    @Test
    public void getDivide () throws Exception {
        String uri = "/divide?values=4,2";
        MvcResult mvcResult = mvc.perform ( MockMvcRequestBuilders.get ( uri )
                .accept ( MediaType.APPLICATION_JSON_VALUE ) ).andReturn ();
        int status = mvcResult.getResponse ().getStatus ();
        assertEquals ( 200, status );
        String content = mvcResult.getResponse ().getContentAsString ();
        Double result = super.mapFromJson ( content, Double.class );
        assertEquals ( new Double ( 2.0 ), result );
    }
}
