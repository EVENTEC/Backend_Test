package com.eventec.myevent.event.interfaces.rest.transform;

import com.eventec.myevent.event.domain.model.commands.CreateEventCommand;
import com.eventec.myevent.event.interfaces.rest.resources.CreateEventResource;

import java.util.Date;

public class CreateEventCommandFromResourceAssembler {
    public static CreateEventCommand toCommandFromResource(CreateEventResource resource) {
        return new CreateEventCommand(resource.title(), resource.description());
    }
}
