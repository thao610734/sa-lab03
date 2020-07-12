package greet.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Book {

    private String isbn;
    private String title;
    private Double price;
    private String author;
}
