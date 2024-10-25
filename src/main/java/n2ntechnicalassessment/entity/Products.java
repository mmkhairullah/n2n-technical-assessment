package n2ntechnicalassessment.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "products")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Products extends BaseEntity {

//    @Column(name = "id")
//    private Long id;

    @Column(name = "book_title")
    private String bookTitle;

    @Column(name = "book_price")
    private String bookPrice;

    @Column(name = "book_quantity")
    private Integer bookQuantity;

}
