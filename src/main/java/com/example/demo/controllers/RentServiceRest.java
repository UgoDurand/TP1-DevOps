package com.example.demo.controllers;

import com.example.demo.entities.Car;
import com.example.demo.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class RentServiceRest {

    @Autowired
    private CarService carService;

    @GetMapping("/")
    public String sayHello(){
        return "Hello";
    }

    @PostMapping("/cars")
    public void addCar(@RequestBody Car car){
        carService.addCar(car);
    }

    @GetMapping("/cars")
    public List<Car> getCars(){
        return carService.getCars();
    }

    @GetMapping("/cars/{plateNumber}")
    public Car getCar(@PathVariable String plateNumber){
        return carService.getCar(plateNumber);
    }
}
