package org.academiadecodigo.cheguei.controller.rest;

import org.academiadecodigo.cheguei.command.UserDto;
import org.academiadecodigo.cheguei.converters.UserDtoToUser;
import org.academiadecodigo.cheguei.converters.UserToUserDto;
import org.academiadecodigo.cheguei.persistence.model.User;
import org.academiadecodigo.cheguei.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class RestUserController {

    private UserService userService;
    private UserDtoToUser userDtoToUser;
    private UserToUserDto userToUserDto;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserDtoToUser(UserDtoToUser userDtoToUser) {
        this.userDtoToUser = userDtoToUser;
    }

    @Autowired
    public void setUserToUserDto(UserToUserDto userToUserDto) {
        this.userToUserDto = userToUserDto;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public ResponseEntity<List<UserDto>> listUsers(){

        List<UserDto> userDtos = new ArrayList<>();

        for(User user : userService.list()){
            userDtos.add(userToUserDto.convert(user));
        }

        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<UserDto> showUser(@PathVariable Integer id){

        User user = userService.getUser(id);

        return new ResponseEntity<>(userToUserDto.convert(user), HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST, path = {"/", ""})
    public ResponseEntity<?> addUser(@Valid @RequestBody UserDto userDto, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder){

        if (bindingResult.hasErrors() || userDto.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


        User savedUser = userService.save(userDtoToUser.convert(userDto));

        UriComponents uriComponents = uriComponentsBuilder.path("/user" + savedUser.getId()).build();

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);

    }


    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable Integer id){

        userService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


}
