package com.xgb.org.chapter15;

public interface TaskLifecycle<T> {

	//��������ʱ��ᴥ��
	void onStart(Thread thread);
	
	//������������ʱ�ᴥ��
	void onRunning(Thread thread);
	
	//�������н���ʱ�ᴥ��onFinsh����������result������ִ�н�����Ľ��
	void onFinsh(Thread thread ,T result);
	
	//������ִ�б���ʱ�ᴥ��onError�ķ���
	void onError(Thread thread);
	
	//�������ڽӿڵĿ�ʵ�֣�Adapter��
	class EmptyLifecycle<T> implements TaskLifecycle<T>{

		@Override
		public void onStart(Thread thread) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onRunning(Thread thread) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFinsh(Thread thread, T result) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onError(Thread thread) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
