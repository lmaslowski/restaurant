package io.restaurantapp.booking;

import java.time.Instant;
import java.util.UUID;

public interface Event {

    UUID getEventId();

    Instant getWhen();
}
