package org.example;

import javax.swing.*;
import java.awt.*;

public class ContactFormView extends JPanel {
    private JTextField nameField, phoneField, emailField, addressField;

    public ContactFormView(ContactManager manager) {
        setLayout(new GridLayout(5, 2));

        nameField = new JTextField();
        phoneField = new JTextField();
        emailField = new JTextField();
        addressField = new JTextField();

        JButton saveButton = new JButton("Save Contact");
        JButton cancelButton = new JButton("Cancel");

        saveButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String phone = phoneField.getText().trim();
            String email = emailField.getText().trim();
            String address = addressField.getText().trim();

            if (name.isEmpty() || phone.isEmpty() || email.isEmpty() || address.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields must be filled out!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            manager.addContact(new Contact(name, phone, email, address));
            nameField.setText("");
            phoneField.setText("");
            emailField.setText("");
            addressField.setText("");
            manager.showCard("ListView");
        });

        cancelButton.addActionListener(e -> manager.showCard("ListView"));

        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Phone:"));
        add(phoneField);
        add(new JLabel("Email:"));
        add(emailField);
        add(new JLabel("Address:"));
        add(addressField);
        add(saveButton);
        add(cancelButton);
    }
}
