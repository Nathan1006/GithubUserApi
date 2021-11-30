package com.careerdevs.Controllers;


import com.careerdevs.Models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/githubusers")
public class UserController {

    final static String URL = "https://api.github.com/users";

    @GetMapping("/all")
    public User[] allUsers(RestTemplate restTemplate){

        return restTemplate.getForObject(URL, User[].class);

    }

    @GetMapping("/{userID}")
    public Object chosenUser(RestTemplate restTemplate, @PathVariable(name = "userID")String id){

        String userURL = URL + "/" + id;

        try {

            return restTemplate.getForObject(userURL, User.class);

        } catch (Exception e) {

            System.out.println(e.getMessage());
            return e.getMessage();

        }

    }

}
