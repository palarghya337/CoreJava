package com.corejava.practice.multithreading;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;

import com.corejava.practice.utils.Log;

public final class DetectDeadLock {

	private DetectDeadLock() {
	}
	public static void findDeadLockedThreads() {
		
		ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();
		long[] deadLockedThreads = mxBean.findDeadlockedThreads();
		Log.logInfo("{0} thread(s) is/are locked.{1}",
				deadLockedThreads.length, Arrays.toString(deadLockedThreads));
	}
	public static void findMonitorDeadlockedThreads() {
		
		ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();
		long[] deadLockedThreads = mxBean.findMonitorDeadlockedThreads();
		Log.logInfo("{0} thread(s) is/are locked.{1}",
				deadLockedThreads.length, Arrays.toString(deadLockedThreads));
	}
}
