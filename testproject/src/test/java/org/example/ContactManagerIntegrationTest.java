package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactManagerIntegrationTest {
    private ContactManager manager;

    @BeforeEach
    void setUp() {
        manager = new ContactManager();
    }

    @Test
    void testFullFlow() {
        Contact newContact = new Contact("Charlie", "9998887777", "charlie@example.com", "321 Pine St");
        manager.addContact(newContact);

        manager.getContactList().setSelectedIndex(0);
        assertNotNull(manager.getSelectedContact());

        manager.showDetails();
        assertEquals("Charlie", manager.getSelectedContact().getName());
    }
}

