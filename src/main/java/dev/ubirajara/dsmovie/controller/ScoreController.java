package dev.ubirajara.dsmovie.controller;

import dev.ubirajara.dsmovie.DTO.MovieDTO;
import dev.ubirajara.dsmovie.DTO.ScoreDTO;
import dev.ubirajara.dsmovie.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/scores")
@CrossOrigin
public class ScoreController {

    @Autowired
    private ScoreService service;

    @PutMapping
    public MovieDTO saveScote(@RequestBody ScoreDTO dto) {
        return service.saveScore(dto);
    }

}