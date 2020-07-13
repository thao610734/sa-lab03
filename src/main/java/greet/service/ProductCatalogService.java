package greet.service;

import greet.domain.Product;

public interface ProductCatalogService {
    void addProduct(String productnumber, String description, double price);
    Product getProduct(String productnumber);
    void setStock(String productnumber, int quantity, String locationcode);
}
