package io.restaurantapp.bookingview;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingViewRepositoryImpl implements BookingViewRepository {

    private final List<BookingView> storage = new ArrayList<>();

    @Override
    public void add(BookingView bookingView) {
        storage.add(bookingView);
    }

    @Override
    public List<BookingView> getAll() {
        return new ArrayList<>(storage);
    }
}
