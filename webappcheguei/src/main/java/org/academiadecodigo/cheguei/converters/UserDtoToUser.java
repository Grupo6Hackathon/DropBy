package org.academiadecodigo.cheguei.converters;

import org.academiadecodigo.cheguei.commnad.UserDto;
import org.academiadecodigo.cheguei.persistence.model.User;
import org.springframework.core.convert.converter.Converter;

public class UserDtoToUser implements Converter<UserDto, User> {
    @Override
    public User convert(UserDto userDto) {
        return null;
    }
}
