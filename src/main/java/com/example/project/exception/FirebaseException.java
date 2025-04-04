package com.example.project.exception;

public class FirebaseException extends RuntimeException {
    public FirebaseException(String message, Throwable e) {
        super(message, e);
    }
}
