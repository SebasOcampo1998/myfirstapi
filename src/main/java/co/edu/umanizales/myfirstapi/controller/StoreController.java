package co.edu.umanizales.myfirstapi.controller;

import co.edu.umanizales.myfirstapi.model.Location;
import co.edu.umanizales.myfirstapi.model.Store;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/store")
public class StoreController {

    @GetMapping
    public String getStore() {
        Store store = new Store ("134","LaExtrella","Calle 21 45 - 43","Manizales","3109875674","Laextrella@gmail.com");


                return "Las tiendas";
    }
}
