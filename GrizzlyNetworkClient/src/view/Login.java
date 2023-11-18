
package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;



public class Login extends javax.swing.JFrame {
    
    private static final long serialVersionUID = 1L;
    
	private javax.swing.JButton jButtonLogin;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JLabel jLabelDashBoard;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelTittle;
    private javax.swing.JLabel jLabelUsername;
    private javax.swing.JPanel jPanelAction;
    private javax.swing.JPanel jPanelSideView;
    private javax.swing.JPanel jPanelTitle;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTextFieldUsername;
    
    // JDBC database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/grizzlydb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    
    public Login() {
        initComponents();
    }
                         
    private void initComponents() {

    	setTitle("The Home of Entertainment");
        jPanelSideView = new javax.swing.JPanel();
        jPanelTitle = new javax.swing.JPanel();
        jLabelTittle = new javax.swing.JLabel();
        jPanelAction = new javax.swing.JPanel();
        jLabelUsername = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jPasswordField = new javax.swing.JPasswordField();
        jTextFieldUsername = new javax.swing.JTextField();
        jButtonLogin = new javax.swing.JButton();
        jButtonReset = new javax.swing.JButton();
        jLabelDashBoard = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelSideView.setBackground(new java.awt.Color(56, 106, 179));

        jPanelTitle.setBackground(new java.awt.Color(30, 139, 195));

        jLabelTittle.setFont(new java.awt.Font("Trattatello", 0, 28)); // NOI18N
        jLabelTittle.setText("Grizzly's Entertainment");

        javax.swing.GroupLayout jPanelTitleLayout = new javax.swing.GroupLayout(jPanelTitle);
        jPanelTitle.setLayout(jPanelTitleLayout);
        jPanelTitleLayout.setHorizontalGroup(
            jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTitleLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabelTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanelTitleLayout.setVerticalGroup(
            jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTitleLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabelTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelSideViewLayout = new javax.swing.GroupLayout(jPanelSideView);
        jPanelSideView.setLayout(jPanelSideViewLayout);
        jPanelSideViewLayout.setHorizontalGroup(
            jPanelSideViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelSideViewLayout.setVerticalGroup(
            jPanelSideViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSideViewLayout.createSequentialGroup()
                .addComponent(jPanelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanelAction.setBackground(new java.awt.Color(204, 204, 204));

        jLabelUsername.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabelUsername.setText("Username:");

        jLabelPassword.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabelPassword.setText("Password:");

        jButtonLogin.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jButtonLogin.setText("Login");
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login();
            }
        });

        jButtonReset.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jButtonReset.setText("Reset");
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jPasswordField.setText("");
                jTextFieldUsername.setText("");
            }
        });

        jLabelDashBoard.setFont(new java.awt.Font("Verdana", 0, 28)); // NOI18N
        jLabelDashBoard.setText("Dashboard Login");

