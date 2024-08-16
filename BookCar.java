import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class BookCar {
    private static HashMap<String, String> rentedCars = new HashMap<>();
    private static JFrame frame; // Declare the frame as a class-level variable

    public static void main(String[] args) {
        frame = new JFrame("Book Car");
        frame.setSize(400, 300);
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

        JLabel carIdLabel = new JLabel("Car ID:");
        carIdLabel.setBounds(10, 50, 80, 25);
        panel.add(carIdLabel);

        JTextField carIdText = new JTextField(20);
        carIdText.setBounds(150, 50, 165, 25);
        panel.add(carIdText);

        JLabel daysLabel = new JLabel("Days:");
        daysLabel.setBounds(10, 80, 80, 25);
        panel.add(daysLabel);

        JTextField daysText = new JTextField(20);
        daysText.setBounds(150, 80, 165, 25);
        panel.add(daysText);

        JButton bookButton = new JButton("Book Car");
        bookButton.setBounds(150, 120, 150, 25);
        panel.add(bookButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(150, 160, 150, 25);
        panel.add(backButton);

        // Book Button Action
        bookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String customerId = customerIdText.getText();
                String carId = carIdText.getText();
                String daysString = daysText.getText();

                int days;
                try {
                    days = Integer.parseInt(daysString);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number of days", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validate Customer ID and Car ID
                if (ManageCustomers.getCustomer(customerId) != null 
                    && ViewAvailableCars.getCarModel(carId) != "Unknown Model" 
                    && days > 0) {
                    
                    // Add to rented cars
                    addRentedCar(customerId, carId);

                    // Calculate bill
                    int totalBill = calculateBill(carId, days);

                    JOptionPane.showMessageDialog(null, "Car booked successfully! Total Bill: $" + totalBill);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Customer ID or Car ID", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Back Button Action
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the current window
                CarRentalSystem.main(new String[]{}); // Return to the main menu
            }
        });
    }

    public static String getRentedCarByCustomer(String customerId) {
        return rentedCars.get(customerId);
    }

    public static HashMap<String, String> getRentedCars() {
        return rentedCars;
    }

    public static void addRentedCar(String customerId, String carId) {
        rentedCars.put(customerId, carId);
        ViewAvailableCars.updateCarAvailability(carId, "Rented");
    }

    public static void removeRentedCar(String customerId) {
        String carId = rentedCars.remove(customerId);
        if (carId != null) {
            ViewAvailableCars.updateCarAvailability(carId, "Available");
        }
    }

    public static int calculateBill(String carId, int days) {
        switch (carId) {
            case "1":
                return days * 50;
            case "2":
                return days * 45;
            case "3":
                return days * 100;
            case "4":
                return days * 120;
            case "5":
                return days * 110;
            case "6":
                return days * 90;
            case "7":
                return days * 95;
            case "8":
                return days * 150;
            case "9":
                return days * 60;
            case "10":
                return days * 55;
            default:
                return 0;
        }
    }
}
