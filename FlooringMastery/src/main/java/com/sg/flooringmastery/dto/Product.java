package com.sg.flooringmastery.dto;

import java.math.BigDecimal;

public class Product {
    private String productType;
    private BigDecimal laborCostPerSquareFoot;
    private BigDecimal costPerSquareFoot;

    public Product(String productType, BigDecimal laborCostPerSquareFoot, BigDecimal costPerSquareFoot) {
        this.productType = productType;
        this.laborCostPerSquareFoot = laborCostPerSquareFoot;
        this.costPerSquareFoot = costPerSquareFoot;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getLaborCostPerSquareFoot() {
        return laborCostPerSquareFoot;
    }

    public void setLaborCostPerSquareFoot(BigDecimal laborCostPerSquareFoot) {
        this.laborCostPerSquareFoot = laborCostPerSquareFoot;
    }

    public BigDecimal getCostPerSquareFoot() {
        return costPerSquareFoot;
    }

    public void setCostPerSquareFoot(BigDecimal costPerSquareFoot) {
        this.costPerSquareFoot = costPerSquareFoot;
    }
}
