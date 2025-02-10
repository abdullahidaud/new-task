package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    @Test
    void testContactCreation() {
        Contact contact = new Contact("John Doe", "1234567890", "john@example.com", "123 Main St");

        assertEquals("John Doe", contact.getName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("john@example.com", contact.getEmail());
        assertEquals("123 Main St", contact.getAddress());
    }
}
