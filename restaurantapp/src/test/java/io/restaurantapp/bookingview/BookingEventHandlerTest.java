package io.restaurantapp.bookingview;

import io.restaurantapp.booking.BookingPlacedEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BookingEventHandlerTest {

    @Autowired
    private BookingEventHandler bookingEventHandler;

    @Autowired
    private BookingViewRepository repository;

    @Test
    void givenWorkingService_whenHandleEvent_thenEventIsHandled() {
        final BookingPlacedEvent event = new BookingPlacedEvent(
                UUID.randomUUID(),
                Instant.now(),
                UUID.randomUUID(),
                "Luk",
                3,
                LocalDateTime.now());
        bookingEventHandler.handle(event);

        assertEquals(repository.getAll(), List.of(BookingView.of(event)));
    }
}
