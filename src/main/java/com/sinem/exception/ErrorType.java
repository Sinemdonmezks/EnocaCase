package com.sinem.exception;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {
    INTERNAL_ERROR(2000, "Internal Server Error", INTERNAL_SERVER_ERROR),
    BAD_REQUEST_ERROR(2001, "Invalid Parameter Error", BAD_REQUEST),
    ENTITY_NOT_SAVED(2002, "Invalid Parameter Error", BAD_REQUEST),

    EMPYOLEE_NOT_CREATED(2003, "Invalid Parameter Error", BAD_REQUEST),
    COMPANY_NOT_CREATED(2004, "Invalid Parameter Error", BAD_REQUEST),
    EMPYOLEE_NOT_UPDATED(2005, "Invalid Parameter Error", BAD_REQUEST),
    COMPANY_NOT_UPDATED(2006, "Invalid Parameter Error", BAD_REQUEST),
    EMPYOLEE_NOT_FOUND(2007, "Invalid Parameter Error", BAD_REQUEST),
    COMPANY_NOT_FOUND(2008, "Invalid Parameter Error", BAD_REQUEST);

    private int code;
    private String message;
    HttpStatus httpStatus;

}