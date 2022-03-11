package dev.ubirajara.dsmovie.controller;

import dev.ubirajara.dsmovie.DTO.MovieDTO;
import dev.ubirajara.dsmovie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/movies")
@CrossOrigin
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping
    public Page<MovieDTO> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping(value = "/{id}")
    public MovieDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }
}