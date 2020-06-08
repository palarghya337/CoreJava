package com.corejava.practice.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * In this class we will see how to serialize and deserialize
 * data of a transient variable.
 * @author Bittu
 *
 */
public class SerializeDataOfTransient {

	public static void main(String[] args) {
		
		DummySerialization obj = new DummySerialization("TestName");
		obj.setFirstTransient(10);
		obj.setSecondTrandient(20);
		
		System.out.println("Before Serialization: ");
		System.out.println(obj);
		
		String serializedObj = SerializationUtil
				.writeObject(obj);
		System.out.println("After Serialization: ");
		System.out.println(serializedObj);
		
		DummySerialization deserializedObj = SerializationUtil
				.deserializeObject(serializedObj);
		System.out.println("After Deserialization: ");
		System.out.println(deserializedObj);
	}
	
}
class DummySerialization implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private transient int firstTransient;
	private transient int secondTrandient;
	private String name;
	
	public DummySerialization(String name) {
		this.name = name;
	}
	public int getFirstTransient() {
		return firstTransient;
	}
	public void setFirstTransient(int firstTransient) {
		this.firstTransient = firstTransient;
	}
	public int getSecondTrandient() {
		return secondTrandient;
	}
	public void setSecondTrandient(int secondTrandient) {
		this.secondTrandient = secondTrandient;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private void writeObject(ObjectOutputStream output)
			throws IOException {
		
		output.defaultWriteObject();
		output.writeInt(firstTransient);
		output.writeInt(secondTrandient);
	}
	private void readObject(ObjectInputStream input)
			throws ClassNotFoundException, IOException {
		
		input.defaultReadObject();
		firstTransient = input.readInt();
		secondTrandient = input.readInt();
	}
	@Override
	public String toString() {
		return "DummySerialization [firstTransient=" + firstTransient + ", secondTrandient=" + secondTrandient
				+ ", name=" + name + "]";
	}
}
