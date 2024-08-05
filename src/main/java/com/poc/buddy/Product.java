package com.poc.buddy;

public class Product {

    private String sku;
    private String bikeName;
    private Double average;

    public Product(String sku, String bikeName, Double average) {
        this.sku = sku;
        this.bikeName = bikeName;
        this.average = average;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getBikeName() {
        return bikeName;
    }

    public void setBikeName(String bikeName) {
        this.bikeName = bikeName;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }
}
