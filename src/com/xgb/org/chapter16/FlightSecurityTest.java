package com.xgb.org.chapter16;
/**
* 测试FlightSecurity
* @author xiaowu
* E-mail:865815412@qq.com
* @version 创建时间：2018年9月26日 下午8:15:02
*/
public class FlightSecurityTest {
	//旅客线程
	static class Passengers extends Thread{
		//机场安检类
		private final FlightSecurity flightSecurity;
		
		//旅客身份证
		private final String idCard;
		
		//旅客的登机牌
		private final String boardingPass;
		
		public Passengers(FlightSecurity flightSecurity,String idCard,String boardingPass)
		{
			this.flightSecurity = flightSecurity;
			this.idCard = idCard;
			this.boardingPass = boardingPass;
			
		}
		
		@Override
		public void run() 
		{
			while(true)
			{
				//旅客不断的过安检
				flightSecurity.pass(boardingPass, idCard);
			}
		}
	}
	
	public static void main(String[] args) {
		final FlightSecurity flightSecurity = new FlightSecurity();
		new Passengers(flightSecurity, "A123456", "AF123456").start();
		new Passengers(flightSecurity, "B123456", "BF123456").start();
		new Passengers(flightSecurity, "C123456", "CF123456").start();
		
	}
}
