package com.xgb.org.chapter17;
/**
* 读写锁测试
* @author xiaowu
* E-mail:865815412@qq.com
* @version 创建时间：2018年9月28日 下午8:32:31
*/
public class ReadWriteLockTest {
	private final static String text  = "Thisistheexampleforreadwritelock";

	public static void main(String[] args) {
		
		//定义共享资源
		final ShareData shareData = new ShareData(50);
		//创建两个线程进行读写操作
		for (int i = 0; i < 2; i++) {
			new Thread(()->{
				for (int index = 0; index < text.length(); index++) {
					try {
						char c = text.charAt(index);
						shareData.write(c);
						System.err.println(currentThread() +  " write " + c);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
		
		//创建10个线程进行读取数据操作
		for (int i = 0; i < 10; i++) {
			new Thread(()->{
				while(true){
					try {
						System.out.println(currentThread() + " read " + new String(shareData.read()));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
		}

	}

	private static String currentThread() {
		
		return "1111";
	}

}
