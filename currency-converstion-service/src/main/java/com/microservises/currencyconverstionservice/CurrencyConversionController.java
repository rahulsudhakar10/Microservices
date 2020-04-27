package com.microservises.currencyconverstionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.microservises.currencyconverstionservice.model.CurrencyConversionBean;
import com.microservises.currencyconverstionservice.repoistory.CurrencyExchangeService;

@RestController
public class CurrencyConversionController {
	
	private Logger logger =  LoggerFactory.getLogger(this.getClass()); 
	
	@Autowired
	private CurrencyExchangeService proxy;
	
	@GetMapping("/currency-convertor/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean retrieveConversionValue(@PathVariable String from,
			@PathVariable String to,@PathVariable BigDecimal quantity) {
		
		
		Map<String, String> UriMap= new HashMap<String, String>();
		UriMap.put("from", from);
		UriMap.put("to", to);
		
		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{}/to/{}"
				,CurrencyConversionBean.class,UriMap);
		
		CurrencyConversionBean response = responseEntity.getBody();
		
		
		logger.info("{}",response);
		if(response == null) {
			return new CurrencyConversionBean(10L,from,to,BigDecimal.ONE,quantity,quantity,0);
		}
		
		return new CurrencyConversionBean(response.getId(),from,to,BigDecimal.ONE,quantity,quantity,0);
	}
		
	
	@GetMapping("/currency-convertor-proxy/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean retrieveConversionValue2(@PathVariable String from,
			@PathVariable String to,@PathVariable BigDecimal quantity) {
		
		System.out.println("hello");
		
		CurrencyConversionBean response = proxy.retrieveExchangeValue(from, to);
		if(response == null)
			return null;
		
		return new CurrencyConversionBean(response.getId(),from,to,BigDecimal.ONE,quantity,quantity,0);
	}
	

}
