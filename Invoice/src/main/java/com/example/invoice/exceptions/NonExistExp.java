

package com.example.invoice.exceptions;

public class NonExistExp extends RuntimeException {
    public NonExistExp(String message) {
        super(message);
    }
}
