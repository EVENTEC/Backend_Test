package com.eventec.myevent.event.application.internal.queryservices;

import com.eventec.myevent.event.domain.model.aggregates.Event;
import com.eventec.myevent.event.domain.model.queries.GetAllEventsQuery;
import com.eventec.myevent.event.domain.model.queries.GetEventByIdQuery;
import com.eventec.myevent.event.domain.services.EventQueryService;
import com.eventec.myevent.event.infrastructure.persistence.jpa.repositories.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventQueryServiceImpl implements EventQueryService {

    private final EventRepository eventRepository;

    public EventQueryServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Optional<Event> handle(GetEventByIdQuery query) {
        return eventRepository.findById(query.eventId());
    }

    @Override
    public List<Event> handle(GetAllEventsQuery query) {
        return eventRepository.findAll();
    }
}
