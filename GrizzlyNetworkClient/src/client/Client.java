package client;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import javax.swing.JOptionPane;

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
	
	public Client() {
		this.createConnection();
		this.configureStreams();
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
	
	public void receiveResponse() {
		try {
			if(action.equalsIgnoreCase("Add User")) {
				Boolean flag = (Boolean) objIs.readObject();
				if( flag == true) {
					JOptionPane.showMessageDialog(null, "Record added successfully",
							"Add Record Status",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			if(action.equalsIgnoreCase("Find User")) {
				User user = new User();
				user = (User)objIs.readObject();
				if(user == null) {
					JOptionPane.showMessageDialog(null, "Record could not be found",
							"Find Record Status", JOptionPane.ERROR_MESSAGE);
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
				}
			}
				if(action.equalsIgnoreCase("Find Customer")) {
					Customer customer = new Customer();
					customer = (Customer)objIs.readObject();
					if(customer == null) {
						JOptionPane.showMessageDialog(null, "Record could not be found",
								"Find Record Status", JOptionPane.ERROR_MESSAGE);
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
					}
				}
					if(action.equalsIgnoreCase("Find Employee")) {
						Employee employee = new Employee();
						employee = (Employee)objIs.readObject();
						if(employee == null) {
							JOptionPane.showMessageDialog(null, "Record could not be found",
									"Find Record Status", JOptionPane.ERROR_MESSAGE);
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
						}
					}
						if(action.equalsIgnoreCase("Find Equipment")) {
							Equipment equipment = new Equipment();
							equipment = (Equipment)objIs.readObject();
							if(equipment == null) {
								JOptionPane.showMessageDialog(null, "Record could not be found",
										"Find Record Status", JOptionPane.ERROR_MESSAGE);
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
							}
						}
							if(action.equalsIgnoreCase("Find Transaction")) {
								Transaction transaction = new Transaction();
								transaction = (Transaction)objIs.readObject();
								if(transaction == null) {
									JOptionPane.showMessageDialog(null, "Record could not be found",
											"Find Record Status", JOptionPane.ERROR_MESSAGE);
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
								}
							}
								if(action.equalsIgnoreCase("Find Message")) {
									Message message = new Message();
									message = (Message)objIs.readObject();
									if(message == null) {
										JOptionPane.showMessageDialog(null, "Record could not be found",
												"Find Record Status", JOptionPane.ERROR_MESSAGE);
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
								}
							}
								if(action.equalsIgnoreCase("Find Rental Request")) {
									RentalRequest rentalRequest = new RentalRequest();
									rentalRequest = (RentalRequest)objIs.readObject();
									if(rentalRequest == null) {
										JOptionPane.showMessageDialog(null, "Record could not be found",
												"Find Record Status", JOptionPane.ERROR_MESSAGE);
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
									}
								}
									if(action.equalsIgnoreCase("Find Scheduled Equipment")) {
										ScheduledEquipment scheduledEquipment = new ScheduledEquipment();
										scheduledEquipment = (ScheduledEquipment)objIs.readObject();
										if(scheduledEquipment == null) {
											JOptionPane.showMessageDialog(null, "Record could not be found",
													"Find Record Status", JOptionPane.ERROR_MESSAGE);
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
										}
									}
										if(action.equalsIgnoreCase("Find Invoice")) {
											Invoice invoice = new Invoice();
											invoice = (Invoice)objIs.readObject();
											if(invoice == null) {
												JOptionPane.showMessageDialog(null, "Record could not be found",
														"Find Record Status", JOptionPane.ERROR_MESSAGE);
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
								                return;
								            }

								            // Process the received list of equipment
								            for (Equipment equipment : equipmentList) {
								                System.out.println("Received Equipment: " + equipment.getEquipmentId() + " " +
								                        equipment.getEquipmentName() + " " + equipment.getStatus() + " " +
								                        equipment.getType() + " " + equipment.getCostPerDay());
								            }
								        }
		} catch (ClassCastException ex) {
			ex.printStackTrace();
		} catch (EOFException eof) {
	        System.out.println("Server closed the connection.");
	        // Handle the EOFException, e.g., close resources, inform the user, etc.
	    } catch (ClassNotFoundException | IOException ex) {
	        ex.printStackTrace();
	    }
	}
}
