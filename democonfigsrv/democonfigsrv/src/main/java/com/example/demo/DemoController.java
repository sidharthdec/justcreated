package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@RequestMapping(value = "/hello", method= RequestMethod.GET, produces="application/json")
	public ResponseEntity<?> hello(){
		return new ResponseEntity<String>(null, null, null);
	}
}
