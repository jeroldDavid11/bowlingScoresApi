package com.bowling.score.api.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bowling.score.api.model.BowlingFrame;
import com.bowling.score.api.model.BowlingGameSBoard;
import com.bowling.score.api.model.BowlingResponse;
import com.bowling.score.api.repository.BowlingFrameRepository;
import com.bowling.score.api.repository.BowlingGameSBoardRepository;

@Service
public class BowlingGameSBoardServices {
	
	@Autowired
	private BowlingGameSBoardRepository bowlingGameSBoardRepository;
	
	@Autowired
	private BowlingFrameRepository bowlingFrameRepository;
	
	@Value("${bowling.max.frame}")
	private int maxFrame;
	
	private LocalDateTime dateTime = LocalDateTime.now();
	
	public BowlingResponse createGameBowling(BowlingGameSBoard bowlingGameSBoard) {
		BowlingResponse bowlingResponse = new BowlingResponse();
		try {
			
			bowlingGameSBoard.setGameCreatedDateTime(dateTime.toString());
			bowlingGameSBoardRepository.save(bowlingGameSBoard);
			bowlingResponse.setResponseCode(HttpStatus.CREATED.value());
			bowlingResponse.setResponseMessage(HttpStatus.CREATED.toString());
			bowlingResponse.setBowlingGameSBoard(bowlingGameSBoard);
		} catch (Exception e) {
			return BadRequestResponse(e);
		}
		
		return bowlingResponse;
	}
	
	public BowlingResponse deleteGame(int id){
		BowlingResponse bowlingResponse = new BowlingResponse();
		try {
			bowlingGameSBoardRepository.deleteById(id);
			bowlingResponse.setResponseCode(HttpStatus.OK.value());
			bowlingResponse.setResponseMessage(HttpStatus.OK.toString());
		}catch (Exception e) {
			return BadRequestResponse(e);
		}
		return bowlingResponse;

	}
	
	public BowlingResponse viewGame(int id){
		BowlingResponse bowlingResponse = new BowlingResponse();
		try {
			
			Optional<BowlingGameSBoard> board = bowlingGameSBoardRepository.findById(id);
			  ArrayList<BowlingFrame> frame = bowlingFrameRepository.findByGameId(id);
			  if(maxFrame == frame.size()){
				  board.get().setGameScore(computeScore(id,frame));
			  }else {
				  board.get().setGameScore(0);
			  }
			bowlingResponse.setResponseCode(HttpStatus.OK.value());
			bowlingResponse.setResponseMessage(HttpStatus.OK.toString());
			bowlingResponse.setBowlingGameSBoard(board.get());
			
			
		}catch (Exception e) {
			return BadRequestResponse(e);
		}
		return bowlingResponse;
	}
	
	public BowlingResponse updateGame(int id,BowlingGameSBoard bowlingGameSBoard){
		BowlingResponse bowlingResponse = new BowlingResponse();
		try {
			Optional<BowlingGameSBoard> updateBoard = bowlingGameSBoardRepository.findById(id);
			updateBoard.get().setGameName(bowlingGameSBoard.getGameName());
			updateBoard.get().setGameUpdateDateTime(dateTime.toString());
			bowlingGameSBoardRepository.save(updateBoard.get());
			
			bowlingResponse.setResponseCode(HttpStatus.ACCEPTED.value());
			bowlingResponse.setResponseMessage(HttpStatus.ACCEPTED.toString());
			bowlingResponse.setBowlingGameSBoard(updateBoard.get());
		}catch (Exception e) {
			return BadRequestResponse(e);
		}
		return bowlingResponse;
	}

	private BowlingResponse BadRequestResponse(Exception e){
		BowlingResponse bowlingResponse = new BowlingResponse();
		bowlingResponse.setResponseCode(HttpStatus.BAD_REQUEST.value());
		bowlingResponse.setResponseMessage(e.getMessage());
		return bowlingResponse;
	}
	
	private int computeScore(int id,ArrayList<BowlingFrame> frame) {
		  int score = 0;
			  for (int counter = 0; counter < frame.size(); counter++) { 	
		          if((frame.get(counter).getBowlShotOne()+frame.get(counter).getBowlShotTwo()) < 10){
		        	  score += frame.get(counter).getBowlShotOne()+frame.get(counter).getBowlShotTwo();
		          }else if(frame.get(counter).getBowlShotOne() == 10 && frame.get(counter).getBowlShotTwo() == 0 ) {
		        	  score += frame.get(counter).getBowlShotOne() + frame.get(counter+1).getBowlShotOne() + (frame.get(counter+1).getBowlShotTwo() == 0 ? frame.get(counter+2).getBowlShotOne() : frame.get(counter+1).getBowlShotTwo()) ;
		          }else if((frame.get(counter).getBowlShotOne() != 10) && ((frame.get(counter).getBowlShotOne()+frame.get(counter).getBowlShotTwo()) == 10) ){
		        	  score += frame.get(counter).getBowlShotOne() + frame.get(counter).getBowlShotTwo() + frame.get(counter+1).getBowlShotOne();
		          }
		      }
		return score;
		  
		
	}

}
