package com.eventec.myevent.event.infrastructure;

import com.eventec.myevent.event.domain.model.aggregates.Event;
import com.eventec.myevent.event.domain.model.aggregates.Location;
import com.eventec.myevent.event.domain.model.aggregates.Organizer;
import com.eventec.myevent.event.infrastructure.persistence.jpa.repositories.EventRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class EventInitializer {

    @Bean
    public CommandLineRunner initializeEvents(EventRepository eventRepository) {
        return args -> {
            // Crear los eventos
            Event event1 = createEvent("Evento 1", "Descripción del Evento 1", "Location 1", "Address 1", "City 1", "Country 1", "Organizer 1", "Address 1", "Phone 1", 100);
            Event event2 = createEvent("Evento 2", "Descripción del Evento 2", "Location 2", "Address 2", "City 2", "Country 2", "Organizer 2", "Address 2", "Phone 2", 200);
            Event event3 = createEvent(
                    "Ferxxocalipsis",
                    "¡FERXXO LLEGA A PERÚ CON SU GIRA - FERXXO LLEGA A PERÚ CON SU GIRA! Feid Ferxxo, reconocido por su talento y versatilidad en el género urbano, ha conquistado a audiencias de todo el mundo con su estilo único y sus letras contagiosas. Con hits como Porfa, Fumeteo y GANGA, el artista colombiano ha consolidado su posición como uno de los referentes más destacados de la música latina contemporánea.",
                    "Jockey Club del Perú",
                    "Jockey Club del Perú",
                    "Lima",
                    "Perú",
                    "MyEvent",
                    "MyEvent Address",
                    "912345678",
                    2000);

            // Guardar los eventos en la base de datos si no existen
            saveEventIfNotExists(eventRepository, event1);
            saveEventIfNotExists(eventRepository, event2);
            saveEventIfNotExists(eventRepository, event3);
        };
    }

    private Event createEvent(String name, String description, String locationName, String locationAddress, String locationCity, String locationCountry, String organizerName, String organizerAddress, String organizerPhone, int totalTickets) {
        Event event = new Event();
        event.setName(name);
        event.setDescription(description);
        event.setStartDate(new Date());
        event.setEndDate(new Date());
        event.setLocation(new Location(locationName, locationAddress, locationCity, locationCountry));
        event.setOrganizer(new Organizer(organizerName, organizerAddress, organizerPhone));
        event.setTotalTickets(totalTickets);
        return event;
    }

    private void saveEventIfNotExists(EventRepository eventRepository, Event event) {
        if (!eventRepository.existsByName(event.getName())) {
            eventRepository.save(event);
        }
    }
}
