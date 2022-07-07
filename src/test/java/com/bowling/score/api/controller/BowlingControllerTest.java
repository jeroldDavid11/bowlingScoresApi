package com.bowling.score.api.controller;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class BowlingControllerTest {
	
	@Autowired
	private MockMvc mockMvc;


	@Test
	public void testCreatedGame() throws Exception 
	{
		mockMvc.perform( MockMvcRequestBuilders
	      .post("/api/games")
	      .content("{\r\n"
	      		+ "	 \"gameName\": \"Bowler1\"\r\n"
	      		+ "}}")
	      .contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON))
	      .andExpect(status().is2xxSuccessful());
	}
	
	@Test
	public void testCreatedGame2() throws Exception 
	{
		mockMvc.perform( MockMvcRequestBuilders
	      .post("/api/games")
	      .content("{\r\n"
	      		+ "	 \"gameName\": \"Bowler2\"\r\n"
	      		+ "}}")
	      .contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON))
	      .andExpect(status().is2xxSuccessful());
	}
	
	@Test
	public void testView() throws Exception 
	{
		mockMvc.perform( MockMvcRequestBuilders
	      .get("/api/games/1")
	      .contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON))
	      .andExpect(status().is2xxSuccessful());
	}
	
	@Test
	public void testPut() throws Exception 
	{
		mockMvc.perform( MockMvcRequestBuilders
	      .put("/api/games/1")
	      .content("{\r\n"
	      		+ "	 \"gameName\": \"Bowler1\"\r\n"
	      		+ "}")
	      .contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON))
	      .andExpect(status().is2xxSuccessful());
	}
	
	@Test
	public void testDelete() throws Exception 
	{
		mockMvc.perform( MockMvcRequestBuilders
	      .delete("/api/games/2")
	      .contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON))
	      .andExpect(status().is2xxSuccessful());
	}
	
	@Test
	public void testCreateFrame() throws Exception 
	{
		mockMvc.perform( MockMvcRequestBuilders
	      .post("/api/games/2/shots")
	      .content("{\r\n"
	      		+ "		 \"bowlShotOne\": \"4\",\r\n"
	      		+ "		 \"bowlShotTwo\": \"3\"\r\n"
	      		+ "}")
	      .contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON))
	      .andExpect(status().is2xxSuccessful());
	}
	
	@Test
	public void testCreateFrame9items() throws Exception 
	{
		mockMvc.perform( MockMvcRequestBuilders
	      .post("/api/games/2/shots")
	      .content("{\r\n"
	      		+ "		 \"bowlShotOne\": \"4\",\r\n"
	      		+ "		 \"bowlShotTwo\": \"3\"\r\n"
	      		+ "}")
	      .contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON))
	      .andExpect(status().is2xxSuccessful());
		
		mockMvc.perform( MockMvcRequestBuilders
			      .post("/api/games/2/shots")
			      .content("{\r\n"
			      		+ "		 \"bowlShotOne\": \"4\",\r\n"
			      		+ "		 \"bowlShotTwo\": \"3\"\r\n"
			      		+ "}")
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().is2xxSuccessful());
		
		mockMvc.perform( MockMvcRequestBuilders
			      .post("/api/games/2/shots")
			      .content("{\r\n"
			      		+ "		 \"bowlShotOne\": \"4\",\r\n"
			      		+ "		 \"bowlShotTwo\": \"3\"\r\n"
			      		+ "}")
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().is2xxSuccessful());
		
		mockMvc.perform( MockMvcRequestBuilders
			      .post("/api/games/2/shots")
			      .content("{\r\n"
			      		+ "		 \"bowlShotOne\": \"4\",\r\n"
			      		+ "		 \"bowlShotTwo\": \"3\"\r\n"
			      		+ "}")
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().is2xxSuccessful());
		
		mockMvc.perform( MockMvcRequestBuilders
			      .post("/api/games/2/shots")
			      .content("{\r\n"
			      		+ "		 \"bowlShotOne\": \"4\",\r\n"
			      		+ "		 \"bowlShotTwo\": \"3\"\r\n"
			      		+ "}")
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().is2xxSuccessful());
		
		mockMvc.perform( MockMvcRequestBuilders
			      .post("/api/games/2/shots")
			      .content("{\r\n"
			      		+ "		 \"bowlShotOne\": \"4\",\r\n"
			      		+ "		 \"bowlShotTwo\": \"3\"\r\n"
			      		+ "}")
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().is2xxSuccessful());
		
		mockMvc.perform( MockMvcRequestBuilders
			      .post("/api/games/2/shots")
			      .content("{\r\n"
			      		+ "		 \"bowlShotOne\": \"4\",\r\n"
			      		+ "		 \"bowlShotTwo\": \"3\"\r\n"
			      		+ "}")
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().is2xxSuccessful());
		
		mockMvc.perform( MockMvcRequestBuilders
			      .post("/api/games/2/shots")
			      .content("{\r\n"
			      		+ "		 \"bowlShotOne\": \"4\",\r\n"
			      		+ "		 \"bowlShotTwo\": \"3\"\r\n"
			      		+ "}")
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().is2xxSuccessful());
	}
	
	
	@Test
	public void testUpdateFrame() throws Exception 
	{
		mockMvc.perform( MockMvcRequestBuilders
	      .put("/api/games/2/shots/1").content("{\r\n"
		      		+ "		 \"bowlShotOne\": \"1\",\r\n"
		      		+ "		 \"bowlShotTwo\": \"3\"\r\n"
		      		+ "}")
	      .contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON))
	      .andExpect(status().is2xxSuccessful());
	}
	
	@Test
	public void testDeleterame() throws Exception 
	{
		mockMvc.perform( MockMvcRequestBuilders
	      .delete("/api/games/2/shots/1")
	      .contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON))
	      .andExpect(status().is2xxSuccessful());
	}
	
	
	@Test
	public void testViewFrame() throws Exception 
	{
		mockMvc.perform( MockMvcRequestBuilders
	      .get("/api/games/2/shots/1")
	      .contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON))
	      .andExpect(status().is2xxSuccessful());
	}


}
