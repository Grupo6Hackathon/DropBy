package org.academiadecodigo.cheguei.services;

import org.academiadecodigo.cheguei.exceptions.EventNotFoundException;
import org.academiadecodigo.cheguei.exceptions.UserNotFoundException;
import org.academiadecodigo.cheguei.persistence.dao.EventsDao;
import org.academiadecodigo.cheguei.persistence.model.Events.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventsServiceImpl implements EventsService {

    private EventsDao eventsDao;

    @Autowired
    public void setEventsDao(EventsDao eventsDao) {
        this.eventsDao = eventsDao;
    }

    @Override
    public Events getEvent(Integer id) throws EventNotFoundException {

        Events event = eventsDao.findById(id);

        if(event == null){
            throw new EventNotFoundException();
        }

        return event;
    }

    @Override
    public List<Events> findAll() {
        return eventsDao.findAll();
    }

    @Override
    @Transactional
    public Events addEvent(Events events) {
        return eventsDao.saveOrUpdate(events);
    }
}
