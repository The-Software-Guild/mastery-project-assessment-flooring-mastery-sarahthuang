package com.sg.flooringmastery.ui;

import com.sg.flooringmastery.dto.Order;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class FlooringMasteryView {
    private UserIO io;

    public FlooringMasteryView(UserIO io) {
        this.io = io;
    }

    public void flooringMasteryWelcomeMessage() {
        io.print("**********WELCOME TO THE FLOORING MASTERY APP**********");
    }

    public int displayFlooringMasteryMenuSelection() {
        io.print("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        io.print("* <<Flooring Program>>");
        io.print("* 1. Display Orders");
        io.print("* 2. Add an Order");
        io.print("* 3. Edit an Order");
        io.print("* 4. Remove an Order");
        io.print("* 5. Export All Data");
        io.print("* 6. Quit");
        io.print("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");

        return io.readInt("Please type a number (1 to 6) to select from the menu", 1, 6);
    }

    /****************** Displaying Orders ********************/
    public String promptUserDisplayDate() {
        return io.readString("\nEnter a date in YYYY-MM-DD format to display orders for that date.");
    }

    public void displayOrderList(Map<String, Order> orderList) {
        io.print("OrderNo\t" +
                "Customer Name\t" +
                "State\t" +
                "Tax_Rate\t" +
                "Product_Type\t" +
                "Area\t" +
                "Cost_per_sqft\t" +
                "Laborcost_per_sqft\t" +
                "Material_cost\t" +
                "Labor_cost\t\t" +
                "Tax\t\t" +
                "Total");
        io.print("---------------------------------");
        for (Order order : orderList.values()) {
            String orderInfo = String.format("%s\t\t" + "%s\t" + "%s\t\t" + "%s\t\t" + "%s\t\t" +
                            "%s\t\t" + "%s\t\t\t" + "%s\t\t\t" + "%s\t\t" + "%s\t\t" + "%s\t\t" + "%s\t",
                    Integer.toString(order.getOrderNumber()),
                    order.getCustomerName(),
                    order.getState(),
                    order.getTaxRate(),
                    order.getProductType(),
                    order.getArea(),
                    order.getCostPerSquareFoot(),
                    order.getLaborCostPerSquareFoot(),
                    order.getMaterialCost(),
                    order.getLaborCost(),
                    order.getTax(),
                    order.getTotal());
            io.print(orderInfo);
        }
        io.readString("Please hit enter to continue.");
    }

    /****************** Adding Orders ********************/
    public String promptOrderDate() {
        return io.readString("\nEnter order date: ");
    }

    public String promptCustomerName() {
        return io.readString("\nEnter customer name: ");
    }

    public String promptValidState() {
        return io.readString("\nEnter state in which order is being made: ");
    }

    public String promptProductType() {
        return io.readString("\nEnter product type: ");
    }

    public BigDecimal promptArea() {
        return io.readBigDecimal("\nEnter area (minimum 100 sqft) as a decimal: ");
    }

    public void displayOrderSummaryBanner() {
        io.print("Here is a description of the order you made: ");
    }

    public void displayAddOrderConfirmation() {
        io.print("Does this information look correct to you? Press y to proceed, n to cancel adding your order.");
    }

    public void displayErrorMessage(String message) {
        io.print("==========ERROR==========");
        io.print(message);
        io.print("=========================");
    }
    public boolean toExit() {
        String answer = io.readString("Do you want to exit the Flooring program? (y/n)").toLowerCase();
        if (answer.startsWith("y")) {
            return true;
        } else {
            return false;
        }
    }

    public void print(String message) { io.print(message); }
    public void displayUserResponse() {
        io.print("Would you like to make another selection? y/n");
    }
    public void displayFinalGoodbyeMessage() {
        io.print("GOOD BYE!");
    }
}
