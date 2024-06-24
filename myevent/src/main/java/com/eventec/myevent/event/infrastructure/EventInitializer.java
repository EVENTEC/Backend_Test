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
            Event event4 = createEvent(
                    "Festival Internacional del Vinilo Vol.6",
                    "FIV Vol. VI Llega la sexta edición del Festival Internacional del Vinilo en Lima (FIV). Serán 2 tiendas extranjeras, 1 de Argentina y 1 de España. Tiendas de provincia y más de 40 de Lima (zona Quilca, sellos independientes y mercado de pulgas). Música en vivo con nuestro primer artista internacional, Dante Spinetta (ex Illya Kuryaki and the Valderramas), La Mente, 6 Voltios, La Liga del Sueño, Frágil y más. Audiolima Experience: Djs en vivo, transmisión en vivo de Radio Oxígeno, food trucks, barras de bebida, ropa, libros, funkos, juegos inflables activaciones de marca y mucho más. Información adicional Somos pet friendly :)",
                    "Parque de la Exposición",
                    "Parque de la Exposición",
                    "Lima",
                    "Perú",
                    "MyEvent",
                    "MyEvent Address",
                    "912345678",
                    1500);
            Event event5 = createEvent(
                    "Miel San Marcos - Generaciones 24",
                    "Miel San Marcos es una de las bandas cristianas más trascendentes de la música latina contemporánea. Con Doce producciones discográficas, han recorrido el mundo compartiendo sus múltiples éxitos originales como: «No Hay Lugar Más Alto», «Danzo En El Río», «Levántate Señor», entre otros. En el 2012, el grupo guatemalteco hizo historia con su grabación en vivo titulada «Proezas», la cual reunió a miles de asistentes en el Anaheim Convention Center Arena. Durante el 2014, Miel San Marcos hizo historia nuevamente siendo una de las pocas agrupaciones en reunir a más de 17 mil personas en La Arena Ciudad de México para la grabación Como en el Cielo.",
                    "Jockey Club del Perú",
                    "Jockey Club del Perú",
                    "Lima",
                    "Perú",
                    "MyEvent",
                    "MyEvent Address",
                    "912345678",
                    2500);
            Event event6 = createEvent(
                    "Orbital Club Pres. Ben Sterling",
                    "El reconocido DJ, cantante, compositor y músico Estadounidense, Ben Sterling, aterriza en Lima para una noche electrónica inolvidable. Gracias a Vastion, los aficionados peruanos tendrán la oportunidad de disfrutar de su talento el próximo 23 de mayo en Orbital, ubicado en Lince.",
                    "Orbital Club",
                    "Orbital Club",
                    "Lima",
                    "Perú",
                    "MyEvent",
                    "MyEvent Address",
                    "912345678",
                    1200);
            Event event7 = createEvent(
                    "Superclub Pres. Amelie Lens",
                    "La espera ha terminado. ¡Amelie Lens, la renombrada DJ y productora belga, llega a Lima para una experiencia electrónica única! Junto a ella, el talentoso Víctor Ruiz se une a la fiesta para ofrecer un espectáculo inolvidable. Presentado por Super Club, este evento promete ser el punto culminante del verano.",
                    "Superclub",
                    "Superclub",
                    "Lima",
                    "Perú",
                    "MyEvent",
                    "MyEvent Address",
                    "912345678",
                    2000);
            Event event8 = createEvent(
                    "Cosquín Rock Perú",
                    "Cosquín Rock, que desde su creación en el año 2001 ha servido como un pilar fundamental para la industria musical, no solo ofrece una plataforma para bandas emergentes y establecidas, sino que también ha sido un motor crucial para el desarrollo cultural y musical. Durante sus más de dos décadas de historia, el festival ha logrado congregar a cientos de miles de personas, incluyendo un récord de asistencia en Argentina en 2023, donde más de 200,000 asistentes disfrutaron de un espectáculo sin precedentes.",
                    "Estadio Nacional",
                    "Estadio Nacional",
                    "Lima",
                    "Perú",
                    "MyEvent",
                    "MyEvent Address",
                    "912345678",
                    10000);
            Event event9 = createEvent(
                    "Morat: Los estadios. Antes de que amanezca",
                    "Sport trainer",
                    "Estadio Nacional",
                    "Estadio Nacional",
                    "Lima",
                    "Perú",
                    "MyEvent",
                    "MyEvent Address",
                    "912345678",
                    8000);
            Event event10 = createEvent(
                    "Festival Andino Latinoamericano IV Edición",
                    "¡La espera terminó! Vuelve el FESTIVAL ANDINO LATINOAMERICANO IV EDICIÓN al Anfiteatro del Parque de la Exposición,  este sábado 25 de mayo, a partir de las 2:00 p.m. Únete a este gran festival para celebrar lo mejor de nuestra música andina. Juntos en un mismo escenario: Alborada, Amaranta, Antología, Raíces D’ Jauja, William Luna, Mac Salvador, Max Castro, Mauricio Mesones ¡Prepárate para vivir un festival lleno de emoción y peruanidad!",
                    "Parque de la Exposición",
                    "Parque de la Exposición",
                    "Lima",
                    "Perú",
                    "MyEvent",
                    "MyEvent Address",
                    "912345678",
                    3000);
            Event event11 = createEvent(
                    "Alvaro Rod en Ayacucho",
                    "Alvaro Rod en Ayacucho por primera y única vez en el teatro municipal de Ayacucho, el 25 de mayo, donde estará acompañado de sus músicos y un marco sinfónico, interpretando sus mejores éxitos de siempre.",
                    "Ayacucho",
                    "Ayacucho",
                    "Ayacucho",
                    "Perú",
                    "MyEvent",
                    "MyEvent Address",
                    "912345678",
                    1000);
            Event event12 = createEvent(
                    "Marcos Llunas - Sinfonia a Mamá",
                    "Marcos Llunas Sinfonía para mamá, Marcos Llunas presentará por única vez un concierto en homenaje a mamá, este 25 de mayo en el teatro municipal de lima, donde estará acompañado de sus músicos y un marco sinfónico, interpretando sus mejores éxitos de siempre y un lindo homenaje a mamá con las canciones de su padre Dyango.",
                    "Teatro Municipal de Lima",
                    "Teatro Municipal de Lima",
                    "Lima",
                    "Perú",
                    "MyEvent",
                    "MyEvent Address",
                    "912345678",
                    1500);
            Event event13 = createEvent(
                    "Un bolero Un vals, Eva Ayllón",
                    "Eva Ayllón vuelve con su espectáculo Un Bolero Un Vals acompañada de su marco musical donde – como adelanta el nombre del show - mezcla el vals y el bolero. Mejor dicho, un género le responde al otro.",
                    "Teatro Municipal de Lima",
                    "Teatro Municipal de Lima",
                    "Lima",
                    "Perú",
                    "MyEvent",
                    "MyEvent Address",
                    "912345678",
                    1500);
            Event event14 = createEvent(
                    "Temporada de Abono 2024",
                    "Gran concierto de la temporada de abono 2024 de la Orquesta Sinfónica Nacional del Perú",
                    "Teatro Municipal de Lima",
                    "Teatro Municipal de Lima",
                    "Lima",
                    "Perú",
                    "MyEvent",
                    "MyEvent Address",
                    "912345678",
                    1000);

            // Guardar los eventos en la base de datos si no existen
            saveEventIfNotExists(eventRepository, event1);
            saveEventIfNotExists(eventRepository, event2);
            saveEventIfNotExists(eventRepository, event3);
            saveEventIfNotExists(eventRepository, event4);
            saveEventIfNotExists(eventRepository, event5);
            saveEventIfNotExists(eventRepository, event6);
            saveEventIfNotExists(eventRepository, event7);
            saveEventIfNotExists(eventRepository, event8);
            saveEventIfNotExists(eventRepository, event9);
            saveEventIfNotExists(eventRepository, event10);
            saveEventIfNotExists(eventRepository, event11);
            saveEventIfNotExists(eventRepository, event12);
            saveEventIfNotExists(eventRepository, event13);
            saveEventIfNotExists(eventRepository, event14);
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
