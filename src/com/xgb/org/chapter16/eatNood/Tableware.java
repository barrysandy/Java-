package com.xgb.org.chapter16.eatNood;
/**
* ��ѧ�ҳ���--�;���
* @author xiaowu
* E-mail:865815412@qq.com
* @version ����ʱ�䣺2018��9��26�� ����8:58:40
*/
public class Tableware {
	
	//�;�����
	private final String toolName;
	
	public Tableware(String toolName)
	{
		this.toolName = toolName;
	}
	
	@Override
	public String toString() {
		return "Tool: " + toolName;
	}
}
