package io.restaurantapp.bookingview;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingViewResource{

    private final BookingViewRepository repository;

    public BookingViewResource(BookingViewRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/restaurant/bookingview")
    @ResponseBody
    public List<BookingView> getAll() {
        return repository.getAll();
    }
}
