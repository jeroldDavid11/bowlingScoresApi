package com.bowling.score.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_EMPTY, content = Include.NON_NULL)
public class BowlingResponse {
	
	private int responseCode;
	private String responseMessage;
	private BowlingGameSBoard bowlingGameSBoard;
	private BowlingFrame bowlingFrame;

	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	public BowlingGameSBoard getBowlingGameSBoard() {
		return bowlingGameSBoard;
	}
	public void setBowlingGameSBoard(BowlingGameSBoard bowlingGameSBoard) {
		this.bowlingGameSBoard = bowlingGameSBoard;
	}
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public BowlingFrame getBowlingFrame() {
		return bowlingFrame;
	}
	public void setBowlingFrame(BowlingFrame bowlingFrame) {
		this.bowlingFrame = bowlingFrame;
	}

}
