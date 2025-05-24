package co.edu.umanizales.myfirstapi.controller.dto;

import co.edu.umanizales.myfirstapi.controller.dto.ProductDTO;
import co.edu.umanizales.myfirstapi.model.Product;
import co.edu.umanizales.myfirstapi.model.Seller;
import co.edu.umanizales.myfirstapi.model.Store;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data

public class SaleDTO {
    private LocalDate dateSale;
    private String storeId;
    private String sellerId;
    private int quantity;
    private List<ProductDTO> products;
    private String code;
}