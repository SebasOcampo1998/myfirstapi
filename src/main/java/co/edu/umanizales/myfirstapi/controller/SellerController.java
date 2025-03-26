package co.edu.umanizales.myfirstapi.controller;

import co.edu.umanizales.myfirstapi.model.Location;
import co.edu.umanizales.myfirstapi.model.Seller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/seller")
public class SellerController {

    @GetMapping
    public String getSeller() {
        Seller sebas = new Seller("67001", "Sebastian", "Ocampo", 'M', (byte) 26,"Manizales");
        Seller dayana = new Seller("67002", "Dayana", "Rendon", 'F', (byte) 22,"Manizales");
        Seller orfa = new Seller("67003", "Orfa","Sanchez", 'F', (byte) 56, "Manizales");
        Seller angely = new Seller("67004", "Angely", "Ospina", 'F', (byte) 33,"Manizales");
        Seller ferney = new Seller("67005","Ferney","Ocampo", 'M', (byte) 42,"Manizales");


// En char se debe utilizar 'M' y no se utiliza "M"


        return "Clientes";
    }
}
