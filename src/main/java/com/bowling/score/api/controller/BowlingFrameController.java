package com.bowling.score.api.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bowling.score.api.model.BowlingFrame;
import com.bowling.score.api.model.BowlingResponse;
import com.bowling.score.api.services.BowlingFrameService;

@RestController
@RequestMapping("/api/games/")
public class BowlingFrameController {
	  
	  @Autowired
	  private BowlingFrameService bowlingFrameService;
	  
	  @RequestMapping(value="/{id}/shots", method=RequestMethod.POST)
	  public BowlingResponse controllerBowlingFrame(@PathVariable(name="id") int id,@RequestBody BowlingFrame bowlingFrame) throws IOException {
	    return bowlingFrameService.createFrameOnBoard(id,bowlingFrame);
	  }

	  @RequestMapping(value="/{gameId}/shots/{frameId}", method=RequestMethod.DELETE)
	  public BowlingResponse controllerBowlingFrameDelete(@PathVariable(name="gameId") int gameId,@PathVariable(name="frameId") int frameId) throws IOException {
	    return bowlingFrameService.deleteFrame(gameId,frameId);
	  }
	  
	  @RequestMapping(value="/{gameId}/shots/{frameId}", method=RequestMethod.GET)
	  public BowlingResponse controllerBowlingFrameView(@PathVariable(name="gameId") int gameId,@PathVariable(name="frameId") int frameId) throws IOException {
	    return bowlingFrameService.viewFrame(gameId,frameId);
	  }
	  
	  @RequestMapping(value="/{gameId}/shots/{frameId}", method=RequestMethod.PUT)
	  public BowlingResponse controllerBowlingFrameUpdate(@PathVariable(name="gameId") int gameId,@PathVariable(name="frameId") int frameId,@RequestBody BowlingFrame bowlingFrame) throws IOException {
	    return bowlingFrameService.updateFrame(gameId,frameId,bowlingFrame);
	  }


}
