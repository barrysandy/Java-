package com.xgb.org.chapter22;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
* �ĵ��༭��-balking ģʽ֮�ĵ��༭
* @author xiaowu
* E-mail:865815412@qq.com
* @version ����ʱ�䣺2018��10��10�� ����9:23:51
*/
public class Document 
{
	
	//����ĵ������ı䣬changed�ᱻ����Ϊtrue
	private boolean changed;
	
	//һ����Ҫ������ڴ棬�������Ϊ���ݱ���
	private List<String> content = new ArrayList<>();
	
	private final FileWriter writer;
	
	//�Զ������ĵ����߳�
	private static AutoSaveThread autoSaveThread;
	
	private Document(String documentPath ,String docmentName) throws IOException
	{
		//java API FileWriter ���캯��������һ��FileWriter���󣬸���һ�����в���ֵ���ļ�������ʾ�Ƿ񸽼�д������ݡ� 
		this.writer = new FileWriter(new File(documentPath,docmentName) , true);
	}
	
	/**
	 * ��̬��������Ҫ���ڴ����ĵ���˳�������Զ������ĵ����߳�
	 * @param documentPath
	 * @param docmentName
	 * @return
	 * @throws IOException
	 */
	public static Document create(String documentPath ,String docmentName) throws IOException
	{
		Document document = new Document(documentPath, docmentName);
		autoSaveThread = new AutoSaveThread(document);
		autoSaveThread.start();
		return document;
	}
	
	
	//�ĵ��ı༭����ʵ������content�������ύ�ַ���
	public void edit(String content)
	{
		synchronized(this)
		{
			this.content.add(content);
			//�ĵ��ı�
			this.changed = true;
		}
	}
	
	/**
	 * �ĵ��رյ�ʱ�������ж��Զ������̣߳�Ȼ��ر�writer�ͷ���Դ
	 * @throws IOException
	 */
	public void close() throws IOException
	{
		autoSaveThread.interrupt();
		writer.close();
		
	}
	
	/**
	 * save��������Ϊ�ⲿ��ʾ�����ĵ�����
	 * @throws IOException
	 */
	public void save() throws IOException
	{
		synchronized (this) 
		{
			//balking ,����ĵ��Ѿ������ˣ���ֱ�ӷ���
			if(!changed)
			{
				return;
			}
			System.out.println(Thread.currentThread() + "  execute the save action");
			//������д���ĵ���
			for (String cacheLine : content) 
			{
				this.writer.write(cacheLine);
				this.writer.write("\r\n");
				this.writer.flush();
				this.changed = false;
				this.content.clear();
			}
			
		}
	}
}
