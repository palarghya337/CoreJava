package com.corejava.practice.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;

public final class SerializationUtil {

	private SerializationUtil() {}
	
	/**
	 * @param <T>
	 * @param object
	 * @return serialized object in string format
	 */
	public static <T extends Serializable> String writeObject(T object) {
		
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
	
	/**
	 * @param <T>
	 * @param serializedObj in a string format
	 * @return T deserialized object
	 */
	@SuppressWarnings("unchecked")
	public static <T> T deserializeObject(String serializedObj) {
		
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
}
