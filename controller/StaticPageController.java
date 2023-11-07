package com.makers.makersbnb.controller;

import com.makers.makersbnb.model.Space;
import com.makers.makersbnb.repository.SpaceRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;


// tell Spring Boot this class is a controller
@RestController
public class StaticPageController {
    private final SpaceRepository spaceRepository;
    public StaticPageController(SpaceRepository spaceRepository) {
        this.spaceRepository = spaceRepository;
    }

    @GetMapping("/")
    public ModelAndView welcome() {

        ModelAndView modelAndView = new ModelAndView("/LandingPage");

        Integer nSpaces = Math.toIntExact(spaceRepository.count());
        modelAndView.addObject("nSpaces", nSpaces);

        String[] reviews = new String[] {"Awesome", "Nice", "Perfect"}; // String[] literal
        modelAndView.addObject("reviews", reviews);

        Integer numBookings = 123;
        modelAndView.addObject("bookings", numBookings);

        return modelAndView;
    }

    @GetMapping("/contactus")
    public String contactUs() {
        return "fake@email.com";
    }

    @GetMapping("/termsandconditions")
    public String termsAndConditions() {
        return "Coming soon! In the meantime, please behave yourselves.";
    }

    @GetMapping("/signup")
    public ModelAndView signUp() {
        ModelAndView modelAndView = new ModelAndView("/SignUp");
        Integer nextUser = 57;
        modelAndView.addObject("nextUser", nextUser);
        return modelAndView;
    }
}
