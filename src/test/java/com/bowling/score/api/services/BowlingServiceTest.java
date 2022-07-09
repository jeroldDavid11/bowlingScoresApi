package com.bowling.score.api.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.hibernate.mapping.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.bowling.score.api.BowlingScoreApiApplication;
import com.bowling.score.api.model.BowlingFrame;
import com.bowling.score.api.model.BowlingGameSBoard;
import com.bowling.score.api.repository.BowlingFrameRepository;
import com.bowling.score.api.repository.BowlingGameSBoardRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { BowlingScoreApiApplication.class })
@SpringBootTest
class BowlingServiceTest {
	@Autowired
	@InjectMocks
	private BowlingGameSBoardServices bowlingGameSBoardServices;
	@Autowired
	@InjectMocks
	private BowlingFrameService bowlingFrameService;
	@MockBean
	private BowlingGameSBoardRepository bowlingGameSBoardRepository;
	@MockBean
	private BowlingFrameRepository bowlingFrameRepository;

	@Test
	void testCreateBean() {
		BowlingFrame bowlingFrame = new BowlingFrame();
		bowlingFrame.setBowlShotOne(1);
		bowlingFrame.setBowlShotTwo(4);
		
	    BowlingGameSBoard bowlingGameSBoard = new BowlingGameSBoard();
	    bowlingGameSBoard.setGameId(1);
	    bowlingGameSBoard.setGameName("test1");
	    
	    ArrayList<BowlingFrame> frames = new ArrayList<BowlingFrame>();
	    BowlingFrame frame = new BowlingFrame();
	    frame.setBowlShotOne(1);
	    frame.setBowlShotTwo(3);
	    frame.setFrameId(1);
	    frame.setGameId(1);
	    frames.add(frame);
	    frames.add(frame);
	    
	    bowlingGameSBoard.setBowlingFrames(frames);
		
		Optional<BowlingGameSBoard> board =  Optional.of(bowlingGameSBoard);

		when(bowlingGameSBoardRepository.findById(anyInt())).thenReturn(board);
		assertEquals(bowlingFrameService.createFrameOnBoard(1, bowlingFrame).getResponseCode(),201);

	}
	
	
	@Test
	void testCreateBeanMax() {
		BowlingFrame bowlingFrame = new BowlingFrame();
		bowlingFrame.setBowlShotOne(1);
		bowlingFrame.setBowlShotTwo(4);
		
	    BowlingGameSBoard bowlingGameSBoard = new BowlingGameSBoard();
	    bowlingGameSBoard.setGameId(1);
	    bowlingGameSBoard.setGameName("test1");
	    
	    ArrayList<BowlingFrame> frames = new ArrayList<BowlingFrame>();
	    BowlingFrame frame = new BowlingFrame();
	    frame.setBowlShotOne(1);
	    frame.setBowlShotTwo(3);
	    frame.setFrameId(1);
	    frame.setGameId(1);
	    frames.add(frame);
	    frames.add(frame);
	    frames.add(frame);
	    frames.add(frame);
	    frames.add(frame);
	    frames.add(frame);
	    frames.add(frame);
	    frames.add(frame);
	    frames.add(frame);
	    frames.add(frame);
	    frames.add(frame);
	    frames.add(frame);
	    frames.add(frame);
	    
	    bowlingGameSBoard.setBowlingFrames(frames);
		
		Optional<BowlingGameSBoard> board =  Optional.of(bowlingGameSBoard);

		when(bowlingGameSBoardRepository.findById(anyInt())).thenReturn(board);
		assertEquals(bowlingFrameService.createFrameOnBoard(1, bowlingFrame).getResponseCode(),304);

	}
	
	@Test
	void testUpdateBean() {
		BowlingFrame bowlingFrame = new BowlingFrame();
		bowlingFrame.setBowlShotOne(1);
		bowlingFrame.setBowlShotTwo(4);
		
	    BowlingGameSBoard bowlingGameSBoard = new BowlingGameSBoard();
	    bowlingGameSBoard.setGameId(1);
	    bowlingGameSBoard.setGameName("test1");
	    
	    ArrayList<BowlingFrame> frames = new ArrayList<BowlingFrame>();
	    BowlingFrame frame = new BowlingFrame();
	    frame.setBowlShotOne(1);
	    frame.setBowlShotTwo(3);
	    frame.setFrameId(1);
	    frame.setGameId(1);
	    frames.add(frame);
	    frames.add(frame);
	    
	    bowlingGameSBoard.setBowlingFrames(frames);

		when(bowlingFrameRepository.findByFrameIdAndGameId(anyInt(),anyInt())).thenReturn(frame);
		assertEquals(bowlingFrameService.updateFrame(1,1, bowlingFrame).getResponseCode(),200);

	}

}
