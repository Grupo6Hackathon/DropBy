package org.academiadecodigo.cheguei.services;

import org.academiadecodigo.cheguei.persistence.dao.EventsDao;
import org.academiadecodigo.cheguei.persistence.dao.UserDao;
import org.academiadecodigo.cheguei.persistence.model.Events.Events;
import org.academiadecodigo.cheguei.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private EventsDao eventsDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setEventsDao(EventsDao eventsDao) {
        this.eventsDao = eventsDao;
    }

    @Override
    public User getUser(Integer id) {
        return userDao.findById(id);
    }

    @Transactional
    @Override
    public User save(User user) {
        return userDao.saveOrUpdate(user);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        User user = userDao.findById(id);

        userDao.delete(id);
    }

    @Override
    public List<User> list() {
        return userDao.findAll();
    }

    @Transactional
    @Override
    public Events addEvent(Integer id, Events event) {

        User user = userDao.findById(id);

        user.addEvents(event);
        userDao.saveOrUpdate(user);

        return user.getEvents().get(user.getEvents().size() - 1);
    }

    @Transactional
    @Override
    public void deleteEvent(Integer id, Integer eventId) {
        User user = userDao.findById(id);
        Events event = eventsDao.findById(id);

        user.removeEvents(event);
        userDao.saveOrUpdate(user);
    }
}
