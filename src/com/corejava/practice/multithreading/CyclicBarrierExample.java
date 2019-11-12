package com.corejava.practice.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import com.corejava.practice.utils.Log;

public class CyclicBarrierExample {

	public static void main(String[] args) {

		int numberOfThreads = 4;
		List<Integer> data = new CopyOnWriteArrayList<>();
		CyclicBarrierExample example = new CyclicBarrierExample();
		BarrierActionTask actionTask = example.new BarrierActionTask(data);
		CyclicBarrier barrier = new CyclicBarrier(numberOfThreads, actionTask);
		ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
		executorService.execute(example.new CBTask(data, barrier));
		executorService.execute(example.new CBTask(data, barrier));
		executorService.execute(example.new CBTask(data, barrier));
		executorService.execute(example.new CBTask(data, barrier));
		executorService.shutdown();
		Log.logInfo("Main method finished");
	}
	private class BarrierActionTask implements Runnable {
		
		private List<Integer> data;
		
		public BarrierActionTask(List<Integer> data) {
			this.data = data;
		}
		
		@Override
		public void run() {
			
			if (Objects.nonNull(data)) {
				
				int sumOfAll = data.stream().mapToInt(i -> i).sum();
				Log.logInfo("Sum of all is {0}", sumOfAll);
			}
		}
	}
	private class CBTask implements Runnable {
		
		private CyclicBarrier barrier;
		private List<Integer> data;
		private Random router = new Random();
		
		public CBTask(List<Integer> data, CyclicBarrier barrier) {
			this.data = data;
			this.barrier = barrier;
		}
		@Override
		public void run() {
			
			if (Objects.nonNull(data)) {
				
				List<Integer> localData = new ArrayList<>();
				IntStream.range(0, 5).forEach(i -> localData.add(router.nextInt(15)));
				int sumOfAll = localData.stream().mapToInt(i -> i).sum();
				Log.logInfo("{0} = {1}", localData, sumOfAll);
				data.addAll(localData);
				try {
					barrier.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					Log.logInfo(e.getMessage());
					Thread.currentThread().interrupt();
				}
			}
		}
	}
}
