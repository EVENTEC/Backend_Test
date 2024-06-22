package com.eventec.myevent.event.application.internal.commandservices;

import com.eventec.myevent.event.domain.model.aggregates.Event;
import com.eventec.myevent.event.domain.model.commands.CreateEventCommand;
import com.eventec.myevent.event.domain.model.commands.DeleteEventCommand;
import com.eventec.myevent.event.domain.model.commands.UpdateEventCommand;
import com.eventec.myevent.event.domain.model.commands.UpdateEventCommandWithoutDates;
import com.eventec.myevent.event.domain.services.EventCommandService;
import com.eventec.myevent.event.infrastructure.persistence.jpa.repositories.EventRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventCommandServiceImpl implements EventCommandService {

    private final EventRepository eventRepository;

    public EventCommandServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Long handle(CreateEventCommand command) {
        if (eventRepository.existsByName(command.eventName())) {
            throw new IllegalArgumentException("Event with same name already exists");
        }
        var event = new Event(command);
        try {
            eventRepository.save(event);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving event: " + e.getMessage());
        }
        return event.getId();
    }

    @Override
    public Optional<Event> handle(UpdateEventCommand command) {
        if (eventRepository.existsByNameAndIdIsNot(command.eventName(), command.id()))
            throw new IllegalArgumentException("Event with same name already exists");
        var result = eventRepository.findById(command.id());
        if (result.isEmpty()) throw new IllegalArgumentException("Event does not exist");
        var eventToUpdate = result.get();
        try {
            eventToUpdate.update(command);
            var updatedEvent = eventRepository.save(eventToUpdate);
            return Optional.of(updatedEvent);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating event: " + e.getMessage());
        }
    }

    @Override
    public Optional<Event> handle(UpdateEventCommandWithoutDates command) {
        if (eventRepository.existsByNameAndIdIsNot(command.eventName(), command.id()))
            throw new IllegalArgumentException("Event with same name already exists");
        var result = eventRepository.findById(command.id());
        if (result.isEmpty()) throw new IllegalArgumentException("Event does not exist");
        var eventToUpdate = result.get();
        try {
            eventToUpdate.updateWithoutDates(command);
            var updatedEvent = eventRepository.save(eventToUpdate);
            return Optional.of(updatedEvent);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating event: " + e.getMessage());
        }
    }

    @Override
    public void handle(DeleteEventCommand command) {
        if (!eventRepository.existsById(command.id())) {
            throw new IllegalArgumentException("Event does not exist");
        }
        try {
            eventRepository.deleteById(command.id());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while deleting event: " + e.getMessage());
        }
    }
}
