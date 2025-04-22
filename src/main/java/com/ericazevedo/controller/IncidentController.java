package com.ericazevedo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ericazevedo.model.Incident;
import com.ericazevedo.service.IncidentService;

@RestController
@RequestMapping("/api/incidents")
public class IncidentController {
	
	@Autowired
    private IncidentService service;

    @PostMapping
    public Incident create(@RequestBody Incident incident) {
        return service.save(incident);
    }

    @PutMapping("/{id}")
    public Incident update(@PathVariable(value = "id") Long id, @RequestBody Incident incident) {
        return service.update(id, incident);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
    }

    @GetMapping
    public List<Incident> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Incident getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/last20")
    public List<Incident> getLast20() {
        return service.findLast20();
    }
}
