package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import java.util.ArrayList;
import java.util.List;


import domain.Equipment;
import domain.Message;
import domain.Transaction;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomerDashboard extends JFrame {
	
	 private static final Logger logger = LogManager.getLogger(CustomerDashboard.class);
	
	private Connection dbConn;
	
	private Statement stmt;
	private ResultSet result = null;

    private JLabel jLabelCustomerWelcome;
    private JLabel jLabelAvailableEquipment;
    private JLabel jLabelCustomerInfo;
    private JPanel actionPanel;
    private JScrollPane jScrollPane2;
    private JTable jTableEquipment;
    private JComboBox<String> categoryComboBox;
    
    private JButton btnViewPastTransactions;
    private JButton btnViewSingleTransaction; 
    
    private JTextArea messageTextArea;
    private JTextField newMessageTextField;
    private JButton sendMessageButton;

    private String receiverEmployeeId;  

    
    private JDateChooser dateChooserRental;
    private JDateChooser dateChooserReturn;
    private JButton btnBookEquipment;

    private String customerFirstName;
    private String customerLastName;
    private String accountNumber;
    private float accountBalance;
    private String customerId;

    public CustomerDashboard(String customerFirstName, String customerLastName, float accountBalance, String accountNumber) {
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.accountBalance = accountBalance;
        this.accountNumber = accountNumber;
        initComponents();
        // Set customerId using a method or fetch it from the database during login
        this.customerId = getCustomerIdFromDatabase(customerFirstName, customerLastName);
    }

    private void initComponents() {
    	try {
            logger.info("Initializing CustomerDashboard...");
	        jLabelCustomerWelcome = new JLabel();
	        jLabelAvailableEquipment = new JLabel();
	        jLabelCustomerInfo = new JLabel();
	        actionPanel = new JPanel();
	        jScrollPane2 = new JScrollPane();
	        jTableEquipment = new JTable();
	        categoryComboBox = new JComboBox<>();
	
	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	        setTitle("Customer Dashboard");
	
	        jLabelCustomerWelcome.setFont(new Font("Verdana", Font.BOLD, 18));
	        jLabelCustomerWelcome.setText("Welcome, " + customerFirstName + "  " + customerLastName + "!");
	
	        jLabelAvailableEquipment.setFont(new Font("Verdana", Font.BOLD, 18));
	        jLabelAvailableEquipment.setText("Available Equipment");
	
	        jLabelCustomerInfo.setFont(new Font("Verdana", Font.PLAIN, 14));
	        jLabelCustomerInfo.setText("Account Number: " + accountNumber);
	
	        JLabel jLabelHeading = new JLabel("GRIZZLY ENTERTAINMENT EQUIPMENT RENTAL", SwingConstants.CENTER);
	        jLabelHeading.setFont(new Font("Verdana", Font.BOLD, 20));
	
	        JPanel topPanel = new JPanel(new BorderLayout());
	        topPanel.add(jLabelHeading, BorderLayout.NORTH);
	        topPanel.add(jLabelCustomerWelcome, BorderLayout.CENTER); 
	        topPanel.add(jLabelCustomerInfo, BorderLayout.SOUTH);
	        categoryComboBox.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                updateEquipmentTable();
	            }
	        });
	
	        actionPanel.setLayout(new BorderLayout());
	        actionPanel.setPreferredSize(new Dimension(800, 600));
	
	        jTableEquipment.setModel(new DefaultTableModel(
	                new Object[][]{
	                        {null, null, null, null},
	                },
	                new String[]{
	                        "Equipment ID", "Equipment Name", "Category", "Unit Cost",
	                }
	        ));
	
	        jScrollPane2.setViewportView(jTableEquipment);
	
	        actionPanel.add(topPanel, BorderLayout.NORTH);
	        actionPanel.add(categoryComboBox, BorderLayout.CENTER);
	        actionPanel.add(jScrollPane2, BorderLayout.SOUTH);
	
	
	        categoryComboBox.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                updateEquipmentTable();
	            }
	        });
	
	        actionPanel.setLayout(new BorderLayout());
	        actionPanel.setPreferredSize(new Dimension(800, 600));
	
	        jTableEquipment.setModel(new DefaultTableModel(
	                new Object[][]{
	                        {null, null, null, null},
	                },
	                new String[]{
	                        "Equipment ID", "Equipment Name", "Category", "Unit Cost",
	                }
	        ));
	
	        jScrollPane2.setViewportView(jTableEquipment);
	
	        actionPanel.add(topPanel, BorderLayout.NORTH);
	        actionPanel.add(jScrollPane2, BorderLayout.CENTER);
	        actionPanel.add(categoryComboBox, BorderLayout.SOUTH);
	
	        dateChooserRental = new JDateChooser();
	        dateChooserReturn = new JDateChooser();
	        btnBookEquipment = new JButton("Book Equipment");
	        btnBookEquipment.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                bookEquipment();
	            }
	        });
	
	        btnViewPastTransactions = new JButton("View Past Transactions");
	        btnViewPastTransactions.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                viewPastTransactions();
	            }
	        });
	
	        btnViewSingleTransaction = new JButton("View Single Transaction");
	        btnViewSingleTransaction.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                viewSingleTransaction();
	            }
	        });
	        
	     // Initialize the message components
	        messageTextArea = new JTextArea();
	        newMessageTextField = new JTextField();
	        sendMessageButton = new JButton("Send Message");
	
	        // Add ActionListener to the Send Message button
	        sendMessageButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                sendMessage();
	            }
	        });
	
	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.CENTER)
	                .addGroup(layout.createSequentialGroup()
	                    .addContainerGap()
	                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                        .addComponent(actionPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                        .addComponent(categoryComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                        .addGroup(layout.createSequentialGroup()
	                            .addComponent(dateChooserRental, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                            .addComponent(dateChooserReturn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                        .addGroup(layout.createSequentialGroup()
	                            .addComponent(btnBookEquipment)
	                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	                            .addComponent(btnViewPastTransactions)
	                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	                            .addComponent(btnViewSingleTransaction))
	                        .addGroup(layout.createSequentialGroup()
	                            .addComponent(messageTextArea, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
	                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                                .addComponent(newMessageTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                                .addComponent(sendMessageButton)
	                            )
	                        )
	                    )
	                    .addContainerGap()
	                )
	        );
	
	        layout.setVerticalGroup(
	            layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(actionPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(categoryComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(dateChooserRental, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(dateChooserReturn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(btnBookEquipment)
	                    .addComponent(btnViewPastTransactions)
	                    .addComponent(btnViewSingleTransaction))
	                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(messageTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(newMessageTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(sendMessageButton)
	                    )
	                )
	                .addContainerGap()
	        );
	
	        pack();
	        setLocationRelativeTo(null);
	
	        // Populate the categoryComboBox
	        populateCategoryComboBox();
	
	        logger.info("CustomerDashboard components initialized.");
	
	        // Set customerId using a method or fetch it from the database during login
	        this.customerId = getCustomerIdFromDatabase(customerFirstName, customerLastName);
	        if (customerId == null) {
	            // Log an error if customer ID is not retrieved
	            logger.error("Failed to retrieve customer ID from the database.");
	            return;
	        }
	
	        // Log information about successful customer ID retrieval
	        logger.info("Customer ID retrieved successfully: " + customerId);
	
	        // Update the equipment table initially
	        updateEquipmentTable();
	
	        // Initialize the receiverEmployeeId by fetching a random employee ID from the database
	        receiverEmployeeId = getRandomEmployeeId();
	
	        // Display previous message history in the message area
	        displayPreviousMessages();
	
	        // Log information about successful setup
	        logger.info("Setup of CustomerDashboard completed.");
	    } catch (Exception e) {
	        // Log an error if an exception occurs during initialization
	        logger.error("Error initializing CustomerDashboard.", e);
	    }
}

    private String getRandomEmployeeId() {
        String query = "SELECT userId FROM user WHERE role = 'Employee' ORDER BY RAND() LIMIT 1";

        try (Connection dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/grizzlydb", "root", "");
             PreparedStatement pstmt = dbConn.prepareStatement(query)) {

            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("userId");
            } else {
                // Handle the case where no employee is found
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void displayPreviousMessages() {
        // Fetch and display previous messages from the database
        List<Message> previousMessages = getPreviousMessages();

        if (!previousMessages.isEmpty()) {
            // Display previous messages in the message area
            for (Message message : previousMessages) {
                String senderDisplayName = (message.getSenderId().equals(customerId)) ? "You" : "Employee";
                messageTextArea.append(senderDisplayName + ": " + message.getMessageContent() + "\n");
            }
        }
    }

    private List<Message> getPreviousMessages() {
        List<Message> previousMessages = new ArrayList<>();

        // Fetch previous messages from the database
        String query = "SELECT * FROM message WHERE (senderId = ? AND receiverId = ?) OR (senderId = ? AND receiverId = ?) ORDER BY timestamp";

        try (Connection dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/grizzlydb", "root", "");
             PreparedStatement pstmt = dbConn.prepareStatement(query)) {

            pstmt.setString(1, customerId);
            pstmt.setString(2, receiverEmployeeId);
            pstmt.setString(3, receiverEmployeeId);
            pstmt.setString(4, customerId);

            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                String messageId = resultSet.getString("messageId");
                String senderId = resultSet.getString("senderId");
                String receiverId = resultSet.getString("receiverId");
                String messageContent = resultSet.getString("messageContent");
                Timestamp timestamp = resultSet.getTimestamp("timestamp");

                Message message = new Message(messageId, senderId, receiverId, messageContent, timestamp);
                previousMessages.add(message);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception
        }

        return previousMessages;
    }
    
    private void sendMessage() {
        try {
            // Get the message content from the text field
            String messageContent = newMessageTextField.getText().trim();

            // Check if the message is not empty
            if (!messageContent.isEmpty()) {
                // Create a Message object
                Message message = new Message();
                message.setMessageId(generateMessageId());  
                message.setSenderId(customerId);
                receiverEmployeeId = getRandomEmployeeId();
                message.setReceiverId(receiverEmployeeId);
                message.setMessageContent(messageContent);
                message.setTimestamp(new Timestamp(System.currentTimeMillis()));

                // Call a method to save the message to the database
                saveMessageToDatabase(message);

                // Display the message in the text area
                messageTextArea.append("You: " + messageContent + "\n");

                // Clear the text field after sending the message
                newMessageTextField.setText("");

                // Log information about successful message sending
                logger.info("Message sent successfully.");
            }
        } catch (Exception e) {
            // Log an error if an exception occurs
            logger.error("Error while sending a message", e);
        }
    }
    
    private void saveMessageToDatabase(Message message) {
        String query = "INSERT INTO message (messageId, senderId, receiverId, messageContent, timestamp) VALUES (?, ?, ?, ?, ?)";

        try (Connection dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/grizzlydb", "root", "");
             PreparedStatement pstmt = dbConn.prepareStatement(query)) {

            pstmt.setString(1, message.getMessageId());
            pstmt.setString(2, message.getSenderId());
            pstmt.setString(3, message.getReceiverId());
            pstmt.setString(4, message.getMessageContent());
            pstmt.setTimestamp(5, message.getTimestamp());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception
        }
    }

    // Implement the generateMessageId method to generate a unique message ID
    private String generateMessageId() {
        // Use a suitable method to generate a unique ID (e.g., UUID)
        String fullUuid = java.util.UUID.randomUUID().toString();
        return fullUuid.substring(0, 20);
    }
    
    private void viewSingleTransaction() {
        String transactionId = null;

        while (transactionId == null || transactionId.isEmpty()) {
            // Prompt the user to enter the transaction ID
            transactionId = JOptionPane.showInputDialog(this, "Enter Transaction ID:");

            if (transactionId == null) {
                // User canceled the input dialog
                return;
            } else if (transactionId.isEmpty()) {
                // User pressed "OK" without entering a transaction ID, show the warning
                JOptionPane.showMessageDialog(this, "Please enter a Transaction ID.", "Transaction ID Required", JOptionPane.WARNING_MESSAGE);
            }
        }

        // Fetch and display details of the single past transaction
        Transaction singleTransaction = getSingleTransaction(transactionId);

        if (singleTransaction != null) {
            // Display details of the single transaction
            showSingleTransactionDialog(singleTransaction);
        } else {
            JOptionPane.showMessageDialog(this, "Transaction not found.", "Transaction Not Found", JOptionPane.ERROR_MESSAGE);
        }
    }


    private Transaction getSingleTransaction(String transactionId) {
        // Fetch details of the single transaction from the database
        String query = "SELECT t.transactionId, t.customerId, t.equipmentId, t.rentalDate, t.returnDate, e.type, t.totalCost " +
                "FROM transaction t " +
                "JOIN equipment e ON t.equipmentId = e.equipmentId " +
                "WHERE t.transactionId = ?";

        try (Connection dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/grizzlydb", "root", "");
             PreparedStatement pstmt = dbConn.prepareStatement(query)) {

            pstmt.setString(1, transactionId);

            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                // Retrieve transaction details
                String customerId = resultSet.getString("customerId");
                String equipmentId = resultSet.getString("equipmentId");
                Date rentalDate = resultSet.getDate("rentalDate");
                Date returnDate = resultSet.getDate("returnDate");
                String equipmentType = resultSet.getString("type");
                float totalCost = resultSet.getFloat("totalCost");

                // Create a Transaction object
                return new Transaction(transactionId, customerId, equipmentId, rentalDate, returnDate, totalCost);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception
        }

        return null;
    }

    private void showSingleTransactionDialog(Transaction transaction) {
        // Display details of the single transaction in a dialog
        StringBuilder transactionDetails = new StringBuilder("Single Transaction Details:\n\n");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        transactionDetails.append("Transaction ID: ").append(transaction.getTransactionId()).append("\n");
        transactionDetails.append("Customer ID: ").append(transaction.getCustomerId()).append("\n");
        transactionDetails.append("Equipment ID: ").append(transaction.getEquipmentId()).append("\n");
        transactionDetails.append("Rental Date: ").append(dateFormat.format(transaction.getRentalDate())).append("\n");
        transactionDetails.append("Return Date: ").append(dateFormat.format(transaction.getReturnDate())).append("\n");
        transactionDetails.append("Equipment Type: ").append(getEquipmentType(transaction.getEquipmentId())).append("\n");
        transactionDetails.append("Total Cost: $").append(transaction.getTotalCost()).append("\n");

        JOptionPane.showMessageDialog(this, transactionDetails.toString(), "Single Transaction Details", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void viewPastTransactions() {
        // Fetch and display past transactions
        List<Transaction> transactions = getPastTransactions();

        if (transactions.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No past transactions found.", "No Transactions", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Display past transactions in a dialog or another component
            showPastTransactionsDialog(transactions);
        }
    }

    private List<Transaction> getPastTransactions() {
        List<Transaction> transactions = new ArrayList<>();

        // Fetch past transactions from the database based on the customer's customerId
        String query = "SELECT t.transactionId, t.customerId, t.equipmentId, t.rentalDate, t.returnDate, e.type, t.totalCost " +
                "FROM transaction t " +
                "JOIN equipment e ON t.equipmentId = e.equipmentId " +
                "WHERE t.customerId = ?";

        try (Connection dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/grizzlydb", "root", "");
             PreparedStatement pstmt = dbConn.prepareStatement(query)) {

            pstmt.setString(1, customerId);

            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                // Retrieve transaction details
                String transactionId = resultSet.getString("transactionId");
                String customerId = resultSet.getString("customerId");
                String equipmentId = resultSet.getString("equipmentId");
                Date rentalDate = resultSet.getDate("rentalDate");
                Date returnDate = resultSet.getDate("returnDate");
                String equipmentType = resultSet.getString("type");
                float totalCost = resultSet.getFloat("totalCost");

                // Create a Transaction object and add it to the list
                transactions.add(new Transaction(transactionId, customerId, equipmentId, rentalDate, returnDate, totalCost));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception
        }

        return transactions;
    }

    private void showPastTransactionsDialog(List<Transaction> transactions) {
        // Create a dialog or another component to display past transactions
        StringBuilder transactionDetails = new StringBuilder("Past Transactions:\n\n");

        float totalCostAllTransactions = 0.0f;

        for (Transaction transaction : transactions) {
        	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        	transactionDetails.append("Rental Date: ").append(dateFormat.format(transaction.getRentalDate())).append("\n");
        	transactionDetails.append("Return Date: ").append(dateFormat.format(transaction.getReturnDate())).append("\n");

            String equipmentType = getEquipmentType(transaction.getEquipmentId());
            transactionDetails.append("Equipment Type: ").append(equipmentType).append("\n");

            transactionDetails.append("Total Cost: $").append(transaction.getTotalCost()).append("\n\n");

            totalCostAllTransactions += transaction.getTotalCost();
        }

        transactionDetails.append("Total Cost of All Transactions: $").append(totalCostAllTransactions);

        JOptionPane.showMessageDialog(this, transactionDetails.toString(), "Past Transactions", JOptionPane.INFORMATION_MESSAGE);
    }

    private String getEquipmentType(String equipmentId) {
        String query = "SELECT type FROM equipment WHERE equipmentId = ?";

        try (Connection dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/grizzlydb", "root", "");
             PreparedStatement pstmt = dbConn.prepareStatement(query)) {

            pstmt.setString(1, equipmentId);

            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("type");
            } else {
                // Handle the case where equipment type is not found
                return "Unknown Equipment Type";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception
            return "Error Retrieving Equipment Type";
        }
    }


    
    private void bookEquipment() {
        // Check if a row is selected
        int selectedRow = jTableEquipment.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select an equipment to book.", "Selection Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String selectedCategory = (String) categoryComboBox.getSelectedItem();
        String equipmentId = (String) jTableEquipment.getValueAt(selectedRow, 0);

        // Get selected dates
        Date rentalDate = dateChooserRental.getDate();
        Date returnDate = dateChooserReturn.getDate();

        // Check if the dates are not null
        if (rentalDate == null || returnDate == null) {
            JOptionPane.showMessageDialog(this, "Please select both rental and return dates.", "Date Selection Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Check if the equipment is available for the selected period
        if (isEquipmentAvailable(equipmentId, rentalDate, returnDate)) {
            // Calculate the number of days
            long diffInMillies = Math.abs(returnDate.getTime() - rentalDate.getTime());
            int numOfDays = (int) TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

            // Calculate the total cost
            float costPerDay = getCostPerDay(equipmentId);
            float totalCost = costPerDay * numOfDays;

            // Update the database
            updateDatabase(equipmentId, rentalDate, returnDate, totalCost);

            // Display success message
            JOptionPane.showMessageDialog(this, "Equipment booked successfully!\nTotal Cost: $" + totalCost, "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Display failure message
            JOptionPane.showMessageDialog(this, "Equipment not available for the selected period.", "Booking Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean isEquipmentAvailable(String equipmentId, Date rentalDate, Date returnDate) {
        try (Connection dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/grizzlydb", "root", "");
             PreparedStatement pstmt = dbConn.prepareStatement("SELECT * FROM scheduledEquipment WHERE equipmentId = ? AND ((eventDate >= ? AND eventDate <= ?) OR (eventDate <= ? AND returnDate >= ?))")) {

            pstmt.setString(1, equipmentId);
            pstmt.setDate(2, new java.sql.Date(rentalDate.getTime()));
            pstmt.setDate(3, new java.sql.Date(returnDate.getTime()));
            pstmt.setDate(4, new java.sql.Date(rentalDate.getTime()));
            pstmt.setDate(5, new java.sql.Date(returnDate.getTime()));

            ResultSet resultSet = pstmt.executeQuery();

            // If the resultSet has any rows, it means the equipment is not available
            return !resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Assume not available in case of an error
        }
    }


    private float getCostPerDay(String equipmentId) {
        try (Connection dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/grizzlydb", "root", "");
             PreparedStatement pstmt = dbConn.prepareStatement("SELECT costPerDay FROM equipment WHERE equipmentId = ?")) {

            pstmt.setString(1, equipmentId);

            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                return resultSet.getFloat("costPerDay");
            } else {
                return 0.0f; // Default value if equipment cost is not found
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0.0f; // Assume default value in case of an error
        }
    }
    
    private void updateDatabase(String equipmentId, Date rentalDate, Date returnDate, float totalCost) {
        try (Connection dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/grizzlydb", "root", "");
             PreparedStatement pstmtSchedule = dbConn.prepareStatement("INSERT INTO scheduledEquipment (scheduleId, eventId, equipmentId, eventDate, returnDate) VALUES (?, ?, ?, ?, ?)");
             PreparedStatement pstmtTransaction = dbConn.prepareStatement("INSERT INTO transaction (transactionId, customerId, equipmentId, rentalDate, returnDate, totalCost) VALUES (?, ?, ?, ?, ?, ?)")) {

            // Generate scheduleId and eventId
            String scheduleId = generateScheduleId();
            String eventId = generateEventId();
            String transactionId = generateTransactionId();

            pstmtSchedule.setString(1, scheduleId);
            pstmtSchedule.setString(2, eventId);
            pstmtSchedule.setString(3, equipmentId);
            pstmtSchedule.setDate(4, new java.sql.Date(rentalDate.getTime()));
            pstmtSchedule.setDate(5, new java.sql.Date(returnDate.getTime()));

            // Fetch customerId from the customer table based on first name and last name
            String customerFirstName = this.customerFirstName;
            String customerLastName = this.customerLastName;
            String customerId = getCustomerIdFromDatabase(customerFirstName, customerLastName);

            pstmtTransaction.setString(1, transactionId);
            pstmtTransaction.setString(2, customerId);
            pstmtTransaction.setString(3, equipmentId);
            pstmtTransaction.setDate(4, new java.sql.Date(rentalDate.getTime()));
            pstmtTransaction.setDate(5, new java.sql.Date(returnDate.getTime()));
            pstmtTransaction.setFloat(6, totalCost);

            pstmtSchedule.executeUpdate();
            pstmtTransaction.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle error
        }
    }

    private String generateTransactionId() {
        String fullUuid = java.util.UUID.randomUUID().toString();
        // Use the first 20 characters of the UUID
        return fullUuid.substring(0, 20);
    }


    private String generateScheduleId() {
        String fullUuid = java.util.UUID.randomUUID().toString();
        // Use the first 20 characters of the UUID
        return fullUuid.substring(0, 20);
    }


    private String getCustomerIdFromDatabase(String firstName, String lastName) {
        String query = "SELECT customerId FROM customer WHERE firstName = ? AND lastName = ?";
        try (Connection dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/grizzlydb", "root", "");
             PreparedStatement pstmt = dbConn.prepareStatement(query)) {

            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);

            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("customerId");
            } else {
                // Handle the case where customerId is not found
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle error
            return null;
        }
    }

    private String generateEventId() {
    	String fullUuid = java.util.UUID.randomUUID().toString();
        return fullUuid.substring(0, 20);
    }

    private void populateCategoryComboBox() {
        categoryComboBox.addItem("All Categories");
        categoryComboBox.addItem("Staging");
        categoryComboBox.addItem("Lighting");
        categoryComboBox.addItem("Power");
        categoryComboBox.addItem("Sound");
    }
    
    private void updateEquipmentTable() {
        String selectedCategory = (String) categoryComboBox.getSelectedItem();

        try (Connection dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/grizzlydb", "root", "");
             PreparedStatement pstmt = dbConn.prepareStatement("SELECT equipmentId, equipmentName, type, costPerDay, status FROM equipment WHERE type = ?")) {

            pstmt.setString(1, selectedCategory);
            ResultSet resultSet = pstmt.executeQuery();

            DefaultTableModel model = (DefaultTableModel) jTableEquipment.getModel();
            model.setRowCount(0); // Clear existing data

            while (resultSet.next()) {
                String equipmentId = resultSet.getString("equipmentId");
                String equipmentName = resultSet.getString("equipmentName");
                String type = resultSet.getString("type");
                float costPerDay = resultSet.getFloat("costPerDay");
                String status = resultSet.getString("status");

                model.addRow(new Object[]{equipmentId, equipmentName, type, costPerDay, status});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Equipment> getEquipmentListByType(String type) {
        List<Equipment> equipmentList = new ArrayList<>();

        // SQL query to retrieve equipment of the specified type
        String query = "SELECT * FROM grizzlydb.equipment WHERE type = ?";

        try (PreparedStatement pstmt = dbConn.prepareStatement(query)) {
            pstmt.setString(1, type);
            result = pstmt.executeQuery();

            while (result.next()) {
                Equipment equipObj = new Equipment();
                equipObj.setEquipmentId(result.getString("equipmentId"));
                equipObj.setEquipmentName(result.getString("equipmentName"));
                equipObj.setStatus(result.getString("status"));
                equipObj.setType(result.getString("type"));
                equipObj.setCostPerDay(result.getFloat("costPerDay"));

                equipmentList.add(equipObj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return equipmentList;
    }


    public static void main(String args[]) {
        String customerFirstName = "John"; 
        String customerLastName = "Doe"; 
        float accountBalance = 2000f;
        String accountNumber = "123456789"; 

        java.awt.EventQueue.invokeLater(() -> new CustomerDashboard(customerFirstName, customerLastName, accountBalance, accountNumber).setVisible(true));
    }
}
