package com.xgb.org.chapter15;

public class ObservableThread<T> extends Thread implements Observable {
	
	private final TaskLifecycle<T> lifecycle;
	
	private final Task<T> task;
	
	private Cycle cycle;
	
	//ָ��Task��ʵ�֣�Ĭ�������ʹ��EmptyLifeCycle
	public ObservableThread(Task<T> task) {
		this (new TaskLifecycle.EmptyLifecycle<>() , task);
	}
	
	//ָ��TaskLifecycle��ͬʱָ��Task
	public ObservableThread(TaskLifecycle<T> lifecycle, Task<T> task) {
		super();
		if(task == null) {
			throw new IllegalArgumentException("The Task is required.");
		}
		this.lifecycle = lifecycle;
		this.task = task;
	}

	@Override
	public final void run() {
		//��ִ���߳��߼���Ԫ��ʱ�򣬷ֱ𴥷���Ӧ���¼�
		this.update(Cycle.STARTRD, null, null);
		try {
			this.update(Cycle.STARTRD , null , null);
			
			T result = this.task.call();
			this.update(Cycle.DENO, result, null);
		} catch (Exception e) {
			this.update(Cycle.ERROR, null, e);
		}
		
	}

	private void update(Cycle cycle, T result, Exception e) 
	{
		this.cycle = cycle;
		if(lifecycle == null) {
			return;
		}
		
		try {
			switch (cycle) 
			{
				case STARTRD :
					this.lifecycle.onStart(currentThread());
					break;
				case RUNING:
					this.lifecycle.onRunning(currentThread());
					break;
				case DENO:
					this.lifecycle.onFinsh(currentThread(), result);
					break;
				case ERROR:
					this.lifecycle.onError(currentThread());
					break;
			}
		} catch (Exception ex) {
			if(cycle == Cycle.ERROR) {
				throw ex;
			}
		}
		
	}

	@Override
	public Cycle getCycle() {
		return this.cycle;
	}
	
	public static void main(String[] args) {
		
		Observable observableThread = new ObservableThread<>(null);
		observableThread.start();
	}

}
