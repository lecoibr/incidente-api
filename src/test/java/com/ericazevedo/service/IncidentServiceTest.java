package com.ericazevedo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.ericazevedo.model.Incident;
import com.ericazevedo.repository.IncidentRepository;

public class IncidentServiceTest {
	
    @Test
    public void testSaveIncident() {
        IncidentRepository repository = mock(IncidentRepository.class);
        IncidentService service = new IncidentService(repository);

        Incident incident = new Incident();
        incident.setName("Test");
        incident.setDescription("Desc");

        when(repository.save(incident)).thenReturn(incident);

        Incident saved = service.save(incident);
        assertEquals("Test", saved.getName());
        verify(repository).save(incident);
    }

    @Test
    public void testFindById() {
        IncidentRepository repository = mock(IncidentRepository.class);
        IncidentService service = new IncidentService(repository);

        Incident incident = new Incident();
        incident.setName("Test");
        when(repository.findById(1L)).thenReturn(Optional.of(incident));

        Incident found = service.findById(1L);
        assertEquals("Test", found.getName());
    }
}
