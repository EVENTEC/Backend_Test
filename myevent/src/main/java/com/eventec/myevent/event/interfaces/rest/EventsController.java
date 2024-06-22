package com.eventec.myevent.event.interfaces.rest;

import com.eventec.myevent.event.domain.model.commands.CreateEventCommand;
import com.eventec.myevent.event.domain.model.commands.DeleteEventCommand;
import com.eventec.myevent.event.domain.model.commands.UpdateEventCommand;
import com.eventec.myevent.event.domain.model.queries.GetAllEventsQuery;
import com.eventec.myevent.event.domain.model.queries.GetEventByIdQuery;
import com.eventec.myevent.event.domain.services.EventCommandService;
import com.eventec.myevent.event.domain.services.EventQueryService;
import com.eventec.myevent.event.interfaces.rest.resources.CreateEventResource;
import com.eventec.myevent.event.interfaces.rest.resources.EventResource;
import com.eventec.myevent.event.interfaces.rest.resources.UpdateEventResource;
import com.eventec.myevent.event.interfaces.rest.transform.CreateEventCommandFromResourceAssembler;
import com.eventec.myevent.event.interfaces.rest.transform.EventResourceFromEntityAssembler;
import com.eventec.myevent.event.interfaces.rest.transform.UpdateEventCommandFromResourceAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/events", produces = APPLICATION_JSON_VALUE)
public class EventsController {
    private final EventCommandService eventCommandService;
    private final EventQueryService eventQueryService;

    public EventsController(EventCommandService eventCommandService, EventQueryService eventQueryService) {
        this.eventCommandService = eventCommandService;
        this.eventQueryService = eventQueryService;
    }

    @PostMapping
    public ResponseEntity<EventResource> createEvent(@RequestBody CreateEventResource resource) {
        CreateEventCommand command = CreateEventCommandFromResourceAssembler.toCommandFromResource(resource);
        var eventId = eventCommandService.handle(command);
        if (eventId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getEventByIdQuery = new GetEventByIdQuery(eventId);
        var event = eventQueryService.handle(getEventByIdQuery);
        if (event.isEmpty()) return ResponseEntity.badRequest().build();
        var eventResource = EventResourceFromEntityAssembler.toResourceFromEntity(event.get());
        return new ResponseEntity<>(eventResource, HttpStatus.CREATED);
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<EventResource> getEventById(@PathVariable Long eventId) {
        var getEventByIdQuery = new GetEventByIdQuery(eventId);
        var event = eventQueryService.handle(getEventByIdQuery);
        if (event.isEmpty()) return ResponseEntity.badRequest().build();
        var eventResource = EventResourceFromEntityAssembler.toResourceFromEntity(event.get());
        return ResponseEntity.ok(eventResource);
    }

    @GetMapping
    public ResponseEntity<List<EventResource>> getAllEvents() {
        var getAllEventsQuery = new GetAllEventsQuery();
        var events = eventQueryService.handle(getAllEventsQuery);
        var eventResources = events.stream().map(EventResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(eventResources);
    }

    @PutMapping("/{eventId}")
    public ResponseEntity<EventResource> updateEvent(@PathVariable Long eventId, @RequestBody UpdateEventResource resource) {
        var updateEventCommand = UpdateEventCommandFromResourceAssembler.toCommandFromResource(resource);
        var updatedEvent = eventCommandService.handle(updateEventCommand);
        if (updatedEvent.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var eventResource = EventResourceFromEntityAssembler.toResourceFromEntity(updatedEvent.get());
        return ResponseEntity.ok(eventResource);
    }

    @DeleteMapping("/{eventId}")
    public ResponseEntity<?> deleteEvent(@PathVariable Long eventId) {
        var deleteEventCommand = new DeleteEventCommand(eventId);
        eventCommandService.handle(deleteEventCommand);
        return ResponseEntity.ok("Event with given id successfully deleted");
    }
}
