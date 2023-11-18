package client;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

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

public class Client {
	private ObjectInputStream objIs;
	private static ObjectOutputStream objOs;
	private Socket connectionSocket;
	private String action = "";
	
	private static final Logger logger = LogManager.getLogger(Client.class);
    private static final Logger exceptionLogger = LogManager.getLogger("exceptions");

	
	public Client() {
		this.createConnection();
		this.configureStreams();
		
		  // Start a new thread for communication with the server
        Thread communicationThread = new Thread(this::startCommunication);
        communicationThread.start();
	}
	
	private void createConnection() {
		try {
			connectionSocket = new Socket ("127.0.0.1",8888);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	private void configureStreams() {
		try {
			objIs = new ObjectInputStream(connectionSocket.getInputStream());
			objOs = new ObjectOutputStream(connectionSocket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void closeConnection() {
		try {
			objOs.close();
			objIs.close();
			connectionSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendAction(String action) {
		this.action = action;
		try {
			objOs.writeObject(action);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendUser(User userObj) {
		try {
			objOs.writeObject(userObj);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendCustomer(Customer custObj) {
		try {
			objOs.writeObject(custObj);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendEmployee(Employee emp) {
		try {
			objOs.writeObject(emp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendEquipment(Equipment equip) {
		try {
			objOs.writeObject(equip);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendTransaction(Transaction trans) {
		try {
			objOs.writeObject(trans);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendMessage(Message message) {
		try {
			objOs.writeObject(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendRentalRequest(RentalRequest request) {
		try {
			objOs.writeObject(request);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendScheduledEquipment(ScheduledEquipment schEquip) {
		try {
			objOs.writeObject(schEquip);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendInvoice(Invoice inv) {
		try {
			objOs.writeObject(inv);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendUserId(String userId) {
		try {
			objOs.writeObject(userId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendCustomerId(String customerId) {
		try {
			objOs.writeObject(customerId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendEmployeeId(String employeeId) {
		try {
			objOs.writeObject(employeeId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendEquipmentId(String equipmentId) {
		try {
			objOs.writeObject(equipmentId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendTransactionId(String transactionId) {
		try {
			objOs.writeObject(transactionId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendMessageId(String messageId) {
		try {
			objOs.writeObject(messageId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendRentalRequestId(String requestId) {
		try {
			objOs.writeObject(requestId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendScheduledEquipmentId(String scheduleId) {
		try {
			objOs.writeObject(scheduleId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendInvoiceId(String invoiceId) {
		try {
			objOs.writeObject(invoiceId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendEquipmentType(String type) {
	    try {
	        // Send equipment type
	        objOs.writeObject(type);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	private void startCommunication() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                // Prompt the user for input
                System.out.println("Enter your action (e.g., 'Add User', 'Find User', 'Exit'): ");
                String userInput = scanner.nextLine();

                // Check if the user wants to exit
                if ("Exit".equalsIgnoreCase(userInput)) {
                    break; // Exit the loop and close the connection
                }

                // Send the user input as an action to the server
                sendAction(userInput);

                // Sleep for a short duration to avoid high CPU usage in the loop
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the connection when the loop exits
            closeConnection();
        }
    }
	
	public void receiveResponse() {
		try {
			if(action.equalsIgnoreCase("Add User")) {
				Boolean flag = (Boolean) objIs.readObject();
				if( flag == true) {
					JOptionPane.showMessageDialog(null, "Record added successfully",
							"Add Record Status",JOptionPane.INFORMATION_MESSAGE);
					  logger.info("Record added successfully");
				}
			}
			if(action.equalsIgnoreCase("Find User")) {
				User user = new User();
				user = (User)objIs.readObject();
				if(user == null) {
					JOptionPane.showMessageDialog(null, "Record could not be found",
							"Find Record Status", JOptionPane.ERROR_MESSAGE);
					  logger.info("No Record Found");
					return;
				}
				System.out.println("Received User: " + user.getUserId() + " " + user.getUsername() + " " + user.getPassword() + 
									" " + user.getRole());//debugging
			}
			if(action.equalsIgnoreCase("Add Customer")) {
				Boolean flag = (Boolean) objIs.readObject();
				if( flag == true) {
					JOptionPane.showMessageDialog(null, "Record added successfully",
							"Add Record Status",JOptionPane.INFORMATION_MESSAGE);
					logger.info("Record added successfully");
				}
			}
				if(action.equalsIgnoreCase("Find Customer")) {
					Customer customer = new Customer();
					customer = (Customer)objIs.readObject();
					if(customer == null) {
						JOptionPane.showMessageDialog(null, "Record could not be found",
								"Find Record Status", JOptionPane.ERROR_MESSAGE);
						logger.info("No Record Found");
						return;
					}
					System.out.println("Received Customer: " + customer.getCustomerId() + " " + customer.getFirstName() +
										" " + customer.getLastName()+ " " + customer.getAccountNumber() + " " + customer.getAccountBalance());//debugging
				}
				if(action.equalsIgnoreCase("Add Employee")) {
					Boolean flag = (Boolean) objIs.readObject();
					if( flag == true) {
						JOptionPane.showMessageDialog(null, "Record added successfully",
								"Add Record Status",JOptionPane.INFORMATION_MESSAGE);
						  logger.info("Record added successfully");
					}
				}
					if(action.equalsIgnoreCase("Find Employee")) {
						Employee employee = new Employee();
						employee = (Employee)objIs.readObject();
						if(employee == null) {
							JOptionPane.showMessageDialog(null, "Record could not be found",
									"Find Record Status", JOptionPane.ERROR_MESSAGE);
							logger.info("No Record Found");
							return;
						}
						System.out.println("Received Employee: " + employee.getEmployeeId() + " " + employee.getFirstName() +
											" " + employee.getLastName());//debugging
					}
					if(action.equalsIgnoreCase("Add Equipment")) {
						Boolean flag = (Boolean) objIs.readObject();
						if( flag == true) {
							JOptionPane.showMessageDialog(null, "Record added successfully",
									"Add Record Status",JOptionPane.INFORMATION_MESSAGE);
							  logger.info("Record added successfully");
						}
					}
						if(action.equalsIgnoreCase("Find Equipment")) {
							Equipment equipment = new Equipment();
							equipment = (Equipment)objIs.readObject();
							if(equipment == null) {
								JOptionPane.showMessageDialog(null, "Record could not be found",
										"Find Record Status", JOptionPane.ERROR_MESSAGE);
								logger.info("No Record Found");
								return;
							}
							System.out.println("Received Equipment: " + equipment.getEquipmentId() + " " + equipment.getEquipmentName() +
												" " + equipment.getStatus() + " " + equipment.getType() + " " + equipment.getCostPerDay());//debugging
						}
						if(action.equalsIgnoreCase("Add Transaction")) {
							Boolean flag = (Boolean) objIs.readObject();
							if( flag == true) {
								JOptionPane.showMessageDialog(null, "Record added successfully",
										"Add Record Status",JOptionPane.INFORMATION_MESSAGE);
								  logger.info("Record added successfully");
							}
						}
							if(action.equalsIgnoreCase("Find Transaction")) {
								Transaction transaction = new Transaction();
								transaction = (Transaction)objIs.readObject();
								if(transaction == null) {
									JOptionPane.showMessageDialog(null, "Record could not be found",
											"Find Record Status", JOptionPane.ERROR_MESSAGE);
									logger.info("No Record Found");
									return;
								}
								System.out.println("Received Transaction: " + transaction.getTransactionId() + " " + transaction.getCustomerId() + 
													" " + transaction.getEquipmentId() + " " + transaction.getRentalDate() + " " + transaction.getReturnDate() +
													" " + transaction.getTotalCost());//debugging
							}
							if(action.equalsIgnoreCase("Add Message")) {
								Boolean flag = (Boolean) objIs.readObject();
								if( flag == true) {
									JOptionPane.showMessageDialog(null, "Record added successfully",
											"Add Record Status",JOptionPane.INFORMATION_MESSAGE);
									  logger.info("Record added successfully");
								}
							}
								if(action.equalsIgnoreCase("Find Message")) {
									Message message = new Message();
									message = (Message)objIs.readObject();
									if(message == null) {
										JOptionPane.showMessageDialog(null, "Record could not be found",
												"Find Record Status", JOptionPane.ERROR_MESSAGE);
										logger.info("No Record Found");
										return;
									}
									System.out.println("Received Message: " + message.getMessageId() + " " + message.getSenderId() + 
														" " + message.getReceiverId() + " " + message.getMessageContent() + " " + 
														message.getTimestamp());//debugging
								}
							if(action.equalsIgnoreCase("Add Rental Request")) {
								Boolean flag = (Boolean) objIs.readObject();
								if( flag == true) {
									JOptionPane.showMessageDialog(null, "Record added successfully",
											"Add Record Status",JOptionPane.INFORMATION_MESSAGE);
									  logger.info("Record added successfully");
								}
							}
								if(action.equalsIgnoreCase("Find Rental Request")) {
									RentalRequest rentalRequest = new RentalRequest();
									rentalRequest = (RentalRequest)objIs.readObject();
									if(rentalRequest == null) {
										JOptionPane.showMessageDialog(null, "Record could not be found",
												"Find Record Status", JOptionPane.ERROR_MESSAGE);
										logger.info("No Record Found");
										return;
									}
									System.out.println("Received Request: " + rentalRequest.getRequestId() + " " + rentalRequest.getCustomerId() + 
														" " + rentalRequest.getEquipmentId() + " " + rentalRequest.getRequestedDate() + " " + 
														rentalRequest.getMessageId() + " " + rentalRequest.getStatus());//debugging
								}
								if(action.equalsIgnoreCase("Add Scheduled Equipment")) {
									Boolean flag = (Boolean) objIs.readObject();
									if( flag == true) {
										JOptionPane.showMessageDialog(null, "Record added successfully",
												"Add Record Status",JOptionPane.INFORMATION_MESSAGE);
										  logger.info("Record added successfully");
									}
								}
									if(action.equalsIgnoreCase("Find Scheduled Equipment")) {
										ScheduledEquipment scheduledEquipment = new ScheduledEquipment();
										scheduledEquipment = (ScheduledEquipment)objIs.readObject();
										if(scheduledEquipment == null) {
											JOptionPane.showMessageDialog(null, "Record could not be found",
													"Find Record Status", JOptionPane.ERROR_MESSAGE);
											logger.info("No Record Found");
											return;
										}
										System.out.println("Received Scheduled Equipment: " + scheduledEquipment.getScheduledId() + " " + scheduledEquipment.getEventId() + 
															" " + scheduledEquipment.getEquipmentId() + " " + scheduledEquipment.getEventDate());//debugging
									}
									if(action.equalsIgnoreCase("Add Invoice")) {
										Boolean flag = (Boolean) objIs.readObject();
										if( flag == true) {
											JOptionPane.showMessageDialog(null, "Record added successfully",
													"Add Record Status",JOptionPane.INFORMATION_MESSAGE);
											  logger.info("Record added successfully");
										}
									}
										if(action.equalsIgnoreCase("Find Invoice")) {
											Invoice invoice = new Invoice();
											invoice = (Invoice)objIs.readObject();
											if(invoice == null) {
												JOptionPane.showMessageDialog(null, "Record could not be found",
														"Find Record Status", JOptionPane.ERROR_MESSAGE);
												logger.info("No Invoice Found");
												return;
											}
											System.out.println("Received Invoice: " + invoice.getInvoiceId() + " " + invoice.getTransactionId() + 
																" " + invoice.getInvoiceDate() + " " + invoice.getAmount());//debugging
										}
										if (action.equalsIgnoreCase("Find Equipment By Type")) {								            
								            List<Equipment> equipmentList = (List<Equipment>) objIs.readObject();

								            if (equipmentList == null || equipmentList.isEmpty()) {
								                JOptionPane.showMessageDialog(null, "No equipment found for the specified type",
								                        "Find Equipment Status", JOptionPane.INFORMATION_MESSAGE);
								                logger.info("No equipment found for the specified type");
								                return;
								            }

								            // Process the received list of equipment
								            for (Equipment equipment : equipmentList) {
								                System.out.println("Received Equipment: " + equipment.getEquipmentId() + " " +
								                        equipment.getEquipmentName() + " " + equipment.getStatus() + " " +
								                        equipment.getType() + " " + equipment.getCostPerDay());
								                logger.info("Received Equipment: " + equipment.getEquipmentId() + " " +
							                            equipment.getEquipmentName() + " " + equipment.getStatus() + " " +
							                            equipment.getType() + " " + equipment.getCostPerDay());
								            }
								        }
		} catch (ClassCastException ex) {
            ex.printStackTrace();
        } catch (EOFException eof) {
            System.out.println("Server closed the connection.");
            logger.warn("Server closed the connection.");
            exceptionLogger.warn("Server closed the connection.", eof);
            // Handle the EOFException, e.g., close resources, inform the user, etc.
        } catch (ClassNotFoundException | IOException ex) {
            ex.printStackTrace();
            logger.error("Exception occurred: " + ex.getMessage());
            exceptionLogger.error("Exception occurred", ex);
        }
    }

}
