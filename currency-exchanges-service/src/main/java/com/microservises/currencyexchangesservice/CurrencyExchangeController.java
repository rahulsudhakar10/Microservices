package com.microservises.currencyexchangesservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservises.currencyexchangesservice.model.ExchangeValue;
import com.microservises.currencyexchangesservice.repoistory.ExchangeCurrencyRepoistory;




@RestController
public class CurrencyExchangeController {
	
	private Logger logger =  LoggerFactory.getLogger(this.getClass()); 
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeCurrencyRepoistory exchangeCurrencyRepoistory;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from,@PathVariable String to) {
		
		ExchangeValue exchangeValue = exchangeCurrencyRepoistory.findByFromAndTo(from,to);
		//int port = Integer.parseInt(environment.getProperty("local.server.port"));
		/*if(port > 0) {
			exchangeValue.setPort(port);	
		}*/
		logger.info("{}",exchangeValue);
		exchangeValue.setPort(8000);
		return exchangeValue;
		
	}

}
