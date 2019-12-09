package org.academiadecodigo.cheguei.converters;

import org.academiadecodigo.cheguei.command.UserDto;
import org.academiadecodigo.cheguei.persistence.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDto extends AbstractConverter<User, UserDto> {

    @Override
    public UserDto convert(User user) {


        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setCity(user.getCity());
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());
        userDto.setPassword(user.getPassword());

        return userDto;
    }
}
