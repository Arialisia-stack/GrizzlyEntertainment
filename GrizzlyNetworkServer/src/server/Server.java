package server;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import domain.Customer;
import domain.Employee;
import domain.Equipment;
import domain.Invoice;
import domain.Message;
import domain.RentalRequest;
import domain.ScheduledEquipment;
import domain.Transaction;
import domain.User;

public class Server {
	private ServerSocket serverSocket;
	private Socket connectionSocket;
	private ObjectOutputStream objOs;
	private ObjectInputStream objIs;
	private static Connection dbConn = null;
	private Statement stmt;
	private ResultSet result = null;
	
	private static final Logger logger = LogManager.getLogger(Server.class);
	
	public Server() {
		logger.info("Server is starting...");
		this.createConnection();
		this.waitForRequests();
	}
	
	private void createConnection() {
		try {
			serverSocket = new ServerSocket(8888);
		} catch (IOException e) {
			logger.error("Error creating server socket", e);
			e.printStackTrace();
		}
	}
	
	private void configureStreams() {
		try {
			objOs = new ObjectOutputStream(connectionSocket.getOutputStream());
			objIs = new ObjectInputStream(connectionSocket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static Connection getDatabaseConnection() {
		if (dbConn == null) {
			try {
				String url = "jdbc:mysql://localhost:3306/grizzlydb";
				
					dbConn = DriverManager.getConnection(url, "root", "");
				
				JOptionPane.showMessageDialog(null, "DB Connection Established",
						"CONNECTION STATUS",JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Could not connect to database\n" + ex,
						"Connection Failure", JOptionPane.ERROR_MESSAGE);
			}
		}
		return dbConn;
	}
	
	private void closeConnection() {
		try {
			objOs.close();
			objIs.close();
			connectionSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void addUserToFile(User user) {
		String sql = "INSERT INTO grizzlydb.user(userId, username, password, role)"
	            + "VALUES ('" + user.getUserId() + "' , '" + user.getUsername()
	            + "', '" + user.getPassword() + "', '" + user.getRole()+ "');";
	    System.out.println("SQL Query: " + sql);  // debugging
		try {
			stmt = dbConn.createStatement();
		
			if ((stmt.executeUpdate(sql)==1)) {
				objOs.writeObject(true);
			}else {
				objOs.writeObject(false);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private User findUserById(String userId) {
		User userObj = new User ();
		String query = "SELECT * FROM grizzlydb.user WHERE userId = " + userId;
		System.out.println("SQL Query: " + query);//debugging
		try {
			stmt = dbConn.createStatement();
			result = stmt.executeQuery (query);
			if (result.next()) {
				userObj.setUserId(result.getString(1));
				userObj.setUsername(result.getString(2));
				userObj.setPassword(result.getString(3));
				userObj.setRole(result.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userObj;
	}
	
	private void addCustomerToFile(Customer customer) {
		String sql = "INSERT INTO grizzlydb.customer(customerId, firstName, lastName, accountNumber, accountBalance)"
	            + "VALUES ('" + customer.getCustomerId() + "' , '" + customer.getFirstName()
	            + "', '" + customer.getLastName() + "', '" + customer.getAccountNumber()+ "', '" + customer.getAccountBalance() + "');";
	    System.out.println("SQL Query: " + sql);  // debugging
		try {
			stmt = dbConn.createStatement();
		
			if ((stmt.executeUpdate(sql)==1)) {
				objOs.writeObject(true);
			}else {
				objOs.writeObject(false);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private Customer findCustomerById(String custId) {
		Customer custObj = new Customer ();
		String query = "SELECT * FROM grizzlydb.customer WHERE customerId = " + custId;
		System.out.println("SQL Query: " + query);//debugging
		try {
			stmt = dbConn.createStatement();
			result = stmt.executeQuery (query);
			if (result.next()) {
				custObj.setCustomerId(result.getString(1));
				custObj.setFirstName(result.getString(2));
				custObj.setLastName(result.getString(3));
				custObj.setAccountNumber(result.getInt(4));
				custObj.setAccountBalance(result.getFloat(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return custObj;
	}
	
	private void addEmployeeToFile(Employee employee) {
		String sql = "INSERT INTO grizzlydb.employee(employeeId, firstName, lastName)"
	            + "VALUES ('" + employee.getEmployeeId() + "' , '" + employee.getFirstName()
	            + "', '" + employee.getLastName() + "');";
	    System.out.println("SQL Query: " + sql);  // debugging
		try {
			stmt = dbConn.createStatement();
		
			if ((stmt.executeUpdate(sql)==1)) {
				objOs.writeObject(true);
			}else {
				objOs.writeObject(false);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private Employee findEmployeeById(String employeeId) {
		Employee empObj = new Employee ();
		String query = "SELECT * FROM grizzlydb.employee WHERE employeeId = " + employeeId;
		System.out.println("SQL Query: " + query);//debugging
		try {
			stmt = dbConn.createStatement();
			result = stmt.executeQuery (query);
			if (result.next()) {
				empObj.setEmployeeId(result.getString(1));
				empObj.setFirstName(result.getString(2));
				empObj.setLastName(result.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empObj;
	}
	
	private void addEquipmentToFile(Equipment equipment) {
		String sql = "INSERT INTO grizzlydb.equipment(equipmentId, equipmentName, type, status, costPerDay)"
	            + "VALUES ('" + equipment.getEquipmentId() + "' , '" + equipment.getEquipmentName()
	            + "', '" + equipment.getType() + "', '" + equipment.getStatus()+ "', '" + equipment.getCostPerDay() + "');";
	    System.out.println("SQL Query: " + sql);  // debugging
		try {
			stmt = dbConn.createStatement();
		
			if ((stmt.executeUpdate(sql)==1)) {
				objOs.writeObject(true);
			}else {
				objOs.writeObject(false);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private Equipment findEquipmentById(String equipmentId) {
		Equipment equipObj = new Equipment ();
		String query = "SELECT * FROM grizzlydb.equipment WHERE equipmentId = " + equipmentId;
		System.out.println("SQL Query: " + query);//debugging
		try {
			stmt = dbConn.createStatement();
			result = stmt.executeQuery (query);
			if (result.next()) {
				equipObj.setEquipmentId(result.getString(1));
				equipObj.setEquipmentName(result.getString(2));
				equipObj.setStatus(result.getString(3));
				equipObj.setType(result.getString(4));
				equipObj.setCostPerDay(result.getFloat(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return equipObj;
	}
	
	private void addTransactionToFile(Transaction transaction) {
		String sql = "INSERT INTO grizzlydb.transaction(transactionId, customerId, equipmentId, rentalDate, returnDate, totalCost)"
	            + "VALUES ('" + transaction.getTransactionId() + "' , '" + transaction.getCustomerId()
	            + "', '" + transaction.getEquipmentId() + "', '" + transaction.getRentalDate() + "',"
	            + " '" + transaction.getReturnDate()+ "', '" + transaction.getTotalCost() + "');";
	    System.out.println("SQL Query: " + sql);  // debugging
		try {
			stmt = dbConn.createStatement();
		
			if ((stmt.executeUpdate(sql)==1)) {
				objOs.writeObject(true);
			}else {
				objOs.writeObject(false);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private Transaction findTransactionById(String transactionId) {
	    Transaction transObj = new Transaction();
	    String query = "SELECT * FROM grizzlydb.transaction WHERE transactionId = ?";
	    System.out.println("SQL Query: " + query); // debugging

	    try (PreparedStatement pstmt = dbConn.prepareStatement(query)) {
	        pstmt.setString(1, transactionId);
	        result = pstmt.executeQuery();
	        if (result.next()) {
	            transObj.setTransactionId(result.getString("transactionId"));
	            transObj.setCustomerId(result.getString("customerId"));
	            transObj.setEquipmentId(result.getString("equipmentId"));
	            transObj.setRentalDate(result.getDate("rentalDate"));
	            transObj.setReturnDate(result.getDate("returnDate"));
	            transObj.setTotalCost(result.getFloat("totalCost"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return transObj;
	}
	
	private void addRentalRequestToFile(RentalRequest rentalRequest) {
		String sql = "INSERT INTO grizzlydb.rentalrequest(requestId, customerId, equipmentId, requestedDate, messageId, status)"
	            + "VALUES ('" + rentalRequest.getRequestId() + "' , '" + rentalRequest.getCustomerId()
	            + "', '" + rentalRequest.getEquipmentId() + "', '" + rentalRequest.getRequestedDate() + "',"
	            + " '" + rentalRequest.getMessageId()+ "', '" + rentalRequest.getStatus() + "');";
	    System.out.println("SQL Query: " + sql);  // debugging
		try {
			stmt = dbConn.createStatement();
		
			if ((stmt.executeUpdate(sql)==1)) {
				objOs.writeObject(true);
			}else {
				objOs.writeObject(false);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private RentalRequest findRentalRequestById(String requestId) {
	    RentalRequest requestObj = new RentalRequest();
	    String query = "SELECT * FROM grizzlydb.rentalrequest WHERE requestId = ?";
	    System.out.println("SQL Query: " + query); // debugging

	    try (PreparedStatement pstmt = dbConn.prepareStatement(query)) {
	        pstmt.setString(1, requestId);
	        result = pstmt.executeQuery();
	        if (result.next()) {
	            requestObj.setRequestId(result.getString("requestId"));
	            requestObj.setCustomerId(result.getString("customerId"));
	            requestObj.setEquipmentId(result.getString("equipmentId"));
	            requestObj.setRequestedDate(result.getDate("requestedDate"));
	            requestObj.setMessageId(result.getString("messageId"));
	            requestObj.setStatus(result.getString("status"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return requestObj;
	}
	
	private void addMessageToFile(Message message) {
		String sql = "INSERT INTO grizzlydb.message(messageId, senderId, receiverId, messageContent, timestamp)"
	            + "VALUES ('" + message.getMessageId() + "' , '" + message.getSenderId()
	            + "', '" + message.getReceiverId() + "', '" + message.getMessageContent() + "',"
	            + " '" + message.getTimestamp()+ "');";
	    System.out.println("SQL Query: " + sql);  // debugging
		try {
			stmt = dbConn.createStatement();
		
			if ((stmt.executeUpdate(sql)==1)) {
				objOs.writeObject(true);
			}else {
				objOs.writeObject(false);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private Message findMessageById(String messageId) {
	    Message messObj = new Message();
	    String query = "SELECT * FROM grizzlydb.message WHERE messageId = ?";
	    System.out.println("SQL Query: " + query); // debugging

	    try (PreparedStatement pstmt = dbConn.prepareStatement(query)) {
	        pstmt.setString(1, messageId);
	        result = pstmt.executeQuery();
	        if (result.next()) {
	            messObj.setMessageId(result.getString("messageId"));
	            messObj.setSenderId(result.getString("senderId"));
	            messObj.setReceiverId(result.getString("receiverId"));
	            messObj.setMessageContent(result.getString("messageContent"));
	            messObj.setTimestamp(result.getTimestamp("timestamp"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return messObj;
	}
	
	private void addScheduledEquipmentToFile(ScheduledEquipment scheduledEquipment) {
		String sql = "INSERT INTO grizzlydb.scheduledequipment(scheduleId, eventId, equipmentId, eventDate)"
	            + "VALUES ('" + scheduledEquipment.getScheduledId() + "' , '" + scheduledEquipment.getEventId()
	            + "', '" + scheduledEquipment.getEquipmentId() + "', '" + scheduledEquipment.getEventDate() + "');";
	    System.out.println("SQL Query: " + sql);  // debugging
		try {
			stmt = dbConn.createStatement();
		
			if ((stmt.executeUpdate(sql)==1)) {
				objOs.writeObject(true);
			}else {
				objOs.writeObject(false);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private ScheduledEquipment findScheduledEquipmentById(String scheduleId) {
		ScheduledEquipment schEquipObj = new ScheduledEquipment();
	    String query = "SELECT * FROM grizzlydb.scheduledequipment WHERE scheduleId = ?";
	    System.out.println("SQL Query: " + query); // debugging

	    try (PreparedStatement pstmt = dbConn.prepareStatement(query)) {
	        pstmt.setString(1, scheduleId);
	        result = pstmt.executeQuery();
	        if (result.next()) {
	        	schEquipObj.setScheduledId(result.getString("scheduleId"));
	        	schEquipObj.setEventId(result.getString("eventId"));
	        	schEquipObj.setEquipmentId(result.getString("equipmentId"));
	        	schEquipObj.setEventDate(result.getDate("eventDate"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return schEquipObj;
	}
	
	private void addInvoiceToFile(Invoice invoice) {
		String sql = "INSERT INTO grizzlydb.invoice(invoiceId, transactionId, invoiceDate, amount)"
	            + "VALUES ('" + invoice.getInvoiceId() + "' , '" + invoice.getTransactionId()
	            + "', '" + invoice.getInvoiceDate() + "', '" + invoice.getAmount() + "');";
	    System.out.println("SQL Query: " + sql);  // debugging
		try {
			stmt = dbConn.createStatement();
		
			if ((stmt.executeUpdate(sql)==1)) {
				objOs.writeObject(true);
			}else {
				objOs.writeObject(false);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private Invoice findInvoiceById(String invoiceId) {
		Invoice invObj = new Invoice();
	    String query = "SELECT * FROM grizzlydb.invoice WHERE invoiceId = ?";
	    System.out.println("SQL Query: " + query); // debugging

	    try (PreparedStatement pstmt = dbConn.prepareStatement(query)) {
	        pstmt.setString(1, invoiceId);
	        result = pstmt.executeQuery();
	        if (result.next()) {
	        	invObj.setInvoiceId(result.getString("invoiceId"));
	        	invObj.setTransactionId(result.getString("transactionId"));
	        	invObj.setInvoiceDate(result.getDate("invoiceDate"));
	        	invObj.setAmount(result.getFloat("amount"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return invObj;
	}
	
	// Method to get a list of equipment by type
	  private List<Equipment> getEquipmentListByType(String type) {
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

	  private void waitForRequests() {
	        getDatabaseConnection();
	        try {
	            while (true) {
	                connectionSocket = serverSocket.accept();
	                // Handle each client request in a separate thread
	                Thread clientThread = new Thread(() -> handleClientRequest(connectionSocket));
	                clientThread.start();
	            }
	        } catch (IOException ex) {
	            logger.error("IOException", ex);
	            ex.printStackTrace();
	        }
	    }

	    private void handleClientRequest(Socket clientSocket) {
			User userObj;
			Customer custObj;
			Employee empObj;
			Equipment equipObj;
			Transaction transObj;
			RentalRequest requestObj;
			Message messObj;
			ScheduledEquipment schEquipObj;
			Invoice invObj;
	    	
	        configureStreams();
	        String action = "";

	        try {
	            action = (String) objIs.readObject();
	            logger.info("Received action: " + action);
				
				if (action.equals("Add User")) {
					userObj = (User)objIs.readObject();
					addUserToFile(userObj);
					objOs.writeObject(true);
				} else if (action.equals("Find User")) {
					String userId = (String) objIs.readObject();
				
					userObj = findUserById(userId);
					objOs.writeObject(userObj);
				}
				
				if (action.equals("Add Customer")) {
					custObj = (Customer)objIs.readObject();
					addCustomerToFile(custObj);
					objOs.writeObject(true);
				} else if (action.equals("Find Customer")) {
					String customerId = (String) objIs.readObject();
				
					custObj = findCustomerById(customerId);
					objOs.writeObject(custObj);
				}
				
				if (action.equals("Add Employee")) {
					empObj = (Employee)objIs.readObject();
					addEmployeeToFile(empObj);
					objOs.writeObject(true);
				} else if (action.equals("Find Employee")) {
					String employeeId = (String) objIs.readObject();
				
					empObj = findEmployeeById(employeeId);
					objOs.writeObject(empObj);
				}
				
				if (action.equals("Add Equipment")) {
					equipObj = (Equipment)objIs.readObject();
					addEquipmentToFile(equipObj);
					objOs.writeObject(true);
				} else if (action.equals("Find Equipment")) {
					String equipmentId = (String) objIs.readObject();
				
					equipObj = findEquipmentById(equipmentId);
					objOs.writeObject(equipObj);
				}
				
				if (action.equals("Add Transaction")) {
					transObj = (Transaction)objIs.readObject();
					addTransactionToFile(transObj);
					objOs.writeObject(true);
				} else if (action.equals("Find Transaction")) {
					String transactionId = (String) objIs.readObject();
				
					transObj = findTransactionById(transactionId);
					objOs.writeObject(transObj);
				}
				
				if (action.equals("Add Rental Request")) {
					requestObj = (RentalRequest)objIs.readObject();
					addRentalRequestToFile(requestObj);
					objOs.writeObject(true);
				} else if (action.equals("Find Rental Request")) {
					String requestId = (String) objIs.readObject();
				
					requestObj = findRentalRequestById(requestId);
					objOs.writeObject(requestObj);
				}
				
				if (action.equals("Add Message")) {
					messObj = (Message)objIs.readObject();
					addMessageToFile(messObj);
					objOs.writeObject(true);
				} else if (action.equals("Find Message")) {
					String messageId = (String) objIs.readObject();
				
					messObj = findMessageById(messageId);
					objOs.writeObject(messObj);
				}
				
				if (action.equals("Add Scheduled Equipment")) {
					schEquipObj = (ScheduledEquipment)objIs.readObject();
					addScheduledEquipmentToFile(schEquipObj);
					objOs.writeObject(true);
				} else if (action.equals("Find Scheduled Equipment")) {
					String scheduleId = (String) objIs.readObject();
				
					schEquipObj = findScheduledEquipmentById(scheduleId);
					objOs.writeObject(schEquipObj);
				}
				
				if (action.equals("Add Invoice")) {
					invObj = (Invoice)objIs.readObject();
					addInvoiceToFile(invObj);
					objOs.writeObject(true);
				} else if (action.equals("Find Invoice")) {
					String invoiceId = (String) objIs.readObject();
				
					invObj = findInvoiceById(invoiceId);
					objOs.writeObject(invObj);
				}
				if (action.equals("Find Equipment By Type")) {
					String equipmentType = (String) objIs.readObject();

					List<Equipment> equipmentList = getEquipmentListByType(equipmentType);

			        // Send the equipment list back to the client
					objOs.writeObject(equipmentList);
				}
				
	        } catch (SocketException se) {
	            // Handle the socket closure
	            System.out.println("Client closed the connection.");
	            logger.warn("Client closed the connection.", se);
	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	            logger.error("Exception occurred: " + e.getMessage());
	            logger.error("Exception occurred", e);
	        } finally {
	            closeConnection();
	        }
	    }
}
