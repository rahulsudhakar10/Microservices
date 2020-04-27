package com.microservises.currencyexchangesservice.repoistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.microservises.currencyexchangesservice.model.ExchangeValue;


@Component
public interface ExchangeCurrencyRepoistory extends JpaRepository<ExchangeValue,Long>{
	ExchangeValue findByFromAndTo(String from, String to);
	
	

}
