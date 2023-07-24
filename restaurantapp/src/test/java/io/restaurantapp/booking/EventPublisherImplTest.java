package io.restaurantapp.booking;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class EventPublisherImplTest {

    @Autowired
    private EventPublisher eventPublisher;

    @Test
    void givenSpringApp_thenContextLoad() {
        assertNotNull(eventPublisher);
    }
}
