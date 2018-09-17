package com.xgb.org.chapter3;

import java.util.concurrent.TimeUnit;

public class ThreadInterrupt2 {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(){
			@Override
			public void run() {
				while(true) {
					//do nothing ,just empty loop.
					System.out.printf("I am be interruput ? %s\n" , interrupted());
				}
//				try {
//					TimeUnit.SECONDS.sleep(3);
//				} catch (InterruptedException e) {
//					System.out.printf("I am be interruput ? %s\n" , this.isInterrupted());
//				}
				
			}
		};
		thread.setDaemon(true);
		thread.start();
		
		TimeUnit.SECONDS.sleep(1);
		//System.out.printf("Thread is interruput ? %s\n" , thread.isInterrupted());
		thread.interrupt();
		//TimeUnit.SECONDS.sleep(2);
		//System.out.printf("Thread is interruput ? %s\n" , thread.isInterrupted());
	}

}
