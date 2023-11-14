package domain;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Generate_Invoice implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String invoice_No;
	private Equiptment equiptment_Id;
	private Customer customer_Id;
	private Customer customer_Name;
	private Customer customer_Address;
	private Equiptment release_Date;
	private Equiptment return_Date;
	private Employee employee_Id;
	private Connection connection;
	private Statement stmt;
	private ResultSet rs;
	Logger logger = LogManager.getLogger(Generate_Invoice.class.getName());
	
	public Generate_Invoice()
	{
		this.invoice_No = "";
		this.employee_Id = new Employee(employee_Id);
		this.customer_Address = new Customer(customer_Address);
		this.customer_Id = new Customer(customer_Id);
		this.customer_Name = new Customer(customer_Name);
		this.equiptment_Id = new Equiptment(equiptment_Id);
		this.release_Date = new Equiptment(release_Date);
		this.return_Date = new Equiptment(return_Date);
		
				
	}
	
	public Generate_Invoice(String invoice_No, Equiptment equiptment_Id, Customer customer_Id, Customer customer_Name,
			Customer customer_Address, Equiptment release_Date, Equiptment return_Date, Employee employee_Id) {
		super();
		this.invoice_No = invoice_No;
		this.equiptment_Id = equiptment_Id;
		this.customer_Id = customer_Id;
		this.customer_Name = customer_Name;
		this.customer_Address = customer_Address;
		this.release_Date = release_Date;
		this.return_Date = return_Date;
		this.employee_Id = employee_Id;
	}



	public String getInvoice_No() {
		return invoice_No;
	}



	public void setInvoice_No(String invoice_No) {
		this.invoice_No = invoice_No;
	}



	public Equiptment getEquiptment_Id() {
		return equiptment_Id;
	}



	public void setEquiptment_Id(Equiptment equiptment_Id) {
		this.equiptment_Id = equiptment_Id;
	}



	public Customer getCustomer_Id() {
		return customer_Id;
	}



	public void setCustomer_Id(Customer customer_Id) {
		this.customer_Id = customer_Id;
	}



	public Customer getCustomer_Name() {
		return customer_Name;
	}



	public void setCustomer_Name(Customer customer_Name) {
		this.customer_Name = customer_Name;
	}



	public Customer getCustomer_Address() {
		return customer_Address;
	}



	public void setCustomer_Address(Customer customer_Address) {
		this.customer_Address = customer_Address;
	}



	public Equiptment getRelease_Date() {
		return release_Date;
	}



	public void setRelease_Date(Equiptment release_Date) {
		this.release_Date = release_Date;
	}



	public Equiptment getReturn_Date() {
		return return_Date;
	}



	public void setReturn_Date(Equiptment return_Date) {
		this.return_Date = return_Date;
	}



	public Employee getEmployee_Id() {
		return employee_Id;
	}



	public void setEmployee_Id(Employee employee_Id) {
		this.employee_Id = employee_Id;
	}



	
	@Override
	public String toString() {
		
		logger.info("[INFO] ------- Generate_Invoice [invoice_No=" + invoice_No + ",equiptment_Id=" + equiptment_Id + ",customer_Id="
						+ customer_Id + ",customer_Name=" + customer_Name + ",release_Date=" + release_Date 
						+ "return_Date=" + return_Date + ",employee_Id=" + employee_Id
						+ "]");
		return "Generate_Invoice [\ninvoice_No=" + invoice_No + ",\nequiptment_Id=" + equiptment_Id + ",\ncustomer_Id="
				+ customer_Id + ",\ncustomer_Name=" + customer_Name + ",\nrelease_Date=" + release_Date 
				+ "\nreturn_Date=" + return_Date + ", \nemployee_Id=" + employee_Id
				+ "]";
		
		
	}

	
	
}
