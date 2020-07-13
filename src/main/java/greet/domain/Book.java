package greet.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data @NoArgsConstructor @AllArgsConstructor
@Document
public class Book {

    @Id
    //private String id;
    private String isbn;
    private String title;
    private Double price;
    private String author;
}
