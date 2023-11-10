package com.makers.makersbnb.controller;

import com.makers.makersbnb.model.Space;
import com.makers.makersbnb.repository.SpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;


// tell Spring Boot this class is a controller
@RestController
public class SpacesController {

    //    Dependency Injection : Spring automatically initialises the controller and dependencies whe naa request comes in
//    private final SpaceRepository spaceRepository; // Define field name as a SpaceRepository object
//    public SpacesController(SpaceRepository spaceRepository) { // Setting up a constructor to take
//        this.spaceRepository = spaceRepository;                     // and assign a Space Repository object into the
//    }                                                                  // StaticPageController class as an instance field

    @Autowired
    private SpaceRepository spaceRepository;
    @GetMapping("/spaces")
    public ModelAndView getSpaces() {

        ModelAndView modelAndView = new ModelAndView("spaces/index");

        Iterable<Space> spacesList = spaceRepository.findAll();
        modelAndView.addObject("spaces", spacesList);

        return modelAndView;
    }

    @GetMapping("/spaces/new")
    public ModelAndView newSpaceForm(@AuthenticationPrincipal OAuth2User principal) {
        // this is the space referred to in th:object (look back at the form code)

        ModelAndView newSpaceForm = new ModelAndView("spaces/new");

        Map attributes = principal.getAttributes();

        String owner;
        owner = (String) attributes.get("name");
        newSpaceForm.addObject("owner", owner);

        Space space = new Space();
        newSpaceForm.addObject("space", space);

        System.out.println("Here!");

        return newSpaceForm;
    }


    // Spring Boot uses the form data to create an instance of space
    // which is then passed in as an arg here
    @PostMapping("/spaces")
    public RedirectView create(Space space, @AuthenticationPrincipal OAuth2User principal) {
        String owner;

        Map attributes = principal.getAttributes();
        owner = (String) attributes.get("name");
        space.setOwner(owner);

        System.out.println("hello");
        System.out.println(space.getOwner());

        spaceRepository.save(space);

        // assumes you already created a method to handle `GET "/spaces"`
        return new RedirectView("/spaces");
    }
}
