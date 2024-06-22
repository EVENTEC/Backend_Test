package com.eventec.myevent.event.domain.model.commands;

import java.util.Date;

public record CreateEventCommand(String eventName, String eventDescription) {
    private static Date eventStartDate = new Date();
    private static Date eventEndDate = new Date();

    public CreateEventCommand {
        eventStartDate = new Date();
        eventEndDate = new Date();
    }

    public Date eventStartDate() {
        return this.eventStartDate;
    }

    public Date eventEndDate() {
        return this.eventEndDate;
    }

    public boolean isEventInFuture() {
        return eventStartDate.after(new Date());
    }
}
