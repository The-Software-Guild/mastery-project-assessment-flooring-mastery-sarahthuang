package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.Product;
import com.sg.flooringmastery.dto.Tax;
import com.sg.flooringmastery.service.FlooringMasteryPersistenceException;

import java.io.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FlooringMasteryDaoImpl implements FlooringMasteryDao {
    private static String ORDER_FILE = "Orders_06012013.txt";
    private static String PRODUCT_FILE = "Products.txt";
    private static String TAX_FILE = "Taxes.txt";
    private static final String DELIMITER = ",";
    private Map<String, Order> orders = new HashMap<>();
    private Map<String, Product> products = new HashMap<>();
    private Map<String, Tax> taxes = new HashMap<>();
    public FlooringMasteryDaoImpl() {}
    public FlooringMasteryDaoImpl(String orderTextFile) { ORDER_FILE = orderTextFile;}

    @Override
    public Order unmarshallOrder(String line) {
        String[] tokens = line.split(DELIMITER);
        int orderNumber = Integer.parseInt(tokens[0]);
        String customerName = tokens[1];
        String state = tokens[2];
        BigDecimal taxRate = new BigDecimal(tokens[3]);
        String productType = tokens[4];
        BigDecimal area = new BigDecimal(tokens[5]);
        BigDecimal costPerSquareFoot = new BigDecimal(tokens[6]);
        BigDecimal laborCostPerSquareFoot = new BigDecimal(tokens[7]);
        BigDecimal materialCost = new BigDecimal(tokens[8]);
        BigDecimal laborCost = new BigDecimal(tokens[9]);
        BigDecimal tax = new BigDecimal(tokens[10]);
        BigDecimal total = new BigDecimal(tokens[11]);

        Order orderFromFile = new Order(orderNumber, customerName, state, taxRate, productType, area, costPerSquareFoot, laborCostPerSquareFoot, materialCost, laborCost, tax, total);

        return orderFromFile;
    }

    @Override
    public String marshallOrder(Order order) {
        return Integer.toString(order.getOrderNumber()) + DELIMITER +
                order.getCustomerName() + DELIMITER +
                order.getState() + DELIMITER +
                order.getTaxRate() + DELIMITER +
                order.getProductType() + DELIMITER +
                order.getArea() + DELIMITER +
                order.getCostPerSquareFoot() + DELIMITER +
                order.getLaborCost() + DELIMITER +
                order.getMaterialCost() + DELIMITER +
                order.getLaborCost() + DELIMITER +
                order.getTax() + DELIMITER +
                order.getTotal() + "\n";
    }

    public Product unmarshallProduct(String line) {
        String[] tokens = line.split(DELIMITER);
        String productType = tokens[0];
        BigDecimal laborCostPerSquareFoot = new BigDecimal(tokens[1]);
        BigDecimal costPerSquareFoot = new BigDecimal(tokens[2]);
        Product newProduct = new Product(productType, laborCostPerSquareFoot, costPerSquareFoot);
        return newProduct;
    }

    public String marshallProduct(Product product) {
        return product.getProductType() + DELIMITER +
                product.getLaborCostPerSquareFoot().toString() + DELIMITER +
                product.getCostPerSquareFoot().toString() + "\n";
    }

    public Tax unmarshallTax(String line) {
        String[] tokens = line.split(DELIMITER);
        String stateAbbreviation = tokens[0];
        String stateName = tokens[1];
        BigDecimal taxRate = new BigDecimal(tokens[2]);
        Tax newTax = new Tax(stateAbbreviation, stateName, taxRate);
        return newTax;
    }

    public String marshallTax(Tax tax) {
        return tax.getStateAbbreviation() + DELIMITER +
                tax.getStateName() + DELIMITER +
                tax.getTaxRate().toString() + "\n";
    }

    @Override
    public void writeOrderFile(List<Order> list) throws FlooringMasteryPersistenceException {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(ORDER_FILE));
        }
        catch(IOException e)
        {
            throw new FlooringMasteryPersistenceException("Could not save item data", e);
        }

        String itemAsText;
        for (Order currentOrder : orders.values()) {
            itemAsText = marshallOrder(currentOrder);
            out.println(itemAsText);
            out.flush();
        }
        out.close();
    }

    @Override
    public Map<String, Order> readOrderFile(String file) throws FlooringMasteryPersistenceException {
        Scanner scanner;
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ORDER_FILE)));
        }
        catch(FileNotFoundException e)
        {
            throw new FlooringMasteryPersistenceException("File not found", e);
        }

        String currentLine;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            Order currentOrder = unmarshallOrder(currentLine);
            orders.put(Integer.toString(currentOrder.getOrderNumber()), currentOrder);
        }
        scanner.close();
        return orders;
    }

    public Map<String, Product> readProductFile(String productFile) throws FlooringMasteryPersistenceException {
        Scanner scanner;
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(PRODUCT_FILE)));
        }
        catch(FileNotFoundException e)
        {
            throw new FlooringMasteryPersistenceException("File not found", e);
        }

        String currentLine;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            Product currentProduct = unmarshallProduct(currentLine);
            products.put(currentProduct.getProductType(), currentProduct);
        }
        scanner.close();
        return products;
    }

    public Map<String, Tax> readTaxFile(String taxFile) throws FlooringMasteryPersistenceException {
        Scanner scanner;
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(TAX_FILE)));
        }
        catch(FileNotFoundException e)
        {
            throw new FlooringMasteryPersistenceException("File not found", e);
        }

        String currentLine;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            Tax currentTax = unmarshallTax(currentLine);
            taxes.put(currentTax.getStateAbbreviation(), currentTax);
        }
        scanner.close();
        return taxes;
    }

    @Override
    public List<Order> getOrder() {
        return null;
    }

    @Override
    public Order addOrder(String orderNumber, Order order) {

        orders.put(orderNumber, order);
        return order;
    }

    @Override
    public Order removeOrder(Order order, String orderFile) {
        return null;
    }

    public Order editCustomerName(String orderNumber, String newCustomerName) {
        //readFile();
        Order currentOrder = orders.get(orderNumber);
        currentOrder.setCustomerName(newCustomerName);
        //writeFile();
        return currentOrder;
    }

    public Order editState(String orderNumber, String newState) {
        //readFile();
        Order currentOrder = orders.get(orderNumber);
        currentOrder.setState(newState);
        //writeOrderFile();
        return currentOrder;
    }

    public Order editProductType(String orderNumber, String newProductType) {
        //writeFile();
        Order currentOrder = orders.get(orderNumber);
        currentOrder.setProductType(newProductType);
        //writeOrderFile();
        return currentOrder;
    }

    public Order editArea(String orderNumber, BigDecimal newArea) {
        //readFile();
        Order currentOrder = orders.get(orderNumber);
        currentOrder.setArea(newArea);
        //writeFile();
        return currentOrder;
    }
}
