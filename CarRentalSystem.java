import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarRentalSystem {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Car Rental System");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JButton manageCustomersButton = new JButton("Manage Customers");
        manageCustomersButton.setBounds(100, 50, 200, 25);
        panel.add(manageCustomersButton);

        manageCustomersButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ManageCustomers.main(new String[]{}); // Open Manage Customers window
            }
        });

        JButton viewAvailableCarsButton = new JButton("View Available Cars");
        viewAvailableCarsButton.setBounds(100, 90, 200, 25);
        panel.add(viewAvailableCarsButton);

        viewAvailableCarsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewAvailableCars.main(new String[]{}); // Open View Available Cars window
            }
        });

        JButton bookCarButton = new JButton("Book Car");
        bookCarButton.setBounds(100, 130, 200, 25);
        panel.add(bookCarButton);

        bookCarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BookCar.main(new String[]{}); // Open Book Car window
            }
        });

        JButton returnCarButton = new JButton("Return Car");
        returnCarButton.setBounds(100, 170, 200, 25);
        panel.add(returnCarButton);

        returnCarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ReturnCar.main(new String[]{}); // Open Return Car window
            }
        });

        JButton viewRentedCarsButton = new JButton("View Rented Cars");
        viewRentedCarsButton.setBounds(100, 210, 200, 25);
        panel.add(viewRentedCarsButton);

        viewRentedCarsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewRentedCars.main(new String[]{}); // Open View Rented Cars window
            }
        });
    }
}
