package io.restaurantapp;

import io.restaurantapp.booking.NewBookingCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestaurantApp {

    @Autowired
    private NewBookingCommandHandler commandHandler;

    public static void main(String[] args) {
        SpringApplication.run(RestaurantApp.class, args);
    }
}
