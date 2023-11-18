package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import domain.Equipment;
import domain.Message;
import domain.RentalRequest;
import domain.Transaction;



public class EmployeeDashboard extends JFrame {
	
	private JButton viewInventoryBtn;
	private JButton logoutBtn;
	private JButton sendInvoiceBtn;
	private JButton dashboardBtn;
	private JPanel sidebarPanel;
	private JPanel mainPanel;
	private JTable request_table;
	private RentalRequest rental;
	private Statement stmt;
	private ResultSet rs;
	private Equipment equipment;
	private Connection dbConn;
	private DefaultTableModel dtm;
	Logger logger = LogManager.getLogger(EmployeeDashboard.class.getName());
	private static final long serialVersionUID = 1L;

	public EmployeeDashboard() {
        this.setTitle("Employee Dashboard");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setVisible(true);

        // Sidebar panel for tabs
        sidebarPanel = new JPanel();
        sidebarPanel.setLayout(new BoxLayout(sidebarPanel, BoxLayout.Y_AXIS));
        sidebarPanel.setBackground(new Color(56,106,179));
       
        
        viewInventoryBtn = new JButton("VIEW INVENTORY");
        viewInventoryBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewInventoryBtn.setMaximumSize(new Dimension(150, 30));
        
        logoutBtn = new JButton("LOGOUT");
        logoutBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoutBtn.setMaximumSize(new Dimension(150, 30));
        
        sendInvoiceBtn = new JButton("GENERATE INVOICE");
        sendInvoiceBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        sendInvoiceBtn.setMaximumSize(new Dimension(150, 30));
        
        dashboardBtn = new JButton("DASHBOARD");
        dashboardBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        dashboardBtn.setMaximumSize(new Dimension(150, 30));
        
        //adding buttons to sidePanel
        sidebarPanel.add(Box.createVerticalStrut(40));
        sidebarPanel.add(viewInventoryBtn);
        sidebarPanel.add(Box.createVerticalStrut(20));
        sidebarPanel.add(sendInvoiceBtn);
        sidebarPanel.add(Box.createVerticalStrut(20));
        sidebarPanel.add(dashboardBtn);
        sidebarPanel.add(Box.createVerticalStrut(20));
        sidebarPanel.add(logoutBtn);
        sidebarPanel.add(Box.createVerticalStrut(20));

        // Main content area
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE); // Setting background color for demonstration

        // Place sidebar on the left and main content on the right
        setLayout(new BorderLayout());
        add(sidebarPanel, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);
        
      //creating the table to display customer's request 
        request_table = new JTable();
        JScrollPane rtScroll = new JScrollPane();
        request_table.setModel(new javax.swing.table.DefaultTableModel(
                        new Object[][]{
                                {null, null, null, null,null, null},
                        },
                        new String[]{
                                "Request ID", "Equipment ID", "Customer ID", 
        						"Requested Date", "Message ID", "Status"
                        }
                ));

                rtScroll.setViewportView(request_table);
                //upon login, employee is faced with all rental request
                viewAllRequest();
                
