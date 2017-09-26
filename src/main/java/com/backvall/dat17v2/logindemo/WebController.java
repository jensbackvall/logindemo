package com.backvall.dat17v2.logindemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {

    List<User> users = new ArrayList<>();
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        System.out.println("index() blev kaldt med GET");
        return "index"; //peger på index.html som vi laver
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(@ModelAttribute User user_, Model model) {
        users.add(user_); //er nu gemt!!
        model.addAttribute("users", users); //users er nu synlig i webdelen
        System.out.println("login() blev kaldt med POST " + user_.getUsername());
        return "login"; //peger på login.html som vi laver
    }
}
