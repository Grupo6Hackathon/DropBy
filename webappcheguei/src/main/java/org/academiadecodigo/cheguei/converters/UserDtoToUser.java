package org.academiadecodigo.cheguei.converters;

import org.academiadecodigo.cheguei.command.UserDto;
import org.academiadecodigo.cheguei.persistence.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUser implements Converter<UserDto, User> {

    @Override
    public User convert(UserDto userDto) {

        User user = new User();

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setCity(userDto.getCity());
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setPhone(userDto.getPhone());

        return user;
    }


}
