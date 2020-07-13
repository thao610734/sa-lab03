package greet.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data @NoArgsConstructor @AllArgsConstructor
@Document
public class Product {

    @Id
    private String productNumber;
    private String description;
    private Double price;
    private Stock stockInfo;
}
