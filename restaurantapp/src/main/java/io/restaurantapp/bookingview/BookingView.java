package io.restaurantapp.bookingview;

import io.restaurantapp.booking.BookingPlacedEvent;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class BookingView {

    private UUID bookingId;

    private String customerName;

    private Integer tableSize;

    private LocalDateTime dateTime;

    private BookingView(UUID bookingId, String customerName, Integer tableSize, LocalDateTime dateTime) {
        this.bookingId = bookingId;
        this.customerName = customerName;
        this.tableSize = tableSize;
        this.dateTime = dateTime;
    }

    public static BookingView of(BookingPlacedEvent event) {
        return new BookingView(event.getBookingId(),
                event.getCustomerName(),
                event.getTableSize(),
                event.getDateTime());
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

    @Override
    public String toString() {
        return "BookingView{" +
                "bookingId=" + bookingId +
                ", customerName='" + customerName + '\'' +
                ", tableSize=" + tableSize +
                ", dateTime=" + dateTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookingView)) return false;
        BookingView that = (BookingView) o;
        return Objects.equals(getBookingId(), that.getBookingId()) && Objects.equals(getCustomerName(), that.getCustomerName()) && Objects.equals(getTableSize(), that.getTableSize()) && Objects.equals(getDateTime(), that.getDateTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookingId(), getCustomerName(), getTableSize(), getDateTime());
    }
}
