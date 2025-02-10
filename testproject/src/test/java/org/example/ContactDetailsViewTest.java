package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactDetailsViewTest {
    @Test
    void testUpdateDetails() {
        ContactManager manager = new ContactManager();
        ContactDetailsView detailsView = new ContactDetailsView(manager);
        Contact contact = new Contact("Bob", "5551112222", "bob@example.com", "789 Oak St");

        detailsView.updateDetails(contact);

        assertEquals("Name: Bob", detailsView.nameLabel.getText());
        assertEquals("Phone: 5551112222", detailsView.phoneLabel.getText());
        assertEquals("Email: bob@example.com", detailsView.emailLabel.getText());
        assertEquals("Address: 789 Oak St", detailsView.addressLabel.getText());
    }
}
