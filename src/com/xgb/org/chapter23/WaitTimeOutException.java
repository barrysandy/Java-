package com.xgb.org.chapter23;
/**
* 等待超时异常
* @author xiaowu
* E-mail:865815412@qq.com
* @version 创建时间：2018年10月13日 上午10:16:50
*/
public class WaitTimeOutException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5881587268998158039L;

	public WaitTimeOutException (String message)
	{
		super(message);
	}
}
