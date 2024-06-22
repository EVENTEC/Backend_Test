package com.eventec.myevent.event.interfaces.rest.resources;

import java.util.Date;

public record CreateEventResource(String title, String description, Date eventStartDate, Date eventEndDate) {
}
