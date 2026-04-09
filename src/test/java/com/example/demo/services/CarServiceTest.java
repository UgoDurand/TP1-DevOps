package com.example.demo.services;

import com.example.demo.entities.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarServiceTest {

    private CarService carService;

    @BeforeEach
    public void setUp() {
        carService = new CarService();
    }

    @Test
    public void testAddCar() {
        Car car = new Car("ABC123", "Toyota", 15000.0);
        carService.addCar(car);
        assertEquals(1, carService.getCars().size());
    }

    @Test
    public void testGetCars() {
        Car car = new Car("ABC123", "Toyota", 15000.0);
        carService.addCar(car);
        assertEquals(1, carService.getCars().size());
        assertEquals("ABC123", carService.getCars().get(0).getPlateNumber());
    }

    @Test
    public void testGetCarByPlateNumber() {
        Car car = new Car("ABC123", "Toyota", 15000.0);
        carService.addCar(car);
        Car found = carService.getCar("ABC123");
        assertNotNull(found);
        assertEquals("Toyota", found.getBrand());
    }

    @Test
    public void testGetCarNotFound() {
        Car result = carService.getCar("NONEXISTENT");
        assertNull(result);
    }

    @Test
    public void testAddMultipleCars() {
        carService.addCar(new Car("ABC123", "Toyota", 15000.0));
        carService.addCar(new Car("DEF456", "Honda", 18000.0));
        carService.addCar(new Car("GHI789", "Ford", 20000.0));
        assertEquals(3, carService.getCars().size());
    }
}
