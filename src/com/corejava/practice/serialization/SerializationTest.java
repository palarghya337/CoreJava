package com.corejava.practice.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;

import com.corejava.practice.utils.Log;

public class SerializationTest {

	public static void main(String[] args) {
		
		Customer customer1 = new Customer("CUSID-1", "Customer-1",
				"GenderCustomer-1", "DateOfBirthCustomer-1", "AddressCustomer-1",
				BigInteger.valueOf(9876543210L));
		String outputFileName = "src//com//corejava//practice//serialization//ExternalizableTest.txt";
		writeCustomer(customer1, outputFileName);
		Customer cus = readCustomer(outputFileName);
		Log.logInfo(cus);
	}
	/**
	 * @param customer
	 * @param outputFileName
	 */
	private static void writeCustomer(Customer customer, String outputFileName) {
		
		try (FileOutputStream fos = new FileOutputStream(outputFileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			
			oos.writeObject(customer);
		} catch (FileNotFoundException e) {
			Log.logInfo("Exception while creating FileOutputStream object.\n{0}", e);
		} catch (IOException e) {
			Log.logInfo("Exception while creating ObjectOutputStream object.\n{0}", e);
		}
	}
	/**
	 * @param fileName
	 * @return Customer
	 */
	private static Customer readCustomer(String fileName) {
		
		try (FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)) {
				
			return (Customer) ois.readObject();
		} catch (FileNotFoundException e) {
			Log.logInfo("Exception while creating FileInputStream object.\n{0}", e);
		} catch (IOException e) {
			Log.logInfo("Exception while creating ObjectInputStream object.\n{0}", e);
		} catch (ClassNotFoundException e) {
			Log.logInfo("Exception while reading the class.\n{0}", e);
		}
		return null;
	}
}
