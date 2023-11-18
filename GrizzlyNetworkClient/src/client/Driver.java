package client;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;

import javax.swing.SwingUtilities;

import domain.Customer;
import domain.Employee;
import domain.Equipment;
import domain.Invoice;
import domain.Message;
import domain.RentalRequest;
import domain.ScheduledEquipment;
import domain.Transaction;
import domain.User;
import view.Login;

public class Driver {

	public static void main(String[] args) {
		Client client = new Client();
		
		//NB, USER MUST BE CREATED BEFORE CUSTOMER OR EMPLOYEE
		
		User user = new User("7","Lisa","Lee","Employee");
		Customer customer = new Customer("1","Abriana","Cooper",1234567891,20.55f);
		Employee employee = new Employee("7","Lisa","Henry");
		
		//NB, EQUIPMENT TYPES ARE: STAGING, LIGHTING, POWER AND SOUND
		Equipment equipment = new Equipment("800","Stage Light C", "Lighting","Available", 3000f);
		
		//NB, Customer ID and Equipment ID, must exist before a transaction can be created
		Transaction transaction = new Transaction("T1OO","1","100",Date.valueOf(LocalDate.of(2023, 11, 13)),
												  Date.valueOf(LocalDate.of(2023, 11, 15)),1200f);
		
		//Sender Id and Receiver ID must exist before message can be created
		Message message = new Message("M1", "1", "3", "Is the tall Boom available for Christmas Day?", Timestamp.from(Instant.now()));
		
		//NB, CustomerId, EquipmentId and MessageId must exist before Rental Request can be created
		RentalRequest rentalRequest = new RentalRequest("R1","1","100",Date.valueOf(LocalDate.of(2023, 11, 13)),"M1","Available");
		
		//NB EquipmentID has to exist before scheduledEquipment can be created
		ScheduledEquipment scheduledEquipment = new ScheduledEquipment("S1","E1","100",Date.valueOf(LocalDate.of(2023, 11, 13)),Date.valueOf(LocalDate.of(2023, 11, 13)));
		
		//NB TransactionId need to exist before creating an invoice
		Invoice invoice = new Invoice("I1","T1OO",Date.valueOf(LocalDate.of(2023, 11, 16)),1200f);
		
		        // Start the GUI on the event dispatch thread
		        SwingUtilities.invokeLater(() -> {
		            // Run the login view
		            Login login = new Login();
		            login.setVisible(true);
	 			});
		        
		       
		
		/*
		client.sendAction("Add User");
		System.out.println("Message sent to server");
		client.sendUser(user);
		System.out.println("Record sent to server");
		client.receiveResponse();
		System.out.println("Response received from server");
		
		client.sendAction("Find User");
		client.sendUserId("2");
		client.receiveResponse();
		
		client.closeConnection();
		
		client.sendAction("Add Customer");
		System.out.println("Message sent to server");
		client.sendCustomer(customer);
		System.out.println("Record sent to server");
		client.receiveResponse();
		System.out.println("Response received from server"); 
		
		client.sendAction("Find Customer");
		client.sendCustomerId("1");
		client.receiveResponse();
		
		client.closeConnection();
		
		client.sendAction("Add Employee");
		System.out.println("Message sent to server");
		client.sendEmployee(employee);
		System.out.println("Record sent to server");
		client.receiveResponse();
		System.out.println("Response received from server");
		
		client.sendAction("Find Employee");
		client.sendEmployeeId("2");
		client.receiveResponse();
		
		client.closeConnection();
		
		
		client.sendAction("Find Equipment");
		client.sendEquipmentId("100");
		client.receiveResponse();
		
		client.closeConnection();
		
		
		client.sendAction("Add Message");
		System.out.println("Message sent to server");
		client.sendMessage(message);
		System.out.println("Record sent to server");
		client.receiveResponse();
		System.out.println("Response received from server"); 
		
		client.sendAction("Find Message");
		client.sendMessageId("M1");
		client.receiveResponse();
		
		client.closeConnection();
		
		client.sendAction("Add Rental Request");
		System.out.println("Message sent to server");
		client.sendRentalRequest(rentalRequest);
		System.out.println("Record sent to server");
		client.receiveResponse();
		System.out.println("Response received from server"); 
		
		client.sendAction("Find Rental Request");
		client.sendRentalRequestId("R1");
		client.receiveResponse();
		
		client.closeConnection(); 
		
		client.sendAction("Add Transaction");
		System.out.println("Message sent to server");
		client.sendTransaction(transaction);
		System.out.println("Record sent to server");
		client.receiveResponse();
		System.out.println("Response received from server");
		
		client.sendAction("Find Transaction");
		client.sendTransactionId("T1OO");
		client.receiveResponse();
		
		client.closeConnection();
		
		 client.sendAction("Add Equipment");
		System.out.println("Message sent to server");
		client.sendEquipment(equipment);
		System.out.println("Record sent to server");
		client.receiveResponse();
		System.out.println("Response received from server"); 
		
		client.sendAction("Add Scheduled Equipment");
		System.out.println("Message sent to server");
		client.sendScheduledEquipment(scheduledEquipment);
		System.out.println("Record sent to server");
		client.receiveResponse();
		System.out.println("Response received from server");
		
		client.sendAction("Find Scheduled Equipment");
		client.sendScheduledEquipmentId("S1");
		client.receiveResponse();
		
		client.closeConnection();
		
		client.sendAction("Add Invoice");
		System.out.println("Message sent to server");
		client.sendInvoice(invoice);
		System.out.println("Record sent to server");
		client.receiveResponse();
		System.out.println("Response received from server");
		
		client.sendAction("Find Invoice");
		client.sendInvoiceId("I1");
		client.receiveResponse();
		
		client.closeConnection();*/
	}

}
