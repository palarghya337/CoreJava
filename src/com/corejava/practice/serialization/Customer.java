package com.corejava.practice.serialization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.math.BigInteger;

/**
 * Like {@linkplain Serializable}, {@linkplain Externalizable} is not a marker interface.
 * Externalizable has two methods {@link #writeExternal(ObjectOutput)} and
 * {@link #readExternal(ObjectInput)}.
 * <br> • When any class in Java implements {@linkplain Externalizable}, then it is your
 * responsibility to implement Serialization process i.e. preserving all important information.
 * <br> • you have full control over Serialization process.
 * @author Bittu
 *
 */
public class Customer implements Externalizable {

	private int age;
	private String name;
	private String dateOfBirth;
	private String gender;
	private String id;
	private String address;
	private BigInteger mobileNumber;
	
	public Customer() {
		// Default constructor
	}
	
	public Customer(String id, String name, String gender,
			String dateOfBirth, String address, BigInteger mobileNumber) {
		
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.age = 24; // Assuming age of the customer is 24
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		
		out.writeObject(id);
		out.writeObject(name);
		out.writeObject(gender);
		out.writeObject(dateOfBirth);
		out.writeObject(address);
		out.writeObject(mobileNumber);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		
		this.id = (String) in.readObject();
		this.name = (String) in.readObject();
		this.gender = (String) in.readObject();
		this.dateOfBirth = (String) in.readObject();
		this.address = (String) in.readObject();
		this.mobileNumber = (BigInteger) in.readObject();
	}

	public int getAge() {
		return age;
	}

	public BigInteger getMobileNumber() {
		return mobileNumber;
	}

	public String getName() {
		return name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public String getId() {
		return id;
	}

	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "Customer [age=" + age + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender
				+ ", id=" + id + ", address=" + address + ", mobileNumber=" + mobileNumber + "]";
	}
}
