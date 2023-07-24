package io.restaurantapp.booking;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@AutoConfigureMockMvc
class BookingResourceTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NewBookingCommandHandler commandHandler;

    @Test
    void givenWorkingService_whenRequestNewBooking_returnsStatusOk() throws Exception {
        final NewBookingCommand command = new NewBookingCommand(
                UUID.randomUUID(),
                "Luke",
                5,
                LocalDateTime.now());

        mockMvc.perform(MockMvcRequestBuilders.post("/restaurant/booking").contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(command)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());

        final NewBookingCommand expectingCommand = objectMapper.readValue(objectMapper.writeValueAsString(command), NewBookingCommand.class);
        verify(commandHandler, times(1)).handle(expectingCommand);
    }

    @Test
    void givenWorkingService_whenRequestNewBookingWithInvalid_returnStatusBadRequest() throws Exception {
        final NewBookingCommand command = new NewBookingCommand(null, "", 0, null);

        mockMvc.perform(MockMvcRequestBuilders.post("/restaurant/booking").contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(command)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}
