package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.Product;
import com.sg.flooringmastery.dto.Tax;
import com.sg.flooringmastery.service.FlooringMasteryPersistenceException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface FlooringMasteryDao {
    public Order unmarshallOrder(String line);
    public String marshallOrder(Order order);
    public void writeOrderFile(List<Order> list) throws FlooringMasteryPersistenceException;
    public Map<String,Order> readOrderFile(String file) throws FlooringMasteryPersistenceException;
    public Map<String, Product> readProductFile(String productFile) throws FlooringMasteryPersistenceException;
    public Map<String, Tax> readTaxFile(String taxFile) throws FlooringMasteryPersistenceException;
    List<Order> getOrder();
    Order addOrder(String orderNumber, Order order);
    Order removeOrder(Order order, String orderFile);
    Order editCustomerName(String orderNumber, String newCustomerName);
    Order editState(String orderNumber, String newState);
    Order editProductType(String orderNumber, String newProductType);
    Order editArea(String orderNumber, BigDecimal newArea);
}
