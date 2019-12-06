package org.academiadecodigo.cheguei.controller.web;

import org.academiadecodigo.cheguei.command.UserDto;
import org.academiadecodigo.cheguei.converters.UserDtoToUser;
import org.academiadecodigo.cheguei.converters.UserToUserDto;
import org.academiadecodigo.cheguei.persistence.model.User;
import org.academiadecodigo.cheguei.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class WebController {

    private UserService userService;

    private UserDtoToUser userDtoToUser;
    private UserToUserDto userToUserDto;

    @Autowired
    public void setUserDtoToUser(UserDtoToUser userDtoToUser) {
        this.userDtoToUser = userDtoToUser;
    }

    @Autowired
    public void setUserToUserDto(UserToUserDto userToUserDto) {
        this.userToUserDto = userToUserDto;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/index")
    public String home() {
        return "index/index";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/login")
    public String login(Model model) {
        model.addAttribute("userMock", new UserDto());

        return "login/login";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/loginmock")
    public String login(@ModelAttribute("user") UserDto userDto, HttpSession httpSession) {

        if (userService.checkUsername(userDto) && userService.checkPassword(userDto)) {

            for (User user : userService.list()) {
                if (user.getUsername().equals(userDto.getUsername())) {
                    httpSession.setAttribute("user", user);
                    return "redirect:/index";
                }
            }

        }

        System.out.println("USER DOES NOT EXIST!");
        return "redirect:/login";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/register")
    public String register(Model model) {

        model.addAttribute("user", new UserDto());

        return "register/register";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/register")
    public String register2(@Valid @ModelAttribute("user") UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {


        if (bindingResult.hasErrors()) {
            return "register/register";
        }

        User user = userService.save(userDtoToUser.convert(userDto));

        redirectAttributes.addFlashAttribute("lastAction", user.getFirstName() + " " + user.getLastName() + " was created with success.");
        return "redirect:/login";
    }
}
