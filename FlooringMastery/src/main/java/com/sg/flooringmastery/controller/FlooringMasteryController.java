package com.sg.flooringmastery.controller;
import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.service.FlooringMasteryPersistenceException;
import com.sg.flooringmastery.service.FlooringMasteryService;
import com.sg.flooringmastery.ui.FlooringMasteryView;
import com.sg.flooringmastery.ui.UserIO;
import com.sg.flooringmastery.ui.UserIOImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class FlooringMasteryController {
    private FlooringMasteryView view;
    private FlooringMasteryService service;
    public FlooringMasteryController(FlooringMasteryView view, FlooringMasteryService service) {
        this.view = view;
        this.service = service;
    }

    public void run() throws FlooringMasteryPersistenceException {
        displayWelcomeBanner();
        boolean keepGoing = true;
        int menuSelection = 0;

        while (keepGoing) {
            menuSelection = getMenuSelection();
            switch (menuSelection) {
                case 1:
                    displayOrders();
                    break;
                case 2:
                    addOrder();
                    break;
                case 3:
                    editOrder();
                    break;
                case 4:
                    removeOrder();
                    break;
                case 5:
                    exportAllOrders();
                    break;
                case 6:
                    keepGoing = false;
                    break;
                default:
                    view.print("UNKNOWN COMMAND");
            }
        }
    }
    public void displayWelcomeBanner() {
        view.flooringMasteryWelcomeMessage();
    }

    public void displayOrders() throws FlooringMasteryPersistenceException {
        //TODO
        //When should I read product/tax files into maps (in dao)?
        String date = view.promptUserDisplayDate();
        Map<String, Order> orderList = service.loadOrdersByDate(date);
        //TODO: capture date and find file
        view.displayOrderList(orderList);
    }

    public void addOrder() throws FlooringMasteryPersistenceException {
        // read from (lastOrderIdFile.txt to get last orderId), += 1, write new number back to file
        // create order object,
        // append to orderMap
        // write orderMap to file
        String orderDate = view.promptOrderDate();
        String customerName = view.promptCustomerName();
        String validState = view.promptValidState();
        String productType = view.promptProductType();
        BigDecimal area = new BigDecimal(String.valueOf(view.promptArea()));
        service.addOrder(orderDate, customerName, validState, productType, area);
    }

    public void editOrder() {
        System.out.println("to be implemented!");
    }

    public void removeOrder() {
        System.out.println("to be implemented!");
    }

    public void exportAllOrders() {
        System.out.println("to be implemented!");
    }
    public int getMenuSelection() {
        return view.displayFlooringMasteryMenuSelection();
    }

    private void displayFinalMessage() {
        view.displayFinalGoodbyeMessage();
    }
}
