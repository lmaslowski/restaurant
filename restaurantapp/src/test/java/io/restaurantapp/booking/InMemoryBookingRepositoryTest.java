package io.restaurantapp.booking;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InMemoryBookingRepositoryTest {

    @Test
    void givenRepo_addBooking() {
        final UUID bookingId = UUID.randomUUID();
        final Booking booking = Booking.of(bookingId, "Luk", 2, LocalDateTime.now());
        final InMemoryBookingRepository repo = getInMemoryBookingRepository();

        repo.save(booking);

        final IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> repo.save(booking));
        assertEquals("Booking is already exist", illegalArgumentException.getMessage());
    }

    @Test
    void givenRepoWithOneBooking_whenAddingTheSameBookingAgain_thenThrowsException() {
        final UUID bookingId = UUID.randomUUID();
        final Booking booking = Booking.of(bookingId, "Luk", 2, LocalDateTime.now());
        final InMemoryBookingRepository repo = getInMemoryBookingRepository();
        repo.save(booking);

        final IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> repo.save(booking));
        assertEquals("Booking is already exist", illegalArgumentException.getMessage());
    }

    private InMemoryBookingRepository getInMemoryBookingRepository() {
        return new InMemoryBookingRepository();
    }
}
