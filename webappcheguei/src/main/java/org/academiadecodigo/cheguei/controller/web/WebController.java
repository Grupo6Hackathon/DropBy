package org.academiadecodigo.cheguei.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class WebController {

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String home() {
        return "login/login";
    }

}
