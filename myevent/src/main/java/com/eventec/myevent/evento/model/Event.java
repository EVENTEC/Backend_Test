package com.eventec.myevent.evento.model;

import java.util.Date;

public class Event {
    private Long id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private Location location;
    private Organizer organizer;
    private int totalTickets;

    // Constructor vacío (puede ser necesario para algunos frameworks y pruebas)
    public Event() {
    }

    // Constructor completo
    public Event(Long id, String name, String description, Date startDate, Date endDate, Location location, Organizer organizer, int totalTickets) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.organizer = organizer;
        this.totalTickets = totalTickets;
    }

    // Getters and setters (se omiten para brevedad)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }
}
