package org.trahim.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.trahim.objects.User;

@Controller
public class LoginController {

    @RequestMapping(value = {"/", "login"}, method = RequestMethod.GET)
    public ModelAndView main() {
        return new ModelAndView("login", "user", new User());

    }

    @RequestMapping(value = "/check-user", method = RequestMethod.POST)
    public ModelAndView checkUser(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main");
        modelAndView.addObject("user", user);
        return modelAndView;
    }


}
