package com.eventec.myevent.event.interfaces.rest.resources;

import java.util.Date;

public record UpdateEventResource(Long id, String title, String description, Date eventStartDate, Date eventEndDate) {
}
