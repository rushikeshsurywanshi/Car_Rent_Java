import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReturnCar {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Return Car");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel, frame); // Pass frame to placeComponents

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel, JFrame frame) {
        panel.setLayout(null);

        JLabel customerIdLabel = new JLabel("Customer ID:");
        customerIdLabel.setBounds(10, 20, 100, 25);
        panel.add(customerIdLabel);

        JTextField customerIdText = new JTextField(20);
        customerIdText.setBounds(150, 20, 165, 25);
        panel.add(customerIdText);

        JButton returnButton = new JButton("Return Car");
        returnButton.setBounds(150, 60, 150, 25);
        panel.add(returnButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(150, 100, 150, 25);
        panel.add(backButton);

        // Return Car Action
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String customerId = customerIdText.getText();
                String rentedCar = BookCar.getRentedCarByCustomer(customerId);

                if (rentedCar != null) {
                    BookCar.removeRentedCar(customerId);
                    JOptionPane.showMessageDialog(null, "Car returned successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "No car found for the given Customer ID!", "Error", JOptionPane.ERROR_MESSAGE);
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
}
