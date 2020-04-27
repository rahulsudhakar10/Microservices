package com.microservises.currencyconverstionservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableFeignClients("com.microservises.currencyconverstionservice")
@EnableDiscoveryClient
public class CurrencyConverstionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConverstionServiceApplication.class, args);
	}
	
	@Bean
	public Sampler deafultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}


}
  