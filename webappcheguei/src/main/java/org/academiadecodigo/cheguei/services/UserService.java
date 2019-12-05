package org.academiadecodigo.cheguei.services;

import org.academiadecodigo.cheguei.persistence.model.Events.Events;
import org.academiadecodigo.cheguei.persistence.model.User;

import java.util.List;

public interface UserService {

    User getUser(Integer id);

    User save(User user);

    void delete(Integer id);

    List<User> list();

    Events addEvent(Integer id, Events event);

    void deleteEvent(Integer id, Integer eventId);
}
