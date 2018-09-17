package com.xgb.org.chapter8.threadInterface;

/**
 * Runtime的子类，主要用来通知任务提交者，任务队列已经无法在接收新的任务
 * @author XuGongBin
 *
 */
public class RunnableDenyException extends RuntimeException{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = -5720496126623702463L;

	public RunnableDenyException(String message) {
		super(message);
	}

}
