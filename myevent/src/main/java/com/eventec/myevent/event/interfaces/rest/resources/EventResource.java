package com.eventec.myevent.event.interfaces.rest.resources;

import com.eventec.myevent.event.domain.model.aggregates.Location;
import com.eventec.myevent.event.domain.model.aggregates.Organizer;

import java.util.Date;

public record EventResource(
        Long id,
        String name,
        String description,
        String category,
        Date startDate,
        Date endDate,
        Location location,
        Organizer organizer,
        int totalTickets,
        double priceTicket) {
}