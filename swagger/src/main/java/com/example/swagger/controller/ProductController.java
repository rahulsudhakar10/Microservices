package com.example.swagger.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/product")
 public class ProductController {

	@ApiOperation(value = "View a list of available products", response = Iterable.class)
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public String list(Model model) {
		
		
		return "hello world";

	}

}
