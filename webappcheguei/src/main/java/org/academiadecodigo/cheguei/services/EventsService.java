package org.academiadecodigo.cheguei.services;

import org.academiadecodigo.cheguei.persistence.model.Events.Events;

import java.util.List;

public interface EventsService {

    Events getEvent(Integer id);

    List<Events> findAll();

    Events addEvent(Events events);
}
