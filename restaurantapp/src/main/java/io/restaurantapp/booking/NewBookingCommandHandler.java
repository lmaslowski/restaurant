package io.restaurantapp.booking;

import org.springframework.stereotype.Service;

@Service
public class NewBookingCommandHandler{

    private final BookingWriteRepository repository;

    private final EventPublisher eventPublisher;

    public NewBookingCommandHandler(BookingWriteRepository repository, EventPublisher eventPublisher) {
        this.repository = repository;
        this.eventPublisher = eventPublisher;
    }

    public void handle(NewBookingCommand command) {
        final Booking booking = Booking.of(command);

        repository.save(booking);

        eventPublisher.publish(new BookingPlacedEvent(booking.getBookingId(),
                booking.getCustomerName(),
                booking.getTableSize(),
                booking.getDateTime()));
    }
}
