package com.bowling.score.api.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class BowlingModelTest {
	@Test
	void test() {
		BowlingResponse bowlingResponse = new BowlingResponse();
		BowlingFrame bowlingFrame = new BowlingFrame();
		bowlingFrame.setBowlShotOne(0);
		bowlingFrame.setBowlShotTwo(0);
		bowlingFrame.setFrameCreatedDateTime("testy");
		bowlingFrame.setFrameId(0);
		bowlingFrame.setFrameUpdateDateTime("test");
		bowlingFrame.setGameId(0);
		
		List<BowlingFrame> bowlingFrames = new ArrayList<BowlingFrame>();
		bowlingFrames.add(bowlingFrame);
		
		BowlingGameSBoard bowlingGameSBoard = new BowlingGameSBoard();
		bowlingGameSBoard.setGameCreatedDateTime("String");
		bowlingGameSBoard.setGameId(0);
		bowlingGameSBoard.setGameName("String");
		bowlingGameSBoard.setGameScore(0);
		bowlingGameSBoard.setGameUpdateDateTime("String");
		bowlingGameSBoard.setBowlingFrames(bowlingFrames);
		bowlingFrame.setBowlingGameSBoard(bowlingGameSBoard);
		
		
		bowlingResponse.setBowlingFrame(bowlingFrame);
		bowlingResponse.setBowlingGameSBoard(bowlingGameSBoard);
		bowlingResponse.setResponseCode(1);
		bowlingResponse.setResponseMessage("String");
		
		assertNotNull(bowlingResponse.getBowlingFrame());
		assertNotNull(bowlingResponse.getBowlingGameSBoard());
		assertNotNull(bowlingResponse.getResponseCode());
		assertNotNull(bowlingResponse.getResponseMessage());
		
		assertNotNull(bowlingFrame.getBowlShotOne());
		assertNotNull(bowlingFrame.getBowlShotTwo());
		assertNotNull(bowlingFrame.getFrameCreatedDateTime());
		assertNotNull(bowlingFrame.getFrameUpdateDateTime());
		assertNotNull(bowlingFrame.getFrameId());
		assertNotNull(bowlingFrame.getGameId());
		
		bowlingGameSBoard.setGameCreatedDateTime("String");
		bowlingGameSBoard.setGameId(0);
		bowlingGameSBoard.setGameName("String");
		bowlingGameSBoard.setGameScore(0);
		bowlingGameSBoard.setGameUpdateDateTime("String");
		bowlingFrame.setBowlingGameSBoard(bowlingGameSBoard);
		
		assertNotNull(bowlingGameSBoard.getGameCreatedDateTime());
		assertNotNull(bowlingGameSBoard.getGameId());
		assertNotNull(bowlingGameSBoard.getGameName());
		assertNotNull(bowlingGameSBoard.getGameScore());
		assertNotNull(bowlingGameSBoard.getGameUpdateDateTime());
		assertNotNull(bowlingGameSBoard.getBowlingFrames());
		assertNotNull(bowlingFrame.getBowlingGameSBoard());
		
	}

}
