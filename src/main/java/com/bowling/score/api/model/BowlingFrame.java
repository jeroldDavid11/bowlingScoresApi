package com.bowling.score.api.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "BowlingFrame")
@JsonInclude(value = Include.NON_EMPTY, content = Include.NON_NULL)
public class BowlingFrame {
	
	 @Id
	 @SequenceGenerator(name = "frame_id_seq", sequenceName = "frame_id_seq",allocationSize = 10)
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "frame_id_seq")
	 private int frameId;
	 
	 
     private int gameId;
 	 private String frameCreatedDateTime;
 	 private String frameUpdateDateTime;
 	 
	 private int bowlShotOne;
	 private int bowlShotTwo;
	
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="gameId", nullable=false, insertable=false,updatable=false)
	 @OnDelete(action = OnDeleteAction.CASCADE)
	 @JsonIgnore
	 private BowlingGameSBoard bowlingGameSBoard;
 

	public BowlingGameSBoard getBowlingGameSBoard() {
		return bowlingGameSBoard;
	}
	public void setBowlingGameSBoard(BowlingGameSBoard bowlingGameSBoard) {
		this.bowlingGameSBoard = bowlingGameSBoard;
	}
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public String getFrameCreatedDateTime() {
		return frameCreatedDateTime;
	}
	public void setFrameCreatedDateTime(String frameCreatedDateTime) {
		this.frameCreatedDateTime = frameCreatedDateTime;
	}
	public String getFrameUpdateDateTime() {
		return frameUpdateDateTime;
	}
	public void setFrameUpdateDateTime(String frameUpdateDateTime) {
		this.frameUpdateDateTime = frameUpdateDateTime;
	}
	public int getFrameId() {
		return frameId;
	}
	public void setFrameId(int frameId) {
		this.frameId = frameId;
	}
	
	public int getBowlShotOne() {
		return bowlShotOne;
	}
	public void setBowlShotOne(int bowlShotOne) {
		this.bowlShotOne = bowlShotOne;
	}
	public int getBowlShotTwo() {
		return bowlShotTwo;
	}
	public void setBowlShotTwo(int bowlShotTwo) {
		this.bowlShotTwo = bowlShotTwo;
	}
	


}
