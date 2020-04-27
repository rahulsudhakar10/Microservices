package com.microservises.currencyconverstionservice.repoistory;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservises.currencyconverstionservice.model.CurrencyConversionBean;


//@FeignClient(name="currency-exchange-service")
@FeignClient(name="netflix-zuul-api-gateway")
@RibbonClient(name="currency-exchange-service")
@Component
public interface CurrencyExchangeService {
	
	//@GetMapping("/currency-exchange/from/{from}/to/{to}")
	//API gateway
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from,@PathVariable("to") String to);

}