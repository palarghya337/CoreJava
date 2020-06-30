package com.corejava.practice.multithreading;

import java.util.Timer;
import java.util.TimerTask;

public class ShutDownHookExample {

	public static void main(String[] args) {
		/*
		 * Shutdown Hooks are a special construct that allows
		 * developers to plug in a piece of code to be executed
		 * when the JVM is shutting down. This comes in handy
		 * in cases where we need to do special clean up
		 * operations before the VM is shutting down.
		 * 
		 * Shut down hook will not work for situations where
		 * the VM is shutting down due to an external reason
		 * (ex. kill request from O/S), or due to a resource
		 * problem (out of memory) or calling System.exit(0);
		 **/
		// System.exit(0);
		
		Runtime.getRuntime().addShutdownHook(new Thread(
				() -> System.out.println("Shut Down Hook Called")));
		
		someOtherOperations();
		System.out.println("Main method Ends");
	}

	private static void someOtherOperations() {

		System.out.println("Other operations started");
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			private int count = 0;
			@Override
			public void run() {

				System.out.print(".");
				if (++count == 10) {
					timer.cancel();
					System.out.println("\nOther operations ended");
				}
			}
		}, 2000, 500);
	}
}
