package org.academiadecodigo.cheguei.services;

import org.academiadecodigo.cheguei.command.UserDto;
import org.academiadecodigo.cheguei.exceptions.EventNotFoundException;
import org.academiadecodigo.cheguei.exceptions.UserNotFoundException;
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
    public void delete(Integer id) throws UserNotFoundException {
        User user = userDao.findById(id);

        if(user == null){
            throw new UserNotFoundException();
        }

        userDao.delete(id);
    }

    @Override
    public List<User> list() {
        return userDao.findAll();
    }

    @Override
    public boolean checkUsername(UserDto userDto) {

        for(User user: userDao.findAll()) {
            if(user.getUsername().equals(userDto.getUsername())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkPassword(UserDto userDto) {

        for (User user: userDao.findAll()) {
            if(user.getPassword().equals(userDto.getPassword())) {
                return true;
            }
        }
        return false;
    }

    @Transactional
    @Override
    public Events addEvent(Integer id, Events event) throws UserNotFoundException{

        User user = userDao.findById(id);
        if(user == null){
            throw new UserNotFoundException();
        }

        user.addEvents(event);
        userDao.saveOrUpdate(user);

        return user.getEvents().get(user.getEvents().size() - 1);
    }

    @Transactional
    @Override
    public void deleteEvent(Integer id, Integer eventId) throws UserNotFoundException, EventNotFoundException {
        User user = userDao.findById(id);
        Events event = eventsDao.findById(id);

        if(user == null){
            throw new UserNotFoundException();
        }

        if(event == null || !event.getUser().getId().equals(id)){
            throw new EventNotFoundException();
        }

        user.removeEvents(event);
        userDao.saveOrUpdate(user);
    }
}
