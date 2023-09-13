package com.ecommerce.core.exception;

public class MyException extends RuntimeException{
    public MyException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
