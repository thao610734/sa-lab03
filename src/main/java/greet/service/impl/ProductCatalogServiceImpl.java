package greet.service.impl;

import greet.domain.Product;
import greet.domain.Stock;
import greet.repository.ProductRepository;
import greet.service.ProductCatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCatalogServiceImpl implements ProductCatalogService {

    private final ProductRepository productRepository;

    @Override
    public void addProduct(String productnumber, String description, double price) {
        productRepository.save(new Product(productnumber, description, price, null));
    }

    @Override
    public Product getProduct(String productnumber) {
        return productRepository.findById(productnumber).get();
    }

    @Override
    public void setStock(String productnumber, int quantity, String locationcode) {
        Product product = getProduct(productnumber);
        if (product != null) {
            product.setStockInfo(new Stock(quantity, locationcode));
            productRepository.save(product);
        }
    }
}
