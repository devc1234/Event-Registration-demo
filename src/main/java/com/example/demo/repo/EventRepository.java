package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
}
