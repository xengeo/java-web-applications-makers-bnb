package com.makers.makersbnb.controller;

import com.makers.makersbnb.model.Space;
import com.makers.makersbnb.repository.SpaceRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.Optional;


// tell Spring Boot this class is a controller
@RestController
public class StaticPageController {

//    Dependency Injection :
    private final SpaceRepository spaceRepository; // Define field name as a SpaceRepository object
    public StaticPageController(SpaceRepository spaceRepository) { // Setting up a constructor to take
        this.spaceRepository = spaceRepository;                     // and assign a Space Repository object into the
    }                                                                  // StaticPageController class as an instance field

    @GetMapping("/")
    public ModelAndView welcome(@AuthenticationPrincipal OAuth2User principal) {
        ModelAndView modelAndView = new ModelAndView("/LandingPage");

        // getAttributes of logged in user
        Map attributes = principal.getAttributes();
        String username;
        username = (String) attributes.get("name");

        if (username.isEmpty()) {
            String welcomeMessage = "";
            modelAndView.addObject("welcomeMessage", welcomeMessage);
        } else {
            String welcomeMessage = "Welcome, " + username;
            modelAndView.addObject("welcomeMessage", welcomeMessage);
        }

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
