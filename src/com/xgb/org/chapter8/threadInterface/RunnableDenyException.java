package com.xgb.org.chapter8.threadInterface;

/**
 * Runtime�����࣬��Ҫ����֪ͨ�����ύ�ߣ���������Ѿ��޷��ڽ����µ�����
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
