package com.example.search;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping
public class CityController {
    private final CityService cityService;
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @Value("${positionstack.api.key}")
    private String positionstackApiKey;

    //run the web page
    @GetMapping
    public String map(){
        return "index";
    }

    //save and count the search operations
    @PostMapping("/search")
    public String search(@RequestParam String cityName) {
            cityService.incrementSearchCount(cityName);
            return "redirect:/"; // Redirect back to the main page
    }

    //return searched cities by number of searches
    @GetMapping("/top-cities")
    public List<City> getTopCities() {
        // Retrieve the list of cities sorted by search count
        return cityService.getAllCitiesSortedBySearchCount();
    }
    }

