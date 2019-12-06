package org.academiadecodigo.cheguei.services;

import org.academiadecodigo.cheguei.command.UserDto;
import org.academiadecodigo.cheguei.exceptions.EventNotFoundException;
import org.academiadecodigo.cheguei.exceptions.UserNotFoundException;
import org.academiadecodigo.cheguei.persistence.model.Events.Events;
import org.academiadecodigo.cheguei.persistence.model.User;

import java.util.List;

public interface UserService {

    User getUser(Integer id);

    User save(User user);

    void delete(Integer id) throws UserNotFoundException;

    List<User> list();

    Events addEvent(Integer id, Events event) throws UserNotFoundException;

    void deleteEvent(Integer id, Integer eventId) throws UserNotFoundException, EventNotFoundException;

    boolean checkPassword(UserDto userDto);

    boolean checkUsername(UserDto userDto);
}
