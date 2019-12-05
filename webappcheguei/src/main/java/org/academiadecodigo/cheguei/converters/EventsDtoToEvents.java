package org.academiadecodigo.cheguei.converters;

import jdk.jfr.Event;
import org.academiadecodigo.cheguei.command.EventsDto;
import org.academiadecodigo.cheguei.factories.EventsFactory;
import org.academiadecodigo.cheguei.persistence.model.Events.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EventsDtoToEvents implements Converter<EventsDto, Events> {

    private EventsFactory eventsFactory;

    @Autowired
    public void setEventsFactory(EventsFactory eventsFactory) {
        this.eventsFactory = eventsFactory;
    }

    @Override
    public Events convert(EventsDto eventsDto) {

        Events event = null;

        event = eventsFactory.createEvent(eventsDto.getEventType());
        event.setAddress(eventsDto.getAddress());
        event.setDate(eventsDto.getDate());
        event.setEventTitle(eventsDto.getEventTitle());
        event.setMaximumCapacity(eventsDto.getMaximumCapacity());
        event.setDescription(eventsDto.getDescription());

        return event;

    }
}
