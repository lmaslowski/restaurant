package io.restaurantapp.bookingview;

import io.restaurantapp.booking.BookingPlacedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class BookingEventHandler {

    private final BookingViewRepository repository;

    public BookingEventHandler(BookingViewRepository repository) {
        this.repository = repository;
    }

    @EventListener
    public void handle(BookingPlacedEvent event) {
        repository.add(BookingView.of(event));
    }
}
