package org.trahim.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.trahim.objects.User;

import javax.validation.Valid;

@Controller
public class LoginController {

    @RequestMapping(value = {"/", "login"}, method = RequestMethod.GET)
    public ModelAndView main() {
        return new ModelAndView("login", "user", new User());

    }

    @RequestMapping(value = "/check-user", method = RequestMethod.POST)
    public ModelAndView checkUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("login");
        } else {
            modelAndView.setViewName("main");
            modelAndView.addObject("user", user);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/failed", method = RequestMethod.GET)
    public ModelAndView loginFailed() {
        return new ModelAndView("login-failed", "loginError", "Login is failed!");
    }





    @RequestMapping(value = "/get-json-user/{name}/{password}/{admin}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public User getJsonUser(@PathVariable("name") String name, @PathVariable("password") String password,@PathVariable("admin") boolean admin) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setAdmin(admin);
        return user;
    }

    @RequestMapping(value = "/put-json-user", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> setJsonUser(@RequestBody User user) {

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
