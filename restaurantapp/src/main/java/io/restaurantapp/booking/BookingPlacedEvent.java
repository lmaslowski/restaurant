package io.restaurantapp.booking;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

public class BookingPlacedEvent implements Event {

    private final UUID eventId;

    private final Instant when;

    private final UUID bookingId;

    private final String customerName;

    private final Integer tableSize;

    private final LocalDateTime dateTime;

    public BookingPlacedEvent(UUID eventId, Instant when, UUID bookingId, String customerName, Integer tableSize, LocalDateTime dateTime) {
        this.eventId = eventId;
        this.when = when;
        this.bookingId = bookingId;
        this.customerName = customerName;
        this.tableSize = tableSize;
        this.dateTime = dateTime;
    }

    public BookingPlacedEvent(UUID bookingId, String customerName, Integer tableSize, LocalDateTime dateTime) {
        this.eventId = UUID.randomUUID();
        this.when = Instant.now();
        this.bookingId = bookingId;
        this.customerName = customerName;
        this.tableSize = tableSize;
        this.dateTime = dateTime;
    }

    @Override
    public UUID getEventId() {
        return eventId;
    }

    @Override
    public Instant getWhen() {
        return when;
    }

    public UUID getBookingId() {
        return bookingId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Integer getTableSize() {
        return tableSize;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
