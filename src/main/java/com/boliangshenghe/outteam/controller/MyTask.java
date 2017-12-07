package com.boliangshenghe.outteam.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.boliangshenghe.outteam.service.FlightService;

@Component
public class MyTask {
	
	@Autowired
	private FlightService flightService;

	//0 0/2 * * * ?
	//0 0/10 * * * ?
	// 0 0 0/2 * * ? *
	//5分钟一次
	/**
	 * 这个定时任务60分钟执行一次，更新航班信息
	 */
	@Scheduled(cron = "0 0/60 * * * ?")
	public void taskCycle() {
		// linksController.runTask();
		System.out.println("MyTask start11" +new Date());
		
//		catalogcopyService.insertrecordByTask();
		
	}
	
	/**
	 * 这个定时任务5分钟执行一次，flight表里面省没有数据的更新一下
	 */
	@Scheduled(cron = "0 0/5 * * * ?")
	public void taskCycle2() {
		// linksController.runTask();
		System.out.println("updateFlightStateBytask " +new Date());
		
		flightService.updateFlightStateBytask();
		
	}
}
