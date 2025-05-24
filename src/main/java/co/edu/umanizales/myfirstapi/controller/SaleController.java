package co.edu.umanizales.myfirstapi.controller;



import co.edu.umanizales.myfirstapi.controller.dto.ProductDTO;
import co.edu.umanizales.myfirstapi.controller.dto.SaleDTO;
import co.edu.umanizales.myfirstapi.controller.dto.StoreDTO;
import co.edu.umanizales.myfirstapi.model.*;
import co.edu.umanizales.myfirstapi.service.ParameterService;
import co.edu.umanizales.myfirstapi.service.SaleService;
import co.edu.umanizales.myfirstapi.service.SellerService;
import co.edu.umanizales.myfirstapi.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;
    @Autowired
    private StoreService storeService;
    @Autowired
    private SellerService sellerService;
    @Autowired
    private ParameterService parameterService;

    // Traer todas las ventas
    @GetMapping
    public List<Sale> getAllSales() {
        return saleService.getAllSales();
    }

    // Traer una venta por su código
    @GetMapping("/code/{code}")
    public Sale getSaleByCode(@PathVariable String code) {
        return saleService.getSaleByCode(code);
    }

    // Traer ventas por código de tienda
    @GetMapping("/store/{storeCode}")
    public List<Sale> getSalesByStoreCode(@PathVariable String storeCode) {
        return saleService.getSalesByStoreCode(storeCode);
    }

    // Traer ventas por código de vendedor
    @GetMapping("/seller/{sellerCode}")
    public List<Sale> getSalesBySellerCode(@PathVariable String sellerCode) {
        return saleService.getSalesBySellerCode(sellerCode);
    }

    // Traer ventas por código de producto
    @GetMapping("/product/{productCode}")
    public List<Sale> getSalesByProductCode(@PathVariable String productCode) {
        return saleService.getSalesByProductCode(productCode);
    }

    // Traer ventas por fecha (formato yyyy-MM-dd)
    @GetMapping("/date")
    public List<Sale> getSalesByDate(@RequestParam String date) {
        return saleService.getSalesByDate(date);
    }

    // Ventas nueva
    @PostMapping
    public String addSale (@RequestBody SaleDTO SaleDTO) {
        Store store = storeService.getStoreByCode(SaleDTO.getStoreId());
        Seller seller = sellerService.getSellerByCode(SaleDTO.getSellerId());

        if (store == null || seller == null) {
            return "Tienda o vendedor no encontrados";
        }

        for (ProductDTO prodDTO : SaleDTO.getProducts()) {
            Parameter param = parameterService.getParameterByCode(prodDTO.getCode());
            // Aquí podrías validar o hacer algo con el parámetro
        }


        return "Venta registrada con éxito";
    }
}
