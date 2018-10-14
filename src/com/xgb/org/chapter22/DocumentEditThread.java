package com.xgb.org.chapter22;

import java.io.IOException;
import java.util.Scanner;

/**
* 该线程代表的是主动进行文档编辑的线程，增加了交互性，我们使用了 Scanner
* @author xiaowu
* E-mail:865815412@qq.com
* @version 创建时间：2018年10月10日 下午9:56:03
*/
public class DocumentEditThread extends Thread
{
	
	private final String documentPath;
	
	private final String documentName;
	
	private final Scanner scanner = new Scanner(System.in);
	
	public DocumentEditThread(String documentPath,String documentName)
	{
		super("DocumentEditThread");
		this.documentPath = documentPath;
		this.documentName = documentName;
	}
	
	@Override
	public void run() 
	{
		int times = 0;
		
		Document document;
		try 
		{
			document = Document.create(documentPath, documentName);
			while(true)
			{
				//获取用户的键盘输入
				String text = scanner.next();
				if("quit".equals(text))
				{
					document.close();
					break;
				}
				
				//将内容编辑到document中
				document.edit(text);
				if(times == 5)
				{
					//用户在输入了5次后进行文档保存
					document.save();
					times = 0;
				}
				times++;
			}
		} catch (IOException e) 
		{
			throw new RuntimeException(e);
		}
	}
}
