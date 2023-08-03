package com.customerService.Customer.Service.domain;

public class Product {
    int productId;
    String productName;
    String productDetails;

    public Product() {
    }

    public Product(int productId, String productName, String productDetails) {
        this.productId = productId;
        this.productName = productName;
        this.productDetails = productDetails;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDetails='" + productDetails + '\'' +
                '}';
    }
}
