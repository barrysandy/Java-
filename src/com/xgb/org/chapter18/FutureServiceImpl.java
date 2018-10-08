package com.xgb.org.chapter18;

import java.util.concurrent.atomic.AtomicInteger;

public class FutureServiceImpl<IN, OUT> implements FutureService<IN, OUT> {

	//为线程指定一个名字前缀
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
			//任务执行结束后将null作为结果传给future
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
			//任务执行结束后，将真实的结果通过finish方法传递给future
			future.finish(result);
		}).start();
		return null;
	}

}