        javax.swing.GroupLayout jPanelActionLayout = new javax.swing.GroupLayout(jPanelAction);
        jPanelAction.setLayout(jPanelActionLayout);
        jPanelActionLayout.setHorizontalGroup(
            jPanelActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelActionLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanelActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelActionLayout.createSequentialGroup()
                        .addGroup(jPanelActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                            .addComponent(jPasswordField)))
                    .addGroup(jPanelActionLayout.createSequentialGroup()
                        .addComponent(jButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonReset, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelActionLayout.createSequentialGroup()
                .addContainerGap(207, Short.MAX_VALUE)
                .addComponent(jLabelDashBoard)
                .addGap(159, 159, 159))
        );
        jPanelActionLayout.setVerticalGroup(
            jPanelActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelActionLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabelDashBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126)
                .addGroup(jPanelActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanelActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(115, 115, 115)
                .addGroup(jPanelActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(200, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelSideView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelAction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelSideView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelAction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        this.setLocationRelativeTo(null);
    } 
    
    private void login() {
        String enteredUsername = jTextFieldUsername.getText();
        String enteredPassword = new String(jPasswordField.getPassword());

        // Database connection variables
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Prepare the SQL statement to retrieve user information
            String query = "SELECT * FROM user WHERE username = ? AND password = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, enteredUsername);
            preparedStatement.setString(2, enteredPassword);

            // Execute the query
            resultSet = preparedStatement.executeQuery();

            // Check if any results were returned
            if (resultSet.next()) {
                String userId = resultSet.getString("userId");
                String role = resultSet.getString("role");

                JOptionPane.showMessageDialog(this, "Login successful! Welcome, " + role + "!");

                // Check the role and execute a corresponding query to get additional information
                if ("Customer".equalsIgnoreCase(role)) {
                    openCustomerDashboard(userId);
                } else if ("Employee".equalsIgnoreCase(role)) {
                    openEmployeeDashboard(userId);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password. Please try again.", "Login Failed",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the database resources
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void openEmployeeDashboard(String userId) {
        // Retrieve employee information based on the userId
        // Execute a query on the "employee" table using the provided userId
        // Open the employee dashboard with the retrieved employee information
        Connection connection = null;
        PreparedStatement employeeStatement = null;
        ResultSet employeeResult = null;

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Example query: "SELECT * FROM employee WHERE userId = ?"
            String employeeQuery = "SELECT * FROM employee WHERE employeeId = ?";
            employeeStatement = connection.prepareStatement(employeeQuery);
            employeeStatement.setString(1, userId);

            employeeResult = employeeStatement.executeQuery();

            // Check if any results were returned
            if (employeeResult.next()) {
                // Fetch employee information and open the dashboard
                String employeeFirstName = employeeResult.getString("firstName");
                String employeeLastName = employeeResult.getString("lastName");

                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new EmployeeDashboard().setVisible(true);
                    }
                });
            } else {
                JOptionPane.showMessageDialog(this, "Error retrieving employee information.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the database resources for employee information
            try {
                if (employeeResult != null) employeeResult.close();
                if (employeeStatement != null) employeeStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void openCustomerDashboard(String userId) {
        // Retrieve customer information based on the userId
        // Execute a query on the "customer" table using the provided userId
        // Open the customer dashboard with the retrieved customer information
        Connection connection = null;
        PreparedStatement customerStatement = null;
        ResultSet customerResult = null;

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Example query: "SELECT * FROM customer WHERE userId = ?"
            String customerQuery = "SELECT * FROM customer WHERE customerId = ?";
            customerStatement = connection.prepareStatement(customerQuery);
            customerStatement.setString(1, userId);

            customerResult = customerStatement.executeQuery();

            // Check if any results were returned
            if (customerResult.next()) {
                // Fetch customer information and open the dashboard
                String customerFirstName = customerResult.getString("firstName");
                String customerLastName = customerResult.getString("lastName");
                Float accountBalance = customerResult.getFloat("accountBalance");
                String accountNumber = customerResult.getString("accountNumber");

                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new CustomerDashboard(customerFirstName, customerLastName, accountBalance, accountNumber).setVisible(true);
                    }
                });
            } else {
                JOptionPane.showMessageDialog(this, "Error retrieving customer information.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the database resources for customer information
            try {
                if (customerResult != null) customerResult.close();
                if (customerStatement != null) customerStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Method to update equipment availability
    private void updateEquipmentAvailability() {
        Connection connection = null;
        PreparedStatement updateStatusStatement = null;

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Update equipment status based on eventDate
            String updateEventDateQuery = "UPDATE equipment e " +
                    "JOIN scheduledEquipment se ON e.equipmentId = se.equipmentId " +
                    "SET e.status = 'Not Available' " +
                    "WHERE se.eventDate <= CURDATE()";

            updateStatusStatement = connection.prepareStatement(updateEventDateQuery);
            updateStatusStatement.executeUpdate();

            // Update equipment status based on returnDate
            String updateReturnDateQuery = "UPDATE equipment e " +
                    "JOIN scheduledEquipment se ON e.equipmentId = se.equipmentId " +
                    "SET e.status = 'Available' " +
                    "WHERE se.returnDate < CURDATE()";

            updateStatusStatement = connection.prepareStatement(updateReturnDateQuery);
            updateStatusStatement.executeUpdate();

            JOptionPane.showMessageDialog(this, "Equipment availability updated successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error updating equipment availability.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            // Close the database resources
            try {
                if (updateStatusStatement != null) updateStatusStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }   
                                         
    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }                 
}
