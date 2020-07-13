package greet.service;

import greet.domain.ShoppingCart;

public interface ShoppingService {

    void addToCart(String cartId, String productnumber, int quantity);
    ShoppingCart getCart(String cartId);

}
