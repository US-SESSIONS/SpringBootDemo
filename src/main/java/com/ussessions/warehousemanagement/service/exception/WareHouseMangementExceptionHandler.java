package com.ussessions.warehousemanagement.service.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@ControllerAdvice
//@ResponseBody

@RestControllerAdvice
public class WareHouseMangementExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> exception(Exception exception) {
		ErrorInfo info = new ErrorInfo();
		info.setErrorMessage(exception.getMessage());
		info.setErrorOccuredAt(LocalDateTime.now());
		info.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		info.setExceptionTrace(exception.toString());
		return new ResponseEntity<ErrorInfo>(info, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(SellerNotFoundException.class)
	public ResponseEntity<ErrorInfo> sellerNotFoundException(SellerNotFoundException exception) {
		ErrorInfo info = new ErrorInfo();
		info.setErrorMessage(exception.getMessage());
		info.setErrorOccuredAt(LocalDateTime.now());
		info.setStatusCode(HttpStatus.BAD_REQUEST.value());
		info.setExceptionTrace(exception.toString());
		return new ResponseEntity<ErrorInfo>(info, HttpStatus.BAD_REQUEST);
	}
}
