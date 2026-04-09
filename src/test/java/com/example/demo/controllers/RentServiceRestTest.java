package com.example.demo.controllers;

import com.example.demo.entities.Car;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
public class RentServiceRestTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testAddCar() throws Exception {
        Car car = new Car("ABC123", "Toyota", 15000.0);
        ObjectMapper objectMapper = new ObjectMapper();
        String carJson = objectMapper.writeValueAsString(car);

        mockMvc.perform(post("/cars")
                .contentType("application/json")
                .content(carJson))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetCars() throws Exception {
        Car car = new Car("DEF456", "Honda", 18000.0);
        ObjectMapper objectMapper = new ObjectMapper();
        String carJson = objectMapper.writeValueAsString(car);

        mockMvc.perform(post("/cars")
                .contentType("application/json")
                .content(carJson))
                .andExpect(status().isOk());

        mockMvc.perform(get("/cars"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetCarByPlateNumber() throws Exception {
        Car car = new Car("GHI789", "Ford", 20000.0);
        ObjectMapper objectMapper = new ObjectMapper();
        String carJson = objectMapper.writeValueAsString(car);

        mockMvc.perform(post("/cars")
                .contentType("application/json")
                .content(carJson))
                .andExpect(status().isOk());

        mockMvc.perform(get("/cars/GHI789"))
                .andExpect(status().isOk());
    }
}
