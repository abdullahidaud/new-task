package org.example;

import javax.swing.*;
import java.awt.*;

public class ContactListView extends JPanel {
    public ContactListView(ContactManager manager) {
        setLayout(new BorderLayout());

        JButton addButton = new JButton("Add New Contact");
        JButton viewButton = new JButton("View Details");

        addButton.addActionListener(e -> manager.showCard("FormView"));
        viewButton.addActionListener(e -> manager.showDetails());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(viewButton);

        add(new JScrollPane(manager.getContactList()), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
