package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class contactManagerTest {
    private ContactManager manager;

    @BeforeEach
    void setUp() {
        manager = new ContactManager();
    }

    @Test
    void testAddContact() {
        Contact contact = new Contact("Alice", "9876543210", "alice@example.com", "456 Elm St");
        manager.addContact(contact);

        assertEquals("Alice", manager.getSelectedContact().getName());
    }
}
