package org.academiadecodigo.cheguei.services;

import org.academiadecodigo.cheguei.exceptions.EventNotFoundException;
import org.academiadecodigo.cheguei.persistence.model.Events.Events;

import java.util.List;

public interface EventsService {

    Events getEvent(Integer id) throws EventNotFoundException;

    List<Events> findAll();

    Events addEvent(Events events);
}
