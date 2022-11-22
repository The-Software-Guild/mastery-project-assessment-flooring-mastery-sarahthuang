package com.sg.flooringmastery.service;

public class FlooringMasteryPersistenceException extends Exception {
        public FlooringMasteryPersistenceException(String msg){
            super(msg);
        }
        public FlooringMasteryPersistenceException(String msg, Throwable cause){
            super(msg,cause);
        }
}
