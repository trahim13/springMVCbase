package org.trahim.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import org.trahim.objects.User;

import javax.validation.Valid;
import java.util.Locale;

@Controller
@SessionAttributes("user")
public class LoginController {

    @Autowired
    MessageSource messageSource;

    @ModelAttribute("user")
    public User createUser() {
        return new User();
    }

    @RequestMapping(value = {"/", "login"}, method = RequestMethod.GET)
    public ModelAndView main(@ModelAttribute User user) {
        return new ModelAndView("login", "user", user);

    }

    @RequestMapping(value = "/check-user", method = RequestMethod.POST)
    public ModelAndView checkUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, ModelAndView modelAndView, Locale locale, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("login");
        } else {
            RedirectView redirectView = new RedirectView("mainpage");
            redirectView.setStatusCode(HttpStatus.MOVED_PERMANENTLY);

            String message = messageSource.getMessage("locale", new String[]{locale.getDisplayName(locale)}, locale);
//            redirectAttributes.addFlashAttribute("locale", message);
            modelAndView.addObject("locale", message);
            modelAndView.setView(redirectView);



//            modelAndView.addObject("user", user);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/mainpage", method = RequestMethod.GET)
    public String goToMainPage(ModelAndView modelAndView,  @ModelAttribute("locale") String s) {
        return "main";
    }

    @RequestMapping(value = "/failed", method = RequestMethod.GET)
    public ModelAndView loginFailed(ModelAndView modelAndView, Locale locale) {
        modelAndView.addObject("loginError", messageSource.getMessage("login-failed", null, locale));
        modelAndView.setViewName("login-failed");

        return modelAndView;
    }


    @RequestMapping(value = "/get-json-user/{name}/{password}/{admin}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public User getJsonUser(@PathVariable("name") String name, @PathVariable("password") String password, @PathVariable("admin") boolean admin) {
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
