package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.AuditDao;
import com.sg.flooringmastery.dao.FlooringMasteryDao;
import com.sg.flooringmastery.dao.FlooringMasteryDaoImpl;
import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.Product;
import com.sg.flooringmastery.dto.Tax;

import java.math.BigDecimal;
import java.util.Map;

public class FlooringMasteryServiceImpl implements FlooringMasteryService {
    private AuditDao auditDao;
    private FlooringMasteryDao dao;

    public FlooringMasteryServiceImpl(AuditDao auditDao, FlooringMasteryDao dao) {
        this.auditDao = auditDao;
        this.dao = dao;
    }

    public Map<String, Order> loadOrdersByDate(String date) throws FlooringMasteryPersistenceException {
        Map<String, Order> orders = dao.readOrderFile("unused string");
        return orders;
    }

    public Order addOrder(String orderDate, String customerName, String validState, String productType, BigDecimal area) throws FlooringMasteryPersistenceException {
        FlooringMasteryDao productDao = new FlooringMasteryDaoImpl();
        FlooringMasteryDao taxDao = new FlooringMasteryDaoImpl();
        Map<String, Product> productMap = productDao.readProductFile("unused string");
        Map<String, Tax> taxMap = taxDao.readTaxFile("unused string");

        Order newOrder = new Order();
        newOrder.setCustomerName(customerName);
        newOrder.setState(validState);
        newOrder.setProductType(productType);
        newOrder.setArea(area);
        return newOrder;
    }


}
