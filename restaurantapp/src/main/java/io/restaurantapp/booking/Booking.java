package io.restaurantapp.booking;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class
Booking {

    private UUID bookingId;

    private String customerName;

    private Integer tableSize;

    private LocalDateTime dateTime;

    private Booking(UUID bookingId, String customerName, Integer tableSize, LocalDateTime dateTime) {
        this.bookingId = bookingId;
        this.customerName = customerName;
        this.tableSize = tableSize;
        this.dateTime = dateTime;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking)) return false;
        Booking booking = (Booking) o;
        return Objects.equals(getBookingId(), booking.getBookingId()) && Objects.equals(getCustomerName(), booking.getCustomerName()) && Objects.equals(getTableSize(), booking.getTableSize()) && Objects.equals(getDateTime(), booking.getDateTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookingId(), getCustomerName(), getTableSize(), getDateTime());
    }

    public static Booking of(UUID bookingId, String customerName, Integer tableSize, LocalDateTime dateTime) {
        return new Booking(bookingId, customerName, tableSize, dateTime);
    }

    public static Booking of(NewBookingCommand command) {
        return of(command.getBookingId(), command.getCustomerName(), command.getTableSize(), command.getDateTime());
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", customerName='" + customerName + '\'' +
                ", tableSize=" + tableSize +
                ", dateTime=" + dateTime +
                '}';
    }
}
