package com.xgb.org.chapter17;
/**
* ��д������
* @author xiaowu
* E-mail:865815412@qq.com
* @version ����ʱ�䣺2018��9��28�� ����8:32:31
*/
public class ReadWriteLockTest {
	private final static String text  = "Thisistheexampleforreadwritelock";

	public static void main(String[] args) {
		
		//���干����Դ
		final ShareData shareData = new ShareData(50);
		//���������߳̽��ж�д����
		for (int i = 0; i < 2; i++) {
			new Thread(()->{
				for (int index = 0; index < text.length(); index++) {
					try {
						char c = text.charAt(index);
						shareData.write(c);
						System.err.println(Thread.currentThread() +  " write " + c);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
		
		//����10���߳̽��ж�ȡ���ݲ���
		for (int i = 0; i < 10; i++) {
			new Thread(()->{
				while(true){
					try {
						System.out.println(Thread.currentThread() + " read " + new String(shareData.read()));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
		}

	}

}
