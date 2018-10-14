package com.xgb.org.chapter22;

import java.io.IOException;
import java.util.Scanner;

/**
* ���̴߳���������������ĵ��༭���̣߳������˽����ԣ�����ʹ���� Scanner
* @author xiaowu
* E-mail:865815412@qq.com
* @version ����ʱ�䣺2018��10��10�� ����9:56:03
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
				//��ȡ�û��ļ�������
				String text = scanner.next();
				if("quit".equals(text))
				{
					document.close();
					break;
				}
				
				//�����ݱ༭��document��
				document.edit(text);
				if(times == 5)
				{
					//�û���������5�κ�����ĵ�����
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
