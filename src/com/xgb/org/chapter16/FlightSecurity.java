package com.xgb.org.chapter16;
/**
* 一个非线程安全的安检类
* @author xiaowu
* E-mail:865815412@qq.com
* @version 创建时间：2018年9月26日 下午8:07:56
*/
public class FlightSecurity {

	private int count = 0;
	
	private String boardingPass = "null";
	
	private String idCard = "null";
	
	public void pass(String boardingPass,String idCard)
	{
		this.boardingPass = boardingPass;
		this.idCard = idCard;
		this.count++;
		check();
	}

	private void check() 
	{
		//简单的测试，当登记号与身份证首字母不相同则表示检查不通过
		if(boardingPass.charAt(0) != idCard.charAt(0)){
			throw new RuntimeException("=====Exception=====" + toString());
		}
	}
	
	@Override
	public String toString() {
		return "The" + count + " passengers,boardingPass [" + boardingPass +
				"],idCard [" + idCard + "]" ;
	}
}
