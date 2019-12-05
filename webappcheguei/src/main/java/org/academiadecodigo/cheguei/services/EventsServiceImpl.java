package org.academiadecodigo.cheguei.services;

import org.academiadecodigo.cheguei.persistence.dao.EventsDao;
import org.academiadecodigo.cheguei.persistence.model.Events.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventsServiceImpl implements EventsService {

    private EventsDao eventsDao;

    @Autowired
    public void setEventsDao(EventsDao eventsDao) {
        this.eventsDao = eventsDao;
    }

    @Override
    public Events getEvent(Integer id) {
        return eventsDao.findById(id);
    }
}
