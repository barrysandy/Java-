package com.xgb.org.chapter3;

import java.util.concurrent.TimeUnit;

public class ThreadInterrupt {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(()-> {
			try {
				TimeUnit.MINUTES.sleep(1);
			} catch (InterruptedException e) {
				System.err.println("Oh, i am be interrupted.");
			}
		});
		thread.setDaemon(true);
		thread.start();
		
		TimeUnit.MILLISECONDS.sleep(2);
		System.out.printf("Thread is interruput ? %s\n" , thread.isInterrupted());
		thread.interrupt();
		TimeUnit.MILLISECONDS.sleep(2);
		System.out.printf("Thread is interruput ? %s\n" , thread.isInterrupted());
	}

}
