package greet.service.impl;

import greet.domain.CartLine;
import greet.domain.Product;
import greet.domain.ShoppingCart;
import greet.repository.ProductRepository;
import greet.repository.ShoppingCartRepository;
import greet.service.ShoppingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShoppingServiceImpl implements ShoppingService {

    private final ShoppingCartRepository cartRepository;
    private final ProductRepository productRepository;

    @Override
    public void addToCart(String cartId, String productnumber, int quantity) {
        Product product = productRepository.findById(productnumber).get();
        if (product == null) return;
        ShoppingCart cart = getCart(cartId);
        if (cart == null) {
            cart = new ShoppingCart();
            cart.setCartId(cartId);
            cart.setCreatedAt(LocalDateTime.now());
            List<CartLine> details = new ArrayList<>();
            details.add(new CartLine(product, quantity));
            cart.setDetails(details);
        } else {
            Optional<CartLine> p = cart.getDetails().stream()
                    .filter(e -> e.getProduct().getProductNumber().equals(productnumber))
                    .findFirst();
            if (p.isPresent()) {
                p.get().setQuantity(p.get().getQuantity() + quantity);
            } else {
                cart.getDetails().add(new CartLine(product, quantity));
            }
        }
        cartRepository.save(cart);
    }

    @Override
    public ShoppingCart getCart(String cartId) {
        Optional<ShoppingCart> cart = cartRepository.findById(cartId);
        if (cart.isPresent()) return cart.get();
        return null;
    }
}
