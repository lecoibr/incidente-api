package com.ericazevedo.service;

import com.ericazevedo.model.Incident;
import com.ericazevedo.repository.IncidentRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidentService {
    private final IncidentRepository repository;

    public IncidentService(IncidentRepository repository) {
        this.repository = repository;
    }

    public Incident save(Incident incident) {
        return repository.save(incident);
    }

    public Incident update(Long id, Incident incident) {
        Incident existing = repository.findById(id).orElseThrow();
        existing.setName(incident.getName());
        existing.setDescription(incident.getDescription());
        existing.setClosedAt(incident.getClosedAt());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Incident> findAll() {
        return repository.findAll();
    }

    public Incident findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public List<Incident> findLast20() {
        return repository.findTop20ByOrderByCreatedAtDesc();
    }
}
