package com.xgb.org.chapter8.threadInterface;

/**
 * 拒绝策略
 * @author XuGongBin
 *
 */
@FunctionalInterface
public interface DenyPolicy {
	
	//拒绝方法
	void reject(Runnable runnable,ThreadPool threadPool);
	
	//该拒绝策略会直接将任务丢弃
	class DiscardDenyPolicy implements DenyPolicy{

		@Override
		public void reject(Runnable runnable, ThreadPool threadPool) {
			//do nothing
			
		}
		
	}
	
	//该拒绝策略会向任务提交者抛出异常
	class AbortDenyPolicy implements DenyPolicy{

		@Override
		public void reject(Runnable runnable, ThreadPool threadPool) {
			throw new RunnableDenyException("The Runnable " + runnable + " will abort." );
		}
		
	}
	
	
	//该拒绝策略会使任务在提交者所在的线程中执行任务
	class RunnableDenyPolicy implements DenyPolicy{

		@Override
		public void reject(Runnable runnable, ThreadPool threadPool) {
			if(!threadPool.isShutdown()) {
				runnable.run();
			}
			
		}
		
	}
	
	
}
