package io.restaurantapp.booking;

import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingResource {

    private final NewBookingCommandHandler commandHandler;

    public BookingResource(NewBookingCommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    @PostMapping(value = "/restaurant/booking", produces= MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void post(@Valid @RequestBody NewBookingCommand command) {
        commandHandler.handle(command);
    }
}
