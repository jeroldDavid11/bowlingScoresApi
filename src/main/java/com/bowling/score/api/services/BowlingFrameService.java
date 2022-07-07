package com.bowling.score.api.services;

import java.util.Iterator;
import java.util.List;
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
public class BowlingFrameService {
	
	@Autowired
	private BowlingFrameRepository bowlingFrameRepository;
	
	@Autowired
	private BowlingGameSBoardRepository bowlingGameSBoardRepository;
	
	@Value("${bowling.max.frame}")
	private int maxFrame;
	
	public BowlingResponse createFrameOnBoard(int id,BowlingFrame bowlingFrame){
		BowlingResponse bowlingResponse = new BowlingResponse();
		try {

			Optional<BowlingGameSBoard> board = bowlingGameSBoardRepository.findById(id);
			if(board.get().getBowlingFrames().size() < maxFrame) {
				bowlingFrame.setGameId(id);
				bowlingFrameRepository.save(bowlingFrame);
				
				bowlingResponse.setResponseCode(HttpStatus.CREATED.value());
				bowlingResponse.setResponseMessage(HttpStatus.CREATED.toString());
				bowlingResponse.setBowlingGameSBoard(board.get());
			}else {
				bowlingResponse.setResponseCode(HttpStatus.NOT_MODIFIED.value());
				bowlingResponse.setResponseMessage("Reached max count frame");
				bowlingResponse.setBowlingGameSBoard(board.get());
				return bowlingResponse;
			}
			
		}catch (Exception e) {
			return BadRequestResponse(e);
		}
		return bowlingResponse;
	}
	
	public BowlingResponse deleteFrame(int gameId,int frameId){
		BowlingResponse bowlingResponse = new BowlingResponse();
		try {
			bowlingFrameRepository.deleteByFrameIdAndGameId(frameId,gameId);
			
			Optional<BowlingGameSBoard> board = bowlingGameSBoardRepository.findById(gameId);

			bowlingResponse.setResponseCode(HttpStatus.ACCEPTED.value());
			bowlingResponse.setResponseMessage(HttpStatus.ACCEPTED.toString());
			bowlingResponse.setBowlingGameSBoard(board.get());
		}catch (Exception e) {
			return BadRequestResponse(e);
		}
		return bowlingResponse;
	}
	
	public BowlingResponse viewFrame(int gameId,int frameId){
		BowlingResponse bowlingResponse = new BowlingResponse();
		try {
			BowlingFrame board = bowlingFrameRepository.findByFrameIdAndGameId(frameId,gameId);

			bowlingResponse.setResponseCode(HttpStatus.OK.value());
			bowlingResponse.setResponseMessage(HttpStatus.OK.toString());
			bowlingResponse.setBowlingFrame(board);
		}catch (Exception e) {
			return BadRequestResponse(e);
		}
		return bowlingResponse;
	}
	
	
	public BowlingResponse updateFrame(int gameId,int frameId,BowlingFrame bowlingFrame){
		BowlingResponse bowlingResponse = new BowlingResponse();
		try {
			BowlingFrame board = bowlingFrameRepository.findByFrameIdAndGameId(frameId,gameId);
			
			board.setBowlShotOne(bowlingFrame.getBowlShotOne());
			board.setBowlShotTwo(bowlingFrame.getBowlShotTwo());
			bowlingFrameRepository.save(board);
			
			
			bowlingResponse.setResponseCode(HttpStatus.OK.value());
			bowlingResponse.setResponseMessage(HttpStatus.OK.toString());
			bowlingResponse.setBowlingFrame(board);
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
	


}
