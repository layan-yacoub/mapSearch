package com.example.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CityService {
    @Autowired
    private final CityRepository cityRepository;
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }
    private final Map<String, City> cityMap = new HashMap<>();

    //save the search operations  and count every on of them
    public void incrementSearchCount(String cityName) {
        City city = cityMap.get(cityName);
        if (city == null) {
            city = new City();
            city.setCityName(cityName);
            city.setSearchCount(1);
            cityMap.put(cityName, city);
        } else {
            city.setSearchCount(city.getSearchCount() + 1);
        }
        cityRepository.save(city);
    }

    //get all cities sorted by search count
    public List<City> getAllCitiesSortedBySearchCount() {
        List<City> cities = new ArrayList<>(cityMap.values());
        cities.sort(Comparator.comparingInt(City::getSearchCount).reversed());
        return cities;
    }
}
