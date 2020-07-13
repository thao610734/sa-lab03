package greet.controller;

import greet.domain.Product;
import greet.domain.Stock;
import greet.service.ProductCatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/catalog")
@RequiredArgsConstructor
public class ProductCatalogController {

    private final ProductCatalogService catalogService;

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        catalogService.addProduct(product.getProductNumber(), product.getDescription(), product.getPrice());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{pNumber}")
    public ResponseEntity<?> getProduct(@PathVariable String pNumber) {
        Product result =  catalogService.getProduct(pNumber);
        if (result != null)
            return new ResponseEntity<>(result, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{pNumber}")
    public ResponseEntity<?> setStock(@PathVariable String pNumber, @RequestBody Stock stock) {
        catalogService.setStock(pNumber, stock.getQuantity(), stock.getLocationCode());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
