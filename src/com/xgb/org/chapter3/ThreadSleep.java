package com.xgb.org.chapter3;

import java.util.concurrent.TimeUnit;

public class ThreadSleep {
	public static void main(String[] args) {
		new Thread(()->{
			long starTime = System.currentTimeMillis();
			sleep(2_000L);
			long endTime = System.currentTimeMillis();
			System.out.println(String.format("Total spend %d ms", (endTime - starTime)));
		}).start();
		
		long starTime = System.currentTimeMillis();
		sleep(2_000L);
		
		long endTime = System.currentTimeMillis();
		System.out.println(String.format("Main Thread Total spend %d ms", (endTime - starTime)));
		
		
	}

	private static void sleep(long ms) {
		try {
			//Thread.sleep(ms);
			TimeUnit.HOURS.sleep(0);
			TimeUnit.MINUTES.sleep(0);
			TimeUnit.SECONDS.sleep(2);
			TimeUnit.MILLISECONDS.sleep(88);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
