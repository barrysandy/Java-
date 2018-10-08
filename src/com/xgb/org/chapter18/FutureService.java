package com.xgb.org.chapter18;

public interface FutureService<IN,OUT> 
{
	//�ύ����Ҫ����ֵ������Future.get�������صĽ�����null
	Future<?> submit(Runnable runnable);
	
	//�ύ��Ҫ����ֵ����������Task�ӿڴ�����Runnable
	Future<OUT> submit(Task<IN,OUT> task,IN input);
	
	static <T,R> FutureService<T,R> newService()
	{
		return new FutureServiceImpl<>();
	}
}
