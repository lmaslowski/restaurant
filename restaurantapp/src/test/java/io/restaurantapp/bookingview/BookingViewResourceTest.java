package io.restaurantapp.bookingview;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class BookingViewResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void givenWorkingService_whenRequestGetAllBookings_returnsStatusOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/restaurant/bookingview"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
