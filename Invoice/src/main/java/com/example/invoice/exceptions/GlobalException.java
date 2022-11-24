

package com.example.invoice.exceptions;

import org.springframework.stereotype.Component;

@Component
public class GlobalException extends RuntimeException {

    private String errorMessage;

    public GlobalException(String errorMessage) {

        this.errorMessage = errorMessage;
    }

    public GlobalException() {
    }


    public String getErrorMessage() {
        return this.errorMessage;
    }


}
