package dev.ubirajara.dsmovie.service;

import dev.ubirajara.dsmovie.DTO.MovieDTO;
import dev.ubirajara.dsmovie.entities.Movie;
import dev.ubirajara.dsmovie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    @Transactional(readOnly = true)
    public Page<MovieDTO> findAll(Pageable pageable) {
        Page<Movie> result = repository.findAll(pageable);
        return result.map(MovieDTO::new);
    }

    @Transactional(readOnly = true)
    public MovieDTO findById(Long id) {
        Movie result = repository.findById(id).get();
        return new MovieDTO(result);
    }
}
