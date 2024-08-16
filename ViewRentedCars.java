import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.HashMap;

public class ViewRentedCars {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Rented Cars");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        frame.add(panel);

        String[] columnNames = {"Customer ID", "Customer Name", "Car ID", "Car Model"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        // Populate rented cars
        HashMap<String, String> rentedCars = BookCar.getRentedCars();
        for (String customerId : rentedCars.keySet()) {
            String carId = rentedCars.get(customerId);
            String customerName = ManageCustomers.getCustomer(customerId).getName();
            String carModel = ViewAvailableCars.getCarModel(carId);
            model.addRow(new Object[]{customerId, customerName, carId, carModel});
        }

        panel.add(scrollPane, BorderLayout.CENTER);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            frame.dispose(); // Close the current window
            CarRentalSystem.main(new String[]{}); // Open the main menu
        });
        panel.add(backButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
