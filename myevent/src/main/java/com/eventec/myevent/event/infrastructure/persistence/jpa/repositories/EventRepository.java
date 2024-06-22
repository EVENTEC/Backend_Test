package com.eventec.myevent.event.infrastructure.persistence.jpa.repositories;

import com.eventec.myevent.event.domain.model.aggregates.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    Optional<Event> findByName(String name);
    boolean existsByName(String name);
    boolean existsByNameAndIdIsNot(String name, Long id);
}
