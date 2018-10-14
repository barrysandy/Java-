package com.xgb.org.chapter22;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
* 文档编辑类-balking 模式之文档编辑
* @author xiaowu
* E-mail:865815412@qq.com
* @version 创建时间：2018年10月10日 下午9:23:51
*/
public class Document 
{
	
	//如果文档发生改变，changed会被设置为true
	private boolean changed;
	
	//一次需要保存的内存，可以理解为内容保存
	private List<String> content = new ArrayList<>();
	
	private final FileWriter writer;
	
	//自动保存文档的线程
	private static AutoSaveThread autoSaveThread;
	
	private Document(String documentPath ,String docmentName) throws IOException
	{
		//java API FileWriter 构造函数：构造一个FileWriter对象，给出一个带有布尔值的文件名，表示是否附加写入的数据。 
		this.writer = new FileWriter(new File(documentPath,docmentName) , true);
	}
	
	/**
	 * 静态方法，主要用于创建文档，顺便启动自动保存文档的线程
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
	
	
	//文档的编辑，其实就是往content队列中提交字符串
	public void edit(String content)
	{
		synchronized(this)
		{
			this.content.add(content);
			//文档改变
			this.changed = true;
		}
	}
	
	/**
	 * 文档关闭的时候首先中断自动保存线程，然后关闭writer释放资源
	 * @throws IOException
	 */
	public void close() throws IOException
	{
		autoSaveThread.interrupt();
		writer.close();
		
	}
	
	/**
	 * save方法用于为外部显示进行文档保存
	 * @throws IOException
	 */
	public void save() throws IOException
	{
		synchronized (this) 
		{
			//balking ,如果文档已经保存了，就直接返回
			if(!changed)
			{
				return;
			}
			System.out.println(Thread.currentThread() + "  execute the save action");
			//将内容写入文档中
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
