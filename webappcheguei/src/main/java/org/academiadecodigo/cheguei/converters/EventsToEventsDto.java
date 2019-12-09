package org.academiadecodigo.cheguei.converters;

import org.academiadecodigo.cheguei.command.EventsDto;
import org.academiadecodigo.cheguei.persistence.model.Events.Events;
import org.springframework.stereotype.Component;

@Component
public class EventsToEventsDto extends AbstractConverter<Events, EventsDto> {


    @Override
    public EventsDto convert(Events events) {

        EventsDto eventsDto = new EventsDto();

        eventsDto.setAddress(events.getAddress());
        eventsDto.setDate(events.getDate());
        eventsDto.setDescription(events.getDescription());
        eventsDto.setEventTitle(events.getEventTitle());
        eventsDto.setMaximumCapacity(events.getMaximumCapacity());

        return eventsDto;
    }
}
