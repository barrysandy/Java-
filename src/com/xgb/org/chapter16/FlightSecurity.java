package com.xgb.org.chapter16;
/**
* һ�����̰߳�ȫ�İ�����
* @author xiaowu
* E-mail:865815412@qq.com
* @version ����ʱ�䣺2018��9��26�� ����8:07:56
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
		//�򵥵Ĳ��ԣ����ǼǺ������֤����ĸ����ͬ���ʾ��鲻ͨ��
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
