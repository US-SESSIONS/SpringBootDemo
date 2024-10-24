package com.ussessions.warehousemanagement.service.exception;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class ErrorInfo {
private String errorMessage;
private LocalDateTime errorOccuredAt;
private String exceptionTrace;
private Integer statusCode;
}
