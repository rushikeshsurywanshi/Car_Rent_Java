import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class ManageCustomers {
    private static HashMap<String, Customer> customers = new HashMap<>();
    private static JFrame frame; // Declare the frame as a class-level variable

    public static void main(String[] args) {
        frame = new JFrame("Manage Customers"); // Initialize the frame here
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel customerIdLabel = new JLabel("Customer ID:");
        customerIdLabel.setBounds(10, 20, 80, 25);
        panel.add(customerIdLabel);

        JTextField customerIdText = new JTextField(20);
        customerIdText.setBounds(150, 20, 165, 25);
        panel.add(customerIdText);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 50, 80, 25);
        panel.add(nameLabel);

        JTextField nameText = new JTextField(20);
        nameText.setBounds(150, 50, 165, 25);
        panel.add(nameText);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(10, 80, 80, 25);
        panel.add(phoneLabel);

        JTextField phoneText = new JTextField(20);
        phoneText.setBounds(150, 80, 165, 25);
        panel.add(phoneText);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(10, 110, 80, 25);
        panel.add(addressLabel);

        JTextField addressText = new JTextField(20);
        addressText.setBounds(150, 110, 165, 25);
        panel.add(addressText);

        JButton addButton = new JButton("Add Customer");
        addButton.setBounds(10, 150, 150, 25);
        panel.add(addButton);

        JButton viewButton = new JButton("View Customers");
        viewButton.setBounds(170, 150, 150, 25);
        panel.add(viewButton);

        JButton deleteButton = new JButton("Delete Customer");
        deleteButton.setBounds(330, 150, 150, 25);
        panel.add(deleteButton);

        JButton updateButton = new JButton("Update Customer");
        updateButton.setBounds(10, 180, 150, 25);
        panel.add(updateButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(170, 180, 150, 25);
        panel.add(backButton);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the current window
                CarRentalSystem.main(new String[]{}); // Go back to the main menu
            }
        });

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String customerId = customerIdText.getText();
                String name = nameText.getText();
                String phone = phoneText.getText();
                String address = addressText.getText();

                if (!customers.containsKey(customerId)) {
                    customers.put(customerId, new Customer(customerId, name, phone, address));
                    JOptionPane.showMessageDialog(null, "Customer added successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "Customer ID already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder customerList = new StringBuilder();
                for (Customer customer : customers.values()) {
                    customerList.append("ID: ").append(customer.getCustomerId())
                            .append(", Name: ").append(customer.getName())
                            .append(", Phone: ").append(customer.getPhone())
                            .append(", Address: ").append(customer.getAddress()).append("\n");
                }
                JOptionPane.showMessageDialog(null, customerList.length() > 0 ? customerList.toString() : "No customers found.");
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String customerId = customerIdText.getText();
                if (customers.containsKey(customerId)) {
                    customers.remove(customerId);
                    JOptionPane.showMessageDialog(null, "Customer deleted successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "Customer ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String customerId = customerIdText.getText();
                String name = nameText.getText();
                String phone = phoneText.getText();
                String address = addressText.getText();

                if (customers.containsKey(customerId)) {
                    Customer customer = customers.get(customerId);
                    customer.setName(name);
                    customer.setPhone(phone);
                    customer.setAddress(address);
                    JOptionPane.showMessageDialog(null, "Customer updated successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "Customer ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static Customer getCustomer(String customerId) {
        return customers.get(customerId);
    }
}

class Customer {
    private String customerId;
    private String name;
    private String phone;
    private String address;

    public Customer(String customerId, String name, String phone, String address) {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
