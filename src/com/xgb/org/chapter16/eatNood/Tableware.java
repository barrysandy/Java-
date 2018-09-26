package com.xgb.org.chapter16.eatNood;
/**
* 哲学家吃面--餐具类
* @author xiaowu
* E-mail:865815412@qq.com
* @version 创建时间：2018年9月26日 下午8:58:40
*/
public class Tableware {
	
	//餐具名称
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
