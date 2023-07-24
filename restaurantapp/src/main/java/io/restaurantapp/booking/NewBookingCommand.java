package io.restaurantapp.booking;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class NewBookingCommand{

    @NotNull(message = "booking id not null")
    private UUID bookingId;

    @NotEmpty
    @Size(min = 3)
    private String customerName;

    @Min(2)
    @Max(6)
    private Integer tableSize;

    @NotNull
    private LocalDateTime dateTime;

    public NewBookingCommand() {
    }

    public NewBookingCommand(UUID bookingId, String customerName, Integer tableSize, LocalDateTime dateTime) {
        this.bookingId = bookingId;
        this.customerName = customerName;
        this.tableSize = tableSize;
        this.dateTime = dateTime;
    }

    public void setBookingId(UUID bookingId) {
        this.bookingId = bookingId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setTableSize(Integer tableSize) {
        this.tableSize = tableSize;
    }

    public void setDateTime(LocalDateTime dateTime) {
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

//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Europe/Zagreb")
//    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
//    @JsonSerialize(using = LocalDateTimeSerializer.class)

//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
//    @JsonSerialize(using = LocalDateTimeSerializer.class)

//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Europe/Zagreb")
//    @JsonDeserialize
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "NewBookingCommand{" +
                "bookingId=" + bookingId +
                ", customerName='" + customerName + '\'' +
                ", tableSize=" + tableSize +
                ", dateTime=" + dateTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NewBookingCommand)) return false;
        NewBookingCommand that = (NewBookingCommand) o;
        return Objects.equals(getBookingId(), that.getBookingId()) && Objects.equals(getCustomerName(), that.getCustomerName()) && Objects.equals(getTableSize(), that.getTableSize()) && Objects.equals(getDateTime(), that.getDateTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookingId(), getCustomerName(), getTableSize(), getDateTime());
    }
}
