package co.edu.umanizales.myfirstapi.controller;

import co.edu.umanizales.myfirstapi.model.Sale;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/sale")
public class SaleController {

    @GetMapping
    public String getSale(){
        Sale sale = new Sale("Empanadas", (byte) 50 ,500000,"Marzo 30 de 2025");

        return "Las Venta";
    }
}