        //adding scroll pane to main panel'
        mainPanel.add(rtScroll);
    }
	
	public RentalRequest viewAllRequest()
	{
		String request = ("SELECT * FROM grizzlydb.rentalRequest");
		try
		{
			Connection connection = DriverManager.getConnection("jdbc://localhost:3307/grizzlydb","root","");
			stmt = connection.createStatement();
			rs = stmt.executeQuery(request);
			while (rs.next())
			{
				 rental = new RentalRequest();	
				 rental.setCustomerId(rs.getString("customerId"));
				 rental.setEquipmentId(rs.getString("equipmentId"));
				 rental.setMessageId(rs.getString("messageId"));
				 rental.setRequestId(rs.getString("requestId"));
				 rental.setRequestedDate(rs.getDate("requestedDate"));
				 rental.setStatus(rs.getString("status"));

			}
				JOptionPane.showMessageDialog(null,"[ERROR] --- TABLE COULD NOT BE POPULATED");
		}

				catch(SQLException sql)
				{
					logger.error("[ERROR] --- DATA COULD NOT BE FETCHED");
					sql.printStackTrace();
				}
				catch(Exception e)
				{
					logger.error("[ERROR] --- ERROR WITH VIEWALL METHOD");
					e.getMessage();
				}
		return rental;
		
	}
	
	
	public Equipment viewAllEquiptment()
	{
		viewInventoryBtn.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						// SQL query to retrieve equipment of the specified type
				        String query = "SELECT * FROM grizzlydb.equipment";

				        try (PreparedStatement pstmt = dbConn.prepareStatement(query)) {
				            rs = pstmt.executeQuery();

				            while (rs.next()) {
				                Equipment equipment = new Equipment();
				                equipment.setEquipmentId(rs.getString("equipmentId"));
				                equipment.setEquipmentName(rs.getString("equipmentName"));
				                equipment.setStatus(rs.getString("status"));
				                equipment.setType(rs.getString("type"));
				                equipment.setCostPerDay(rs.getFloat("costPerDay"));
				            }
				        } catch (SQLException esq) {
				        	esq.printStackTrace();
				        }
						
					}
			
				});
		return equipment;
	}
	
	public void approveRentalRequest(JTable request_table)
	{
		request_table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				//generate a report based on the row and sue the submit buttomn to update transaction table
				int sr = request_table.getSelectedRow();
				if (sr != 1)
				{
					showRowDataDialogue(sr);
				}
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
	}
	
	public void showRowDataDialogue(int row)
	{
		 Transaction transaction = new Transaction();
		 
		 dtm = (DefaultTableModel) request_table.getModel();
		 Object[] rowData = new Object[dtm.getColumnCount()];
		 for (int i = 0; i <dtm.getColumnCount(); i++)
		 {
			 rowData[i] = dtm.getValueAt(row, i);
		 }
		 
		 JOptionPane.showMessageDialog(this, rowData, "Row Data", JOptionPane.INFORMATION_MESSAGE);
		 transaction.add(new Transaction(transactionId, customerId, equipmentId, rentalDate, returnDate, totalCost));
		 
	}
	
	public void sendResponse(int msgId, String response) {
		try
		{
			Message messageId  = new Message();
			JTextArea msgResponse = new JTextArea();
			long millis = System.currentTimeMillis();
			Date date = new Date(millis);
            dbConn =  java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/grizzlydb", "root", " ");   
			String query = "UPDATE message SET response = ? WHERE messageId = ?";
			java.sql.PreparedStatement stmt = dbConn.prepareStatement(query);
			stmt.setString(1, response);
			stmt.setString(2, messageId);
			int result = stmt.executeUpdate();
             if(result == 1) 
             {
            	 javax.swing.JOptionPane.showMessageDialog(null, "Response has been sent");
            	 msgResponse.setText("");
             }
             
            //button to submit message 
            javax.swing.JButton btnSendResponse = new javax.swing.JButton("Submit Response");
     		btnSendResponse.addActionListener(new java.awt.event.ActionListener() {
     			public void actionPerformed(java.awt.event.ActionEvent e) {
     				
     				if(msgResponse.getText()== "") 
     				{
     					javax.swing.JOptionPane.showMessageDialog(btnSendResponse, "Cannot send empty response");
     				}
     				else 
     				{
     					sendResponse(msgId, response);
     				}
     			}
     		});
     		btnSendResponse.setBounds(620, 398, 150, 23);
     		mainPanel.add(btnSendResponse);   	 
            	 
         }
           
          catch( java.sql.SQLException e) 
		{
            	logger.error("[ERROR] - Error while adding response");
            	 e.printStackTrace();
         }

	}
	
	
	public void GenerateInvoice()
	{
		sendInvoiceBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
		//		new invoiceGenerator();
				
			}
			
		});
	}
	
	
	
	private static void main(String[] args) {
		 new EmployeeDashboard();

	}

}
