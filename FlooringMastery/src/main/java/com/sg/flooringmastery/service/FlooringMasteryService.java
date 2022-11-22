package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dto.Order;

import java.math.BigDecimal;
import java.util.Map;

public interface FlooringMasteryService {

    public Map<String, Order> loadOrdersByDate(String date) throws FlooringMasteryPersistenceException;

    Order addOrder(String orderDate, String customerName, String validState, String productType, BigDecimal area) throws FlooringMasteryPersistenceException;
}
