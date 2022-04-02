package com.cadastro.cadastro.exception.handler;

import lombok.*;

import java.util.Date;

@Data
@Builder
public class ErrorMessageException {

    private int statusCode;

    private Date time;

    private String message;

    private String description;
}
