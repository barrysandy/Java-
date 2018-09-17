package com.xgb.org.chapter3.closeThread;

import java.util.concurrent.TimeUnit;

public class InterruputThreadExit {

	public static void main(String[] args) throws InterruptedException {
		
		Thread t = new Thread()
		{
			@Override
			public void run() {
				System.out.println("I will start work");
				while(!isInterrupted()) {
					//working.
				}
				System.out.println("I will be exiting.");
			}
		};
		t.start();
		System.out.println(t.getPriority());
		TimeUnit.SECONDS.sleep(1);
		System.out.println("System will be shutdown.");
		t.interrupt();
		
	}

}
