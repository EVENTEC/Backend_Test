package com.eventec.myevent.event.domain.services;

import com.eventec.myevent.event.domain.model.aggregates.Event;
import com.eventec.myevent.event.domain.model.queries.GetAllEventsQuery;
import com.eventec.myevent.event.domain.model.queries.GetEventByIdQuery;

import java.util.List;
import java.util.Optional;

public interface EventQueryService {
    Optional<Event> handle(GetEventByIdQuery query);
    List<Event> handle(GetAllEventsQuery query);
}
