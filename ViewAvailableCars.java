import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.HashMap;

public class ViewAvailableCars {
    private static HashMap<String, String> carAvailability = new HashMap<>();
    private static DefaultTableModel model;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Available Cars");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        frame.add(panel);

        String[] columnNames = {"Car ID", "Model", "Price per Day", "Availability"};
        Object[][] data = {
                {"1", "Toyota Camry", "$50", "Available"},
                {"2", "Honda Accord", "$45", "Available"},
                {"3", "BMW X5", "$100", "Available"},
                {"4", "Audi A6", "$120", "Available"},
                {"5", "Mercedes C-Class", "$110", "Available"},
                {"6", "Ford Mustang", "$90", "Available"},
                {"7", "Chevrolet Camaro", "$95", "Available"},
                {"8", "Tesla Model S", "$150", "Available"},
                {"9", "Nissan Altima", "$60", "Available"},
                {"10", "Hyundai Elantra", "$55", "Available"}
        };

        model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        // Initialize car availability
        for (Object[] row : data) {
            carAvailability.put((String) row[0], (String) row[3]);
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

    public static void updateCarAvailability(String carId, String status) {
        carAvailability.put(carId, status);

        // Update the table model to reflect the change in availability
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 0).equals(carId)) {
                model.setValueAt(status, i, 3); // Update the "Availability" column
                break;
            }
        }
    }

    public static String getCarModel(String carId) {
        switch (carId) {
            case "1":
                return "Toyota Camry";
            case "2":
                return "Honda Accord";
            case "3":
                return "BMW X5";
            case "4":
                return "Audi A6";
            case "5":
                return "Mercedes C-Class";
            case "6":
                return "Ford Mustang";
            case "7":
                return "Chevrolet Camaro";
            case "8":
                return "Tesla Model S";
            case "9":
                return "Nissan Altima";
            case "10":
                return "Hyundai Elantra";
            default:
                return "Unknown Model";
        }
    }
}
