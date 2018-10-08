package com.xgb.org.chapter18;

import java.util.concurrent.atomic.AtomicInteger;

public class FutureServiceImpl<IN, OUT> implements FutureService<IN, OUT> {

	//Ϊ�߳�ָ��һ������ǰ׺
	private final static String FUTURE_THREAD_PREFIX = "FUTURE-";
	
	private final AtomicInteger nextCounter = new AtomicInteger(0);
	
	private String getNextName()
	{
		return FUTURE_THREAD_PREFIX + nextCounter.getAndIncrement();
	}
	
	@Override
	public Future<?> submit(Runnable runnable) {

		final FutureTask<Void> future = new FutureTask<>();
		new Thread(()->
		{
			runnable.run();
			//����ִ�н�����null��Ϊ�������future
			future.finish(null);
		}, getNextName()).start() ;
		
		return null;
	}

	@Override
	public Future<OUT> submit(Task<IN, OUT> task, IN input) {

		final FutureTask<OUT> future = new FutureTask<>();
		new Thread(()->
		{
			OUT result = task.get(input);
			//����ִ�н����󣬽���ʵ�Ľ��ͨ��finish�������ݸ�future
			future.finish(result);
		}).start();
		return null;
	}

}
