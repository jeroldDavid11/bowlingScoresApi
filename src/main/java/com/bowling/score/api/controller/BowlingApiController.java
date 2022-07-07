package com.bowling.score.api.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bowling.score.api.model.BowlingFrame;
import com.bowling.score.api.model.BowlingGameSBoard;
import com.bowling.score.api.model.BowlingResponse;
import com.bowling.score.api.services.BowlingFrameService;
import com.bowling.score.api.services.BowlingGameSBoardServices;

@RestController
@RequestMapping("/api/")
public class BowlingApiController {
	
	  @Autowired
	  private BowlingGameSBoardServices bowlingGameSBoardServices;

	  
	  @RequestMapping(value="/games", method=RequestMethod.POST)
	  public BowlingResponse controllerBowling(@RequestBody BowlingGameSBoard bowlingGameSBoard) throws IOException {
	    return bowlingGameSBoardServices.createGameBowling(bowlingGameSBoard);
	  }

	  @RequestMapping(value="/games/{id}", method=RequestMethod.DELETE)
	  public BowlingResponse controllerBowling(@PathVariable(name="id") int id) throws IOException {
	    return bowlingGameSBoardServices.deleteGame(id);
	  }
	  
	  @RequestMapping(value="/games/{id}", method=RequestMethod.GET)
	  public BowlingResponse controllerBowlingView(@PathVariable(name="id") int id) throws IOException {
		  return bowlingGameSBoardServices.viewGame(id);
	  }

	  @RequestMapping(value="/games/{id}", method=RequestMethod.PUT)
	  public BowlingResponse controllerBowlingUpdate(@PathVariable(name="id") int id,@RequestBody BowlingGameSBoard bowlingGameSBoard) throws IOException {
		  return bowlingGameSBoardServices.updateGame(id,bowlingGameSBoard);
	  }

}
