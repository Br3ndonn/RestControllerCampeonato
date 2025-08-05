package edu.ifma.dcomp.lpweb.campeonato.controller;

import edu.ifma.dcomp.lpweb.campeonato.model.Time;
import edu.ifma.dcomp.lpweb.campeonato.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TimeController {

    @Autowired
    private TimeRepository timeRepository;

    @GetMapping("/time")
    public List<Time> getTimes() {
        return timeRepository.findAll();
    }

}
