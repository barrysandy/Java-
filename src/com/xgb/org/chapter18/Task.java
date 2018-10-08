package com.xgb.org.chapter18;

public interface Task <IN,OUT>
{
	//给定一个参数，经过计算返回值结果
	OUT get(IN input);
}
