package com.xgb.org.chapter16.eatNood;
/**
* ��ѧ�ҳ���-- �Ľ���
* @author xiaowu
* E-mail:865815412@qq.com
* @version ����ʱ�䣺2018��9��26�� ����9:11:08
*/
public class TableWarePair {
	private final Tableware leftTool;
	
	private final Tableware rightTool;
	
	public TableWarePair(Tableware leftTool,Tableware rightTool)
	{
		this.leftTool = leftTool;
		this.rightTool = rightTool;
	}
	
	public Tableware getLeftTool()
	{
		return leftTool;
	}
	
	public Tableware getRightTool()
	{
		return rightTool;
	}
}
