package co.edu.umanizales.myfirstapi.model;


import co.edu.umanizales.myfirstapi.model.Parameter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class Product extends Parameter{
    private double price;
    private int stock;
    private Parameter typeProduct;


    public Product(String code,
                   String description,
                   double price,
                   Parameter typeProduct) {


        super(code, description);

        this.price = price;

        this.typeProduct = typeProduct;

    }
}
