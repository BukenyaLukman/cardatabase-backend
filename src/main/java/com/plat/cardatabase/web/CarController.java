package com.plat.cardatabase.web;


import com.plat.cardatabase.domain.Car;
import com.plat.cardatabase.domain.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    @Autowired
    private CarRepository repository;

    @RequestMapping("/cars")
    public Iterable<Car> getCars(){
        // Fetch and return cars
        return repository.findAll();
    }
}
