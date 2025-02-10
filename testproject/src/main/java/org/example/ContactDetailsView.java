package org.example;

import javax.swing.*;
import java.awt.*;

public class ContactDetailsView extends JPanel {
    JLabel nameLabel;
    JLabel phoneLabel;
    JLabel emailLabel;
    JLabel addressLabel;

    public ContactDetailsView(ContactManager manager) {
        setLayout(new GridLayout(5, 1));

        nameLabel = new JLabel("Name: ");
        phoneLabel = new JLabel("Phone: ");
        emailLabel = new JLabel("Email: ");
        addressLabel = new JLabel("Address: ");

        JButton backButton = new JButton("Back to List");
        backButton.addActionListener(e -> manager.showCard("ListView"));

        add(nameLabel);
        add(phoneLabel);
        add(emailLabel);
        add(addressLabel);
        add(backButton);
    }

    public void updateDetails(Contact contact) {
        nameLabel.setText("Name: " + contact.getName());
        phoneLabel.setText("Phone: " + contact.getPhone());
        emailLabel.setText("Email: " + contact.getEmail());
        addressLabel.setText("Address: " + contact.getAddress());
    }
}
