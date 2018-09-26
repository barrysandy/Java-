package com.xgb.org.chapter16;
/**
* ����FlightSecurity
* @author xiaowu
* E-mail:865815412@qq.com
* @version ����ʱ�䣺2018��9��26�� ����8:15:02
*/
public class FlightSecurityTest {
	//�ÿ��߳�
	static class Passengers extends Thread{
		//����������
		private final FlightSecurity flightSecurity;
		
		//�ÿ����֤
		private final String idCard;
		
		//�ÿ͵ĵǻ���
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
				//�ÿͲ��ϵĹ�����
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
