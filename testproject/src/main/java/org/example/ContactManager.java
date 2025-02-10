package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import org.example.ContactDetailsView;
public class ContactManager {
    private JFrame frame;
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private DefaultListModel<String> listModel;
    private JList<String> contactList;
    private ArrayList<Contact> contacts;
    private ContactDetailsView detailsView;

    public ContactManager() {
        frame = new JFrame("Contact Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 350);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        contacts = new ArrayList<>();
        listModel = new DefaultListModel<>();
        contactList = new JList<>(listModel);
        detailsView = new ContactDetailsView(this);

        mainPanel.add(new ContactListView(this), "ListView");
        mainPanel.add(detailsView, "DetailsView");
        mainPanel.add(new ContactFormView(this), "FormView");

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        listModel.addElement(contact.getName());
    }

    public Contact getSelectedContact() {
        int selectedIndex = contactList.getSelectedIndex();
        return (selectedIndex != -1) ? contacts.get(selectedIndex) : null;
    }

    public void showDetails() {
        Contact contact = getSelectedContact();
        if (contact != null) {
            detailsView.updateDetails(contact);
            showCard("DetailsView");
        } else {
            JOptionPane.showMessageDialog(frame, "Please select a contact to view details.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public JList<String> getContactList() {
        return contactList;
    }

    public void showCard(String cardName) {
        cardLayout.show(mainPanel, cardName);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ContactManager::new);
    }
}
