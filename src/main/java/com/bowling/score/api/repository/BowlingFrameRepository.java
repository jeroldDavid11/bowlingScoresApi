package com.bowling.score.api.repository;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bowling.score.api.model.BowlingFrame;

@Repository
public interface BowlingFrameRepository extends CrudRepository<BowlingFrame, Integer> { 
	
	    BowlingFrame findByFrameIdAndGameId(int frameId, int gameId);
	    
	    ArrayList<BowlingFrame> findByGameId(int gameId);

	    @Transactional
	    @Modifying
	    @Query("DELETE FROM BowlingFrame m WHERE frameId = :frameId AND gameId = :gameId")
	    void deleteByFrameIdAndGameId(@Param("frameId") int frameId,@Param("gameId") int gameId);
}
