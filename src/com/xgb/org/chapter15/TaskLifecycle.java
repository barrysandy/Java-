package com.xgb.org.chapter15;

public interface TaskLifecycle<T> {

	//任务启动时候会触发
	void onStart(Thread thread);
	
	//任务正在运行时会触发
	void onRunning(Thread thread);
	
	//任务运行结束时会触发onFinsh方法，其中result是任务执行结束后的结果
	void onFinsh(Thread thread ,T result);
	
	//当任务执行报错时会触发onError的方法
	void onError(Thread thread);
	
	//生命周期接口的空实现（Adapter）
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
