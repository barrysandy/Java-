package com.xgb.org.chapter22;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
* �Զ�����document���߳���
* @author xiaowu
* E-mail:865815412@qq.com
* @version ����ʱ�䣺2018��10��10�� ����9:49:16
*/
public class AutoSaveThread extends Thread
{

	private final Document document;
	
	public AutoSaveThread(Document document)
	{
		super("DocumentAutoSavceThread");
		this.document = document;
	}
	
	@Override
	public void run() 
	{
		while(true)
		{
			try 
			{
				document.save();
				TimeUnit.SECONDS.sleep(2);
			} catch (IOException | InterruptedException e) 
			{
				break;
			}
			
		}
	}
}
