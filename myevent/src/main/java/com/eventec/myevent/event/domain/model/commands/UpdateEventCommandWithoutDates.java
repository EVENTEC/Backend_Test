package com.eventec.myevent.event.domain.model.commands;

public record UpdateEventCommandWithoutDates(Long id, String eventName, String eventDescription) {
}
