package io.restaurantapp.bookingview;

import java.util.List;

public interface BookingViewRepository {

    void add(BookingView of);

    List<BookingView> getAll();
}
