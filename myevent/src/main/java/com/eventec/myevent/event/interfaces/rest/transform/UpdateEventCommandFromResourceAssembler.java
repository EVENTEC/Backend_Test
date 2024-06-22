package com.eventec.myevent.event.interfaces.rest.transform;

import com.eventec.myevent.event.domain.model.commands.UpdateEventCommand;
import com.eventec.myevent.event.domain.model.commands.UpdateEventCommandWithoutDates;
import com.eventec.myevent.event.interfaces.rest.resources.UpdateEventResource;
import com.eventec.myevent.event.interfaces.rest.resources.UpdateEventWithoutDatesResource;

import java.util.Date;

public class UpdateEventCommandFromResourceAssembler {
    public static UpdateEventCommand toCommandFromResource(UpdateEventResource resource) {
        Long id = resource.id();
        String eventName = resource.title();
        String eventDescription = resource.description();
        Date eventStartDate = resource.eventStartDate();
        Date eventEndDate = resource.eventEndDate();
        return new UpdateEventCommand(id, eventName, eventDescription, eventStartDate, eventEndDate);
    }
    public static UpdateEventCommandWithoutDates toCommandFromResource(UpdateEventWithoutDatesResource resource) {
        Long id = resource.id();
        String eventName = resource.title();
        String eventDescription = resource.description();
        return new UpdateEventCommandWithoutDates(id, eventName, eventDescription);
    }
}
