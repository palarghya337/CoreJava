package com.corejava.practice.multithreading;

public class WhyWaitFromLoop {

	public static void main(String[] args) {
		
		DummyClass obj = new WhyWaitFromLoop().new DummyClass();
		Thread t1 = new Thread(() -> System.out.println(obj.getValue()));
		Thread t2 = new Thread(() -> obj.addNumberWithValue(5, 5));
		t1.start();
		t2.start();
	}
	
	private class DummyClass {
		
		private volatile boolean flag;
		private Integer value;
		
		public DummyClass() {
			value = new Integer(5);
		}
		public Integer getValue() {

			String name = Thread.currentThread().getName();
			synchronized (this) {

				System.out.println("getValue() Locked by - " + name);
				System.out.println("getValue() before wait call...");
				if (!flag) {
					try {
						/*
						 * Calling wait within if condition that means it
						 * will check for flag is false or not only once.
						 * in case if thread which is calling this method
						 * wakes up or get a chance to execute when flag
						 * condition still false, it will do post wait
						 * operations because we are not writing wait inside
						 * while loop.
						 **/
						wait();
					} catch (InterruptedException e) {
						System.out.println(e.getMessage());
					}
				}
				System.out.println("getValue() after wait call...");
			}
			System.out.println("getValue() released lock by - " + name);
			System.out.println("flag value: " + flag);
			return value;
		}
		/**
		 * Method to add particular number with the value field
		 * by number of times given in the parameter "time".
		 * 
		 * @param number to add with the value field
		 * @param time number of time to add with the value field.
		 */
		public void addNumberWithValue(Integer number, int time) {

			String name = Thread.currentThread().getName();
			while (time --> 0) {
				synchronized (this) {

					System.out.println("addition() Locked by - " + name);
					value = value + number;
					/*
					 * After each addition I am calling notifyAll()
					 * method because in this way other thread who
					 * are calling getValue() method will get a chance to
					 * get the value if condition satisfies.
					 **/
					notifyAll();
				}
				System.out.println("addition() released lock by - " + name);
			}
			flag = true;
		}
	}
}
