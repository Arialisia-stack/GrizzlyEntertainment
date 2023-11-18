package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDashboard extends JFrame {
	
	
	public Statement stmt;
	public ResultSet rs;
	
    public EmployeeDashboard() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Employee Dashboard");
        setSize(600, 400);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 2, 10, 10));

        JButton viewRentalRequestsButton = new JButton("View Rental Requests");
        viewRentalRequestsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                // Add logic to handle viewing rental requests
                JOptionPane.showMessageDialog(EmployeeDashboard.this, "View Rental Requests clicked!");
            	
            }
        });
        mainPanel.add(viewRentalRequestsButton);

        JButton viewEquipmentInventoryButton = new JButton("View Equipment Inventory");
        viewEquipmentInventoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add logic to handle viewing equipment inventory
                JOptionPane.showMessageDialog(EmployeeDashboard.this, "View Equipment Inventory clicked!");

                // Pass appropriate values for customerName and accountNumber
                String customerFirstName = "John"; 
                String customerLastName = "Doe"; 
                float accountBalance = 2000f;
                String accountNumber = "123456789"; 

                new CustomerDashboard(customerFirstName, customerLastName, accountBalance, accountNumber).setVisible(true);
            }
        });
        mainPanel.add(viewEquipmentInventoryButton);

        JButton scheduleEquipmentButton = new JButton("Schedule Equipment");
        scheduleEquipmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add logic to handle scheduling equipment
                JOptionPane.showMessageDialog(EmployeeDashboard.this, "Schedule Equipment clicked!");
            }
        });
        mainPanel.add(scheduleEquipmentButton);

        JButton respondToCustomerButton = new JButton("Respond to Customer");
        respondToCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add logic to handle responding to customers
                JOptionPane.showMessageDialog(EmployeeDashboard.this, "Respond to Customer clicked!");
            }
        });
        mainPanel.add(respondToCustomerButton);

        JButton createQuotationButton = new JButton("Create Quotation");
        createQuotationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add logic to handle creating quotations
                JOptionPane.showMessageDialog(EmployeeDashboard.this, "Create Quotation clicked!");
            }
        });
        mainPanel.add(createQuotationButton);

        JButton createInvoiceButton = new JButton("Create Invoice");
        createInvoiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add logic to handle creating invoices
                JOptionPane.showMessageDialog(EmployeeDashboard.this, "Create Invoice clicked!");
            }
        });
        mainPanel.add(createInvoiceButton);

        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new EmployeeDashboard().setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}
