package com.eventec.myevent.event.domain.model.commands;

import java.util.Date;

public record UpdateEventCommand(Long id, String eventName, String eventDescription, Date eventStartDate, Date eventEndDate) {
    public boolean isEventInFuture() {
        return eventStartDate.after(new Date());
    }
}
