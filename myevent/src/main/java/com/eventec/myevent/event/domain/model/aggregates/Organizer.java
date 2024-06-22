package com.eventec.myevent.event.domain.model.aggregates;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Organizer {
    @Column(name = "organizer_name")
    private String name;
    @Column(name = "organizer_address")
    private String address;
    @Column(name = "organizer_phone_number")
    private String phoneNumber;

    public Organizer() {
    }

    public Organizer(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
