package com.xgb.org.chapter22;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
* 自动保存document的线程类
* @author xiaowu
* E-mail:865815412@qq.com
* @version 创建时间：2018年10月10日 下午9:49:16
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
