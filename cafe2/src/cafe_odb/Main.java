package cafe_odb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Launch the GUI
        SwingUtilities.invokeLater(Main::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Cafe Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Main Panel
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Title
        JLabel titleLabel = new JLabel("Cafe Management System", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Buttons Panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(2, 3, 10, 10));

        JButton addCustomerButton = new JButton("Add Customer");
        JButton viewCustomersButton = new JButton("View Customers");
        JButton addOrderButton = new JButton("Add Order");
        JButton viewOrdersButton = new JButton("View Orders");
        JButton addProductButton = new JButton("Add Product");
        JButton viewProductsButton = new JButton("View Products");

        buttonsPanel.add(addCustomerButton);
        buttonsPanel.add(viewCustomersButton);
        buttonsPanel.add(addOrderButton);
        buttonsPanel.add(viewOrdersButton);
        buttonsPanel.add(addProductButton);
        buttonsPanel.add(viewProductsButton);

        mainPanel.add(buttonsPanel, BorderLayout.CENTER);

        frame.add(mainPanel);

        // Add action listeners
        addCustomerButton.addActionListener(e -> showAddCustomerDialog(frame));
        viewCustomersButton.addActionListener(e -> showCustomersList(frame));
        addOrderButton.addActionListener(e -> showAddOrderDialog(frame));
        viewOrdersButton.addActionListener(e -> showOrdersList(frame));
        addProductButton.addActionListener(e -> showAddProductDialog(frame));
        viewProductsButton.addActionListener(e -> showProductsList(frame));

        frame.setVisible(true);
    }

    private static void showAddCustomerDialog(JFrame frame) {
        JTextField nameField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField phoneField = new JTextField();
        JTextField addressField = new JTextField();

        Object[] fields = {
            "Name:", nameField,
            "Email:", emailField,
            "Phone:", phoneField,
            "Address:", addressField
        };

        int option = JOptionPane.showConfirmDialog(frame, fields, "Add Customer", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            customer c = new customer(nameField.getText(), emailField.getText(), phoneField.getText(), addressField.getText());
            operations.addCustomer(c);
            JOptionPane.showMessageDialog(frame, "Customer added successfully!");
        }
    }

    private static void showCustomersList(JFrame frame) {
        List<customer> customers = operations.getAllCustomers();

        StringBuilder message = new StringBuilder("Customers List:\n\n");
        for (customer c : customers) {
            message.append(String.format("ID: %d, Name: %s, Email: %s, Phone: %s, Address: %s\n",
                    c.getId(), c.getName(), c.getEmail(), c.getPhone(), c.getAddress()));
        }

        JTextArea textArea = new JTextArea(message.toString());
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(500, 400));

        JOptionPane.showMessageDialog(frame, scrollPane, "Customers List", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void showAddOrderDialog(JFrame frame) {
        JTextField quantityField = new JTextField();
        JTextField statusField = new JTextField();
        JTextField totalAmountField = new JTextField();
        JTextField priceField = new JTextField();

        Object[] fields = {
            "Quantity:", quantityField,
            "Status:", statusField,
            "Total Amount:", totalAmountField,
            "Price:", priceField
        };

        int option = JOptionPane.showConfirmDialog(frame, fields, "Add Order", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                // Validate and parse the quantity
                String quantityText = quantityField.getText().trim();
                if (quantityText.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Quantity cannot be empty.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int quantity = Integer.parseInt(quantityText);
                if (quantity <= 0) {
                    JOptionPane.showMessageDialog(frame, "Quantity must be a positive number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validate and parse the totalAmount
                String totalAmountText = totalAmountField.getText().trim();
                if (totalAmountText.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Total Amount cannot be empty.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                double totalAmount = Double.parseDouble(totalAmountText);
                if (totalAmount <= 0) {
                    JOptionPane.showMessageDialog(frame, "Total Amount must be a positive number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validate and parse the price
                String priceText = priceField.getText().trim();
                if (priceText.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Price cannot be empty.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                double price = Double.parseDouble(priceText);
                if (price <= 0) {
                    JOptionPane.showMessageDialog(frame, "Price must be a positive number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validate status
                String status = statusField.getText().trim();
                if (status.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Status cannot be empty.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Create order and add it to the operations
                order o = new order(quantity, status, totalAmount, price);
                operations.addOrder(o);

                // Show success message
                JOptionPane.showMessageDialog(frame, "Order added successfully!");
            } catch (NumberFormatException ex) {
                // This will catch parsing errors for the numeric fields
                JOptionPane.showMessageDialog(frame, "Please enter valid numbers for Quantity, Total Amount, and Price.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static void showOrdersList(JFrame frame) {
        List<order> orders = operations.getAllOrder();

        StringBuilder message = new StringBuilder("Orders List:\n\n");
        for (order o : orders) {
            message.append(String.format("ID: %d, Quantity: %d, Status: %s, Total Amount: %.2f, Price: %.2f\n",
                    o.getId(), o.getQuantity(), o.getStatus(), o.getTotalAmount(), o.getPrice()));
        }

        JTextArea textArea = new JTextArea(message.toString());
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(500, 400));

        JOptionPane.showMessageDialog(frame, scrollPane, "Orders List", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void showAddProductDialog(JFrame frame) {
        JTextField nameField = new JTextField();
        JTextField descriptionField = new JTextField();
        JTextField priceField = new JTextField();
        JTextField quantityField = new JTextField();
        JTextField categoryField = new JTextField();

        Object[] fields = {
            "Name:", nameField,
            "Description:", descriptionField,
            "Price:", priceField,
            "Quantity:", quantityField,
            "Category:", categoryField
        };

        int option = JOptionPane.showConfirmDialog(frame, fields, "Add Product", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            // Get input values
            String name = nameField.getText().trim();
            String description = descriptionField.getText().trim();
            String category = categoryField.getText().trim();

            // Validate that fields are not empty
            if (name.isEmpty() || description.isEmpty() || category.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Name, Description, and Category cannot be empty.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                // Validate and parse the price
                double price = 0.0;
                String priceText = priceField.getText().trim();
                if (priceText.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Price cannot be empty.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    price = Double.parseDouble(priceText);
                    if (price <= 0) {
                        JOptionPane.showMessageDialog(frame, "Price must be a positive number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number for Price.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validate and parse the quantity
                int quantity = 0;
                String quantityText = quantityField.getText().trim();
                if (quantityText.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Quantity cannot be empty.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    quantity = Integer.parseInt(quantityText);
                    if (quantity <= 0) {
                        JOptionPane.showMessageDialog(frame, "Quantity must be a positive number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number for Quantity.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Create the product object and add it to operations
                product p = new product(name, description, price, quantity, category);
                operations.addProduct(p);

                // Show success message
                JOptionPane.showMessageDialog(frame, "Product added successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "An unexpected error occurred. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    private static void showProductsList(JFrame frame) {
        List<product> products = operations.getAllProduct();

        StringBuilder message = new StringBuilder("Products List:\n\n");
        for (product p : products) {
            message.append(String.format("ID: %d, Name: %s, Description: %s, Price: %.2f, Quantity: %d, Category: %s\n",
                    p.getId(), p.getName(), p.getDescription(), p.getPrice(), p.getQuantity(), p.getCategory()));
        }

        JTextArea textArea = new JTextArea(message.toString());
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(500, 400));

        JOptionPane.showMessageDialog(frame, scrollPane, "Products List", JOptionPane.INFORMATION_MESSAGE);
    }
}
