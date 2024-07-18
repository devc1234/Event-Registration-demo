package com.example.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Event;
import com.example.demo.model.Participant;
import com.example.demo.model.Registration;
import com.example.demo.repo.EventRepository;
import com.example.demo.repo.ParticipantRepository;
import com.example.demo.repo.RegistrationRepository;

@RestController
@RequestMapping("/register")
public class RegistrationController {
    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ParticipantRepository participantRepository;

    @PostMapping
    public Registration registerForEvent(@RequestParam Long eventId, @RequestParam Long participantId) {
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new RuntimeException("Event not found"));
        Participant participant = participantRepository.findById(participantId).orElseThrow(() -> new RuntimeException("Participant not found"));

        Registration registration = new Registration();
        registration.setEvent(event);
        registration.setParticipant(participant);

        return registrationRepository.save(registration);
    }
}
