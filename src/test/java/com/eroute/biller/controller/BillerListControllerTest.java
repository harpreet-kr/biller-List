package com.eroute.biller.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BillerListControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	
	@Test
	public void testGetBillerList() throws Exception {
		 String uri = "/biller-list/search";
	      String inputString = "BSE";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputString)).andReturn();	      
	      int status = mvcResult.getResponse().getStatus();
	      System.out.println("test passed:::" + status);
	      assertEquals(200, status);
	}
	
	@Test
	public void testGetBillerListNotFound() throws Exception {
		 String uri = "/biller-list/search";
	      String inputString = "xyzxyz";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputString)).andReturn();	      
	      int status = mvcResult.getResponse().getStatus();
	      System.out.println("test passed:::" + status);
	      assertEquals(404, status);
	}
	
	@After
	public void tearDown() {
		mvc = null;
	}
	
}
