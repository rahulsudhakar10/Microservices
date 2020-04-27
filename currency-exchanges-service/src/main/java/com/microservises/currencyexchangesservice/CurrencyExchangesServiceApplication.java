package com.microservises.currencyexchangesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableDiscoveryClient
public class CurrencyExchangesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangesServiceApplication.class, args);
	}
	
	@Bean
	public Sampler deafultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}


}
