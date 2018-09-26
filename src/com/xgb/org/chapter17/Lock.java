package com.xgb.org.chapter17;
/**
* Lock接口
* @author xiaowu
* E-mail:865815412@qq.com
* @version 创建时间：2018年9月26日 下午9:37:17
*/
public interface Lock {
	
	//获取显示锁，没有获得锁的线程被阻塞
	void lock() throws InterruptedException;
	
	//释放获取的锁
	void unlock();
}
