package co.edu.umanizales.myfirstapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Sale {
    private LocalDate dateSale;
    private Store store;
    private Seller seller;
    private int quantity;
    private List<Product> products;
    private String code;


}
