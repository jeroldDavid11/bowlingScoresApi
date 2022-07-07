package com.bowling.score.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bowling.score.api.model.BowlingGameSBoard;

@Repository
public interface BowlingGameSBoardRepository extends CrudRepository<BowlingGameSBoard, Integer> { 

}
