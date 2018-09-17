package com.xgb.org.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ThreadJoin {
	public static void main(String[] args) {
		//1
		List<Thread> threads = new ArrayList<>();
		Thread thread1 = create(1);
		Thread thread2 = create(2);
		threads.add(thread1);
		threads.add(thread2);
		
		//2
		for (int i = 0; i < threads.size(); i++) {
			threads.get(i).start();
		}
		
		//3
/*		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}*/
		
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + "#"  + i);
			shortSleep();
		}
	}
	
	private static Thread create(int seq) {
		return new Thread(()->{
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName() + "#"  + i);
				shortSleep();
			}
		}); 
	}
	private static void shortSleep() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
