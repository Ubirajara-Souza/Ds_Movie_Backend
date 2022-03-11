package dev.ubirajara.dsmovie.repository;

import dev.ubirajara.dsmovie.entities.Score;
import dev.ubirajara.dsmovie.entities.ScorePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, ScorePK> {
}