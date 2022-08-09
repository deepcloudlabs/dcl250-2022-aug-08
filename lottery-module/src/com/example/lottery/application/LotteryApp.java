package com.example.lottery.application;

import java.util.ServiceLoader;

import com.example.lottery.service.business.StandardLotteryService;
import com.example.random.service.RandomNumberService;

public class LotteryApp {

	public static void main(String[] args) {
		var lotteryService = new StandardLotteryService();
		var services = ServiceLoader.load(RandomNumberService.class);
		for (var service : services)
			System.out.println(service.getClass().getSimpleName());
		lotteryService.setRandomNumberService(services.findFirst().get());
		lotteryService.draw(60, 6, 10)
		              .forEach(System.out::println);
	}

}
