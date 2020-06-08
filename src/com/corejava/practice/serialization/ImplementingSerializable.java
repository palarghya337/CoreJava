package com.corejava.practice.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;

public class ImplementingSerializable {

	public static void main(String[] args) {
		
		SerializableTemp object = new SerializableTemp();
		object.setSomeData("Sub class data");
		object.setSuperClassData("Super Class Data");
		object.setAggregation(new Aggregation("Aggregation object"));
		
		System.out.println("Before Serialization: ");
		System.out.println(object);
		
		String serializedObj = writeObject(object);
		System.out.println("After Serialization: ");
		System.out.println(serializedObj);
		
		SerializableTemp deserializedObj = deserializeObject(serializedObj);
		System.out.println("After Deserialization: ");
		System.out.println(deserializedObj);
	}

	@SuppressWarnings("unchecked")
	private static <T> T deserializeObject(String serializedObj) {
		
		byte[] byteArr = Base64.getDecoder()
				.decode(serializedObj);
		try (ByteArrayInputStream in = new ByteArrayInputStream(byteArr);
				ObjectInputStream input = new ObjectInputStream(in);) {
			return (T) input.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static String writeObject(SerializableTemp object) {
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try (ObjectOutputStream output = new ObjectOutputStream(out);) {
			output.writeObject(object);
			return Base64.getEncoder()
					.encodeToString(out.toByteArray());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
/**
 * <p>
 * If super class is not serialized then also serialization
 * possible for sub class. However super class data can not
 * be stored in that case. To store data for super class we
 * need to serialize super class as well.
 * </p>
 * <p>
 * When another object is present inside this class (Aggregation)
 * and that object does not implements Serializable interface
 * then serialization is not possible for this class. All
 * the object reference inside current class need to implement
 * {@linkplain Serializable} interface.
 * </p>
 * @author Bittu
 *
 */
class SerializableTemp extends SuperClass implements Serializable {
	
	/**
	 * This id will be used to deserialize this object. If
	 * id is not present then JVM runtime will generate
	 * a serialVersionUID and associate it with the class. 
	 */
	private static final long serialVersionUID = -6930284705663959240L;
	private String someData;
	private Aggregation aggregation;
	
	public SerializableTemp() {}
	public String getSomeData() {
		return someData;
	}

	public void setSomeData(String someData) {
		this.someData = someData;
	}
	public Aggregation getAggregation() {
		return aggregation;
	}
	public void setAggregation(Aggregation aggregation) {
		this.aggregation = aggregation;
	}
	@Override
	public String toString() {
		return "SerializableTemp [someData=" + someData +
				", aggregation=" + aggregation + "] "
				+ super.toString();
	}
}
class SuperClass {
	
	private String superClassData;
	public SuperClass() {}
	public String getSuperClassData() {
		return superClassData;
	}
	public void setSuperClassData(String superClassData) {
		this.superClassData = superClassData;
	}
	@Override
	public String toString() {
		return "SuperClass [superClassData=" + superClassData + "]";
	}
}
class Aggregation implements Serializable {
	
	/**
	 * This id will be used to deserialize this object. If
	 * id is not present then JVM runtime will generate
	 * a serialVersionUID and associate it with the class. 
	 */
	private static final long serialVersionUID = -4326227409082699839L;
	private String data;
	public Aggregation(String data) {
		this.data = data;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Aggregation [data=" + data + "]";
	}
}