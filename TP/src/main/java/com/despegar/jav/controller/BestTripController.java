package com.despegar.jav.controller;

import java.math.BigDecimal;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.despegar.jav.domain.BestTrips;
import com.despegar.jav.domain.ReadServiceException;
import com.despegar.jav.domain.TripDTO;
import com.despegar.jav.domain.User;
import com.despegar.jav.error.MissingParametersError;
import com.despegar.jav.error.NullParametersError;


@Controller
@RequestMapping("/")
public class BestTripController {

	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(BestTripController.class);
	private BestTrips bestTrips;

	public BestTripController(BestTrips bestTrips) {
		this.bestTrips = bestTrips;
	}

	// @RequestMapping(value = "/hello-world", method = {RequestMethod.GET,
	// RequestMethod.POST})
	// @ResponseBody
	// public String hello() {
	// return "Hello World!\n";
	// }
	//

	@RequestMapping(value = "/best-trip", produces = "application/json;charset=UTF-8")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public TripDTO getBestTrips(@RequestParam(value = "from", required = true) String from,
			@RequestParam(value = "money", required = true) BigDecimal money) {
		if ((from == null) || (from.length()<1) || (money == null)) {
			throw new RuntimeException("");
		} else {
			User aUser = new User(money, from);
			return bestTrips.setBestTrips(from, money, aUser);
		}
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public NullParametersError handleCustomExceptions(RuntimeException e) {
		LOGGER.error("One or more parameters is empty", e);
		return new NullParametersError();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MissingServletRequestParameterException.class)
	@ResponseBody
	public MissingParametersError handleCustomExceptions(MissingServletRequestParameterException e) {
		LOGGER.error("One or more parameters is missing", e);
		return new MissingParametersError();
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(ReadServiceException.class)
	@ResponseBody
	public InternalError handleCustomExceptions(ReadServiceException e) {
		LOGGER.error("The URL provided is not responding", e);
		return new InternalError();
	}
}
