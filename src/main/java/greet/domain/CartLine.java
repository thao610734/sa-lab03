package greet.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data @NoArgsConstructor @AllArgsConstructor
public class CartLine {
    @DBRef
    private Product product;
    private Integer quantity;
}

