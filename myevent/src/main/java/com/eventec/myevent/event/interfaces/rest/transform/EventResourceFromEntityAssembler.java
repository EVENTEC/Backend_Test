package com.eventec.myevent.event.interfaces.rest.transform;

import com.eventec.myevent.event.domain.model.aggregates.Event;
import com.eventec.myevent.event.interfaces.rest.resources.EventResource;

public class EventResourceFromEntityAssembler {
    public static EventResource toResourceFromEntity(Event entity) {
        return new EventResource(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getStartDate(),
                entity.getEndDate(),
                entity.getLocation(),
                entity.getOrganizer(),
                entity.getTotalTickets()
        );
    }
}