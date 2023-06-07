package org.wiley.service;

public class OrderNotFoundException extends  Exception{
        public OrderNotFoundException(String message) {
            super(message);
        }
}
