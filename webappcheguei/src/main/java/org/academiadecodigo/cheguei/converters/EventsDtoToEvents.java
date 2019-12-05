package org.academiadecodigo.cheguei.converters;

import org.academiadecodigo.cheguei.commnad.EventsDto;
import org.academiadecodigo.cheguei.persistence.model.Events.Events;
import org.springframework.core.convert.converter.Converter;

public class EventsDtoToEvents implements Converter<EventsDto, Events> {

    @Override
    public Events convert(EventsDto eventsDto) {
        return null;
    }
}
