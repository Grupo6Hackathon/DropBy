package org.academiadecodigo.cheguei.converters;

import org.academiadecodigo.cheguei.command.EventsDto;
import org.academiadecodigo.cheguei.persistence.model.Events.Events;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EventsDtoToEvents implements Converter<EventsDto, Events> {

    @Override
    public Events convert(EventsDto eventsDto) {

        Events event = new Events();

        event.setAddress(eventsDto.getAddress());
        event.setDate(eventsDto.getDate());
        event.setEventTitle(eventsDto.getEventTitle());
        event.setMaximumCapacity(eventsDto.getMaximumCapacity());
        event.setDescription(eventsDto.getDescription());

        return event;

    }
}
