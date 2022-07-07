package com.bowling.score.api.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "BowlingGameSBoard")
@JsonInclude(value = Include.NON_EMPTY, content = Include.NON_NULL)
public class BowlingGameSBoard {
	
	@Id
	@SequenceGenerator(name = "game_id_seq", sequenceName = "game_id_seq",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_id_seq")
	@Column(nullable=false)
	private int gameId;
	private String gameName;
	private String gameCreatedDateTime;
	private String gameUpdateDateTime;
	private int gameScore;
	
	@OneToMany(mappedBy="bowlingGameSBoard", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<BowlingFrame> bowlingFrames;
	
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public String getGameCreatedDateTime() {
		return gameCreatedDateTime;
	}
	public void setGameCreatedDateTime(String gameCreatedDateTime) {
		this.gameCreatedDateTime = gameCreatedDateTime;
	}
	public String getGameUpdateDateTime() {
		return gameUpdateDateTime;
	}
	public void setGameUpdateDateTime(String gameUpdateDateTime) {
		this.gameUpdateDateTime = gameUpdateDateTime;
	}
	public List<BowlingFrame> getBowlingFrames() {
		return bowlingFrames;
	}
	public void setBowlingFrames(List<BowlingFrame> bowlingFrames) {
		this.bowlingFrames = bowlingFrames;
	}
	public int getGameScore() {
		return gameScore;
	}
	public void setGameScore(int gameScore) {
		this.gameScore = gameScore;
	}

}
