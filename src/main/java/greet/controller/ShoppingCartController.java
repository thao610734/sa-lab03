package greet.controller;

import greet.domain.ShoppingCart;
import greet.service.ShoppingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class ShoppingCartController {

    private final ShoppingService shoppingService;

    @GetMapping("/{cartId}")
    public ResponseEntity<?> getCart(@PathVariable String cartId) {
        ShoppingCart cart = shoppingService.getCart(cartId);
        if (cart != null)
            return new ResponseEntity<>(cart, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{cartId}/{pNumber}/{qty}")
    public ResponseEntity<?> addToCart(@PathVariable String cartId,
                                       @PathVariable String pNumber,
                                       @PathVariable int qty) {
        shoppingService.addToCart(cartId, pNumber, qty);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
