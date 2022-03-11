package dev.ubirajara.dsmovie.service;

import dev.ubirajara.dsmovie.DTO.MovieDTO;
import dev.ubirajara.dsmovie.DTO.ScoreDTO;
import dev.ubirajara.dsmovie.entities.Movie;
import dev.ubirajara.dsmovie.entities.Score;
import dev.ubirajara.dsmovie.entities.User;
import dev.ubirajara.dsmovie.repository.MovieRepository;
import dev.ubirajara.dsmovie.repository.ScoreRepository;
import dev.ubirajara.dsmovie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    // funcao de salvar os escores do usuario
    @Transactional
    public MovieDTO saveScore(ScoreDTO dto) {
        User user = userRepository.findByEmail(dto.getEmail());

        if (user == null) {
            user = new User();
            user.setEmail(dto.getEmail());
            user = userRepository.saveAndFlush(user);
        }

        Movie movie = movieRepository.findById(dto.getMovieId()).get();

        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(dto.getScore());

        score = scoreRepository.saveAndFlush(score);

        double sum = 0.0;
        for (Score s : movie.getScores()) {
            sum = sum + s.getValue();
        }

        double avg = sum / movie.getScores().size();

        movie.setScore(avg);
        movie.setCount(movie.getScores().size());

        movie = movieRepository.save(movie);

        return new MovieDTO(movie);
    }

}
