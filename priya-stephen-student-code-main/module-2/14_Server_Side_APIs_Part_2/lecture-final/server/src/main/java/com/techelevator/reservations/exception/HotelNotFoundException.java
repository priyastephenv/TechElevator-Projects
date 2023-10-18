package com.techelevator.reservations.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.SEE_OTHER, reason = "Hotel id not found")
public class HotelNotFoundException extends RuntimeException {



}
