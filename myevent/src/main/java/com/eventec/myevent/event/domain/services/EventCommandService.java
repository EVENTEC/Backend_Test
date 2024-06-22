package com.eventec.myevent.event.domain.services;

import com.eventec.myevent.event.domain.model.aggregates.Event;
import com.eventec.myevent.event.domain.model.commands.CreateEventCommand;
import com.eventec.myevent.event.domain.model.commands.DeleteEventCommand;
import com.eventec.myevent.event.domain.model.commands.UpdateEventCommand;
import com.eventec.myevent.event.domain.model.commands.UpdateEventCommandWithoutDates;

import java.util.Optional;

public interface EventCommandService {
    Long handle(CreateEventCommand command);
    Optional<Event> handle(UpdateEventCommand command);
    Optional<Event> handle(UpdateEventCommandWithoutDates command);
    void handle(DeleteEventCommand command);
}
