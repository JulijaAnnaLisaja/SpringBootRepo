package com.example.weathernew.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ExceptionResponse {
        private Date timestamp; // error time
        private String message; // error name
        private String details; // error details

        public ExceptionResponse(Date timestamp, String message, String details) {
            super();
            this.timestamp = timestamp;
            this.message = message;
            this.details = details;
        }

}
