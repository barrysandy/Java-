package com.xgb.org.chapter3;

import java.util.concurrent.TimeUnit;

public class Mutex {

	private final static Object MUTEX = new Object();
	
	public void accessResource() {
		synchronized (MUTEX) {
			try {
				System.out.println(Thread.currentThread().getName() + " will be wait!");
				TimeUnit.SECONDS.sleep(3);
				System.out.println(Thread.currentThread().getName() + " will be ending!");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		
		final Mutex mutex = new Mutex();
		for (int i = 0; i < 5; i++) {
			new Thread(mutex::accessResource).start();
		}
	}

}
