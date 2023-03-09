package com.javapoint.habits.controller;


import com.javapoint.habits.model.Statistic;
import com.javapoint.habits.service.StatisticService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StatisticController {

    private final StatisticService statisticService;

    public StatisticController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @PostMapping(value = "/statistic")
    public ResponseEntity<?> create(@RequestBody Statistic statistic) {
        statisticService.create(statistic);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/statistic")
    public ResponseEntity<List<Statistic>> read() {
        final List<Statistic> statistic = statisticService.readAll();

        return statistic != null &&  !statistic.isEmpty()
                ? new ResponseEntity<>(statistic, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/statistic/{id}")
    public ResponseEntity<Statistic> read(@PathVariable(name = "id") int id) {
        final Statistic statistic = statisticService.read(id);

        return statistic != null
                ? new ResponseEntity<>(statistic, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/statistic/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody @Valid Statistic statistic ) {
        final boolean updated = statisticService.update(statistic, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/statistic/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = statisticService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
