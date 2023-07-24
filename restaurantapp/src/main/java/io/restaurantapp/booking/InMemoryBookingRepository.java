package io.restaurantapp.booking;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryBookingRepository implements BookingWriteRepository {

    private final Map<UUID, Booking> storage = new ConcurrentHashMap<>();

    @Override
    public void save(Booking booking) {
        if (null != storage.get(booking.getBookingId())) {
            throw new IllegalArgumentException("Booking is already exist");
        } else {
            storage.put(booking.getBookingId(), booking);
        }
    }
}
